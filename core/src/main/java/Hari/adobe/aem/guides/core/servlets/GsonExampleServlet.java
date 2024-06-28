package Hari.adobe.aem.guides.core.servlets;

import com.google.gson.Gson;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, immediate = true)
@SlingServletPaths(value = "/bin/apps/ekvjnjv")
public class GsonExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a Gson object
        
    	Gson gson = new Gson();

        // Create a JsonArray
        JsonArray jsonArray = new JsonArray();

        // Populate the JsonArray with sample data
        JsonObject obj1 = new JsonObject();
        obj1.addProperty("name", "John");
        obj1.addProperty("age", 30);
        jsonArray.add(obj1);

        JsonObject obj2 = new JsonObject();
        obj2.addProperty("name", "Alice");
        obj2.addProperty("age", 25);
        jsonArray.add(obj2);

        // Set response content type
        response.setContentType("application/json");

        // Write JsonArray to response
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(jsonArray));
        out.flush();
    }

    protected void activate(ComponentContext componentContext) {
        // Servlet activation code, if needed
    }

    protected void deactivate(ComponentContext componentContext) {
        // Servlet deactivation code, if needed
    }
}
