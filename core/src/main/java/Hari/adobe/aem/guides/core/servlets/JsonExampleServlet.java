package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class , immediate = true)
@SlingServletPaths(value ="/bin/apps/ekvjrjbrljgv")
public class JsonExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a JSON array
        JSONArray jsonArray = new JSONArray();

        // Populate the JSON array with sample data
        JSONObject obj1 = new JSONObject();
        try {
			obj1.put("name", "John");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			obj1.put("age", 30);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        jsonArray.put(obj1); 

        JSONObject obj2 = new JSONObject();
        try {
			obj2.put("name", "Alice");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			obj2.put("age", 25);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jsonArray.put(obj2);

        // Set response content type
        response.setContentType("application/json");

        // Write JSON array to response
        response.getWriter().write(jsonArray.toString());
    }

    protected void activate(ComponentContext componentContext) {
        // Servlet activation code, if needed
    }

    protected void deactivate(ComponentContext componentContext) {
        // Servlet deactivation code, if needed
    }
}