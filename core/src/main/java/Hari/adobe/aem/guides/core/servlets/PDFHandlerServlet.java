package Hari.adobe.aem.guides.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import com.day.cq.dam.api.AssetManager;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/mypdfhandler")
public class PDFHandlerServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try (InputStream pdfStream = request.getInputStream()) {
            if(pdfStream != null) {
                String currentPageUrl = request.getHeader("Current-Page-URL");
                
                AssetManager assetManager = request.getResourceResolver().adaptTo(AssetManager.class);

                // Define the path in the DAM where the PDF will be stored
                String damPath = getFinalPathFromUrl(currentPageUrl);

                // Create a unique name for the PDF to avoid conflicts
                String pdfName = getLastPartFromUrl(currentPageUrl);

                // Use the AssetManager to create the asset
                assetManager.createAsset(damPath + "/" + pdfName, pdfStream, "application/pdf", true);
              

                response.getWriter().write("PDF saved to DAM As : " + pdfName+"\nat :"+ damPath);
            } else {
                response.getWriter().write("No PDF received");
            }
        } catch (Exception e) {
            response.sendError(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private String getLastPartFromUrl(String url) {
        String[] urlParts = url.split("/");
        return urlParts[urlParts.length - 1].replaceAll("\\.html", "");
    }

    private String getFinalPathFromUrl(String url) {
        String withoutProtocol = url.substring(url.indexOf("/content"));
        String dampath=withoutProtocol.replace("/content", "/content/dam");
        return dampath.replaceAll("/[^/]*$", "");
    }
}
