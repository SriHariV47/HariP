package Hari.adobe.aem.guides.core.servlets;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

@Component(
        service = {Servlet.class},
        property = {
                ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/er/edf"
        }
)
public class GetJsonDataServletEnpage extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("https://gorest.co.in/public/v2/todos");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);

                // Check if response is an array, sometimes the API might return an array instead of an object
                if (responseBody.startsWith("[")) {
                    // Convert JSON array to JSONArray
                    JSONArray jsonArray = new JSONArray(responseBody);

                    // Set response content type
                    response.setContentType("application/json");

                    // Write JSON array to response
                    response.getWriter().write(jsonArray.toString());
                } else {
                    // Convert JSON string to JSONObject
                    JSONObject jsonObject = new JSONObject(responseBody);

                    // Set response content type
                    response.setContentType("application/json");

                    // Write JSON data to response
                    response.getWriter().write(jsonObject.toString());
                }
            } else {
                response.setStatus(statusCode);
                response.getWriter().write("Error occurred: " + httpResponse.getStatusLine().getReasonPhrase());
            }
        } catch (Exception e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error occurred: " + e.getMessage());
        } finally {
            httpClient.close();
        }
    }
}








