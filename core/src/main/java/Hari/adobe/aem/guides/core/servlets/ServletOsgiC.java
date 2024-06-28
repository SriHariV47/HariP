package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import Hari.adobe.aem.guides.core.osgiconfiguration.MyServletConfig;


@Component(service = Servlet.class,immediate = true)
@SlingServletPaths(value = "/bin/apps/demodbhd")
@Designate(ocd =MyServletConfig.class)
public class ServletOsgiC extends SlingAllMethodsServlet {

    private String name;

    @Activate
    protected void activate(MyServletConfig config) {
        name = config.getName();
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      //  out.println("<h2>Hello  " + name + "!</h2>");
          out.println("<h2>" +  "Hello sai :"+ "<a href=' " + name +" '> " + name + "!</a>" + " </h2>");
        response.getWriter().write("Hello sai :"+ "<a href=' " + name +" '> " + name + "!</a>");

    }
}



