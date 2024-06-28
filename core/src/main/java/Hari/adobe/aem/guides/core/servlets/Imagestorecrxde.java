package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

//@WebServlet(
//        name = "ImageUploadServlet",
//        urlPatterns = "/content/myapp/image-upload",
//       methods = { HttpConstants.METHOD_POST }
//)
@Component(service = Servlet.class)
public class Imagestorecrxde extends SlingSafeMethodsServlet {

    @Reference
    private ResourceResolverFactory resolverFactory;

    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Ensure that this servlet is used for handling POST requests only

        // Get the input stream of the uploaded image
        try (InputStream inputStream = request.getInputStream()) {
            // Get a service user resource resolver
            Map<String, Object> authInfo = new HashMap<>();
            authInfo.put(ResourceResolverFactory.SUBSERVICE, "image-uploader-service"); 

            ResourceResolver resolver = resolverFactory.getServiceResourceResolver(authInfo);

            // Get the JCR session
            Session session = resolver.adaptTo(Session.class);

            // Create a new node for the image under the specified path
            String parentNodePath = "/content/dam/myapp"; // Change this path as needed
            Node parentNode = session.getNode(parentNodePath);

            // Create a unique name for the image node (you might want to improve this logic)
            String imageName = "uploaded_image_" + System.currentTimeMillis();
            Node imageNode = parentNode.addNode(imageName, "nt:file");
            Node contentNode = imageNode.addNode("jcr:content", "nt:resource");

            // Set the binary data to the content node
            Binary binary = session.getValueFactory().createBinary(inputStream);
            contentNode.setProperty("jcr:data", binary);
            contentNode.setProperty("jcr:mimeType", "image/jpeg");

            // Save the changes
            session.save();

            // Send a success response
            response.getWriter().write("Image uploaded successfully.");
        } catch (LoginException | RepositoryException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading image");
        }
    }
}

