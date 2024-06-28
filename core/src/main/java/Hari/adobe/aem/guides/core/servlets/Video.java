package Hari.adobe.aem.guides.core.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/apps/demoexorgnoeinbnb/fdcgvbnm")
public class Video extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String videoId = "GhPfzZ67kak"; 	// Extract video ID from the YouTube URL

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Embedded YouTube Video</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Embedded YouTube Video</h2>");
        out.println("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");
        out.println("</body>");
        out.println("</html>");
            
    }
}

