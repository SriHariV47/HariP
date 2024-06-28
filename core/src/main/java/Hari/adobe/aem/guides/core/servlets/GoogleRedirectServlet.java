package Hari.adobe.aem.guides.core.servlets;

import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Google Redirect Servlet",
                "sling.servlet.methods=" + "GET",
                "sling.servlet.paths=" + "/bin/google-redirect"
        })
public class GoogleRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String googleLink = "https://www.google.com/";
        response.sendRedirect(googleLink);
    }
}
