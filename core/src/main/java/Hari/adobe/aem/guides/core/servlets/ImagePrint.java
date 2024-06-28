package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

                                                        
@Component(service = Servlet.class)
@SlingServletPaths(value ="/bin/apps/demoex")
public class ImagePrint extends SlingSafeMethodsServlet {

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type based on the image type
        response.setContentType("image/jpeg"); // Change this according to your image type

        // Fetch the image from the external URL
        try (InputStream inputStream = new URL("https://wallpapercave.com/wp/wp753797.jpg").openStream();
             ServletOutputStream outputStream = response.getOutputStream()) {

            // Write the binary data to the output stream
            inputStream.transferTo(outputStream);
        }
    }
}      

 


