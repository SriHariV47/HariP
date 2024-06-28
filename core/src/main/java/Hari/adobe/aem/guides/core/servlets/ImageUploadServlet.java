package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;

@Component(
        service = {Servlet.class},
        property = {
                ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/upload/image",
                ServletResolverConstants.SLING_SERVLET_METHODS + "=POST" 
        }
)
public class ImageUploadServlet extends SlingAllMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUploadServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        // Get the collection of parts (files) from the request
        Collection<Part> fileParts = request.getParts();

        // Check if no files were uploaded
        if (fileParts.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("No files uploaded");
            return;
        }

        // Get the session to interact with the JCR repository
        Session session = request.getResourceResolver().adaptTo(Session.class);

        try {
            // Get the AssetManager
            AssetManager assetManager = request.getResourceResolver().adaptTo(AssetManager.class);

            if (assetManager != null) {
                for (Part filePart : fileParts) {
                    // Get the input stream of the uploaded file
                    InputStream inputStream = filePart.getInputStream();

                    // Create a new asset node for the uploaded image
					String fileName = filePart.getSubmittedFileName();
					String mimeType = filePart.getContentType();
					Asset asset = assetManager.createAsset("/content/dam/Hari/" + fileName, inputStream, mimeType, true);

					// Close the input stream
					inputStream.close();
                }

                // Save the session
                session.save();

                // Send success response
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Images uploaded successfully");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("AssetManager not available");
            }
        } catch (RepositoryException e) {
            LOGGER.error("Error uploading images", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error uploading images: " + e.getMessage());
        } finally {
            // Logout the session
            if (session != null) {
                session.logout();
            }
        }
    }
}
