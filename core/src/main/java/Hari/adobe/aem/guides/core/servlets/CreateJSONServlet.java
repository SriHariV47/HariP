package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = {Servlet.class},
property = {
        Constants.SERVICE_DESCRIPTION + "=Create JSON file servlet",
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/createjsonfile",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=[GET,POST]"
})

public class CreateJSONServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonData = new JSONObject();
        try {
            // Sample JSON data
            jsonData.put("name", "John Doe");
            jsonData.put("age", 30);
            jsonData.put("city", "New York");

            out.println(jsonData.toString());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
}
