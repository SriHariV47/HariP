package Hari.adobe.aem.guides.core.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/apps/imageServlet")
public class Laptopimage extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png"); // Set content type as image

        // Path to the image file on your local system
        String imagePath = "C:\\Users\\svara\\OneDrive\\Pictures\\Screenshots\\Screenshot (482).png";

        File imageFile = new File(imagePath);

        if (imageFile.exists()) {
            try (FileInputStream fis = new FileInputStream(imageFile);
                 OutputStream os = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } else {
            response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
        }
    }
}
