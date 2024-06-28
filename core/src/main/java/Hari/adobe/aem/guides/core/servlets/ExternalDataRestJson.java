package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = { Servlet.class }, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Servlet to fetch JSON data from an external URL and display it in AEM page",
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/custom/getjsondata",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=GET" })
public class ExternalDataRestJson extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        // External URL to fetch JSON data from
        String externalUrl = "https://jsonplaceholder.typicode.com/users/1";

        // Fetching JSON data from external URL
        String jsonData = fetchDataFromURL(externalUrl);
 
        // Write the fetched JSON data to response
        response.getWriter().write(jsonData);
    }

    private String fetchDataFromURL(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        // Check if the response code is 200 (OK)
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            String data = IOUtils.toString(inputStream, "UTF-8");
            inputStream.close();
            return data;
        } else {
            // Handle error response
            return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
        }
    }
}
