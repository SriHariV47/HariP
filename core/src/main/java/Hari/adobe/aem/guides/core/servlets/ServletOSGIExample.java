package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import com.adobe.cq.social.tally.client.api.Response;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Component(service=Servlet.class,immediate = true)
//property = {
//		"sling.servlet.paths=/bin/example/demo",
//		"sling.servlet.resourceTypes=cq/gui/components/authoring/dialog"
//		
//}

@SlingServletResourceTypes(resourceTypes ="cq/gui/components/authoring/dialog")

//			selectors = "sample",
//			extensions ="json")
@SlingServletPaths(value ="/bin/example/demosjhdcc")
public class ServletOSGIExample extends SlingSafeMethodsServlet {
	
	public void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res)
	throws IOException{
		
		// JsonObjectBuilder job=Json.createObjectBuilder();
		JsonObject job = new JsonObject();
		
		Gson gson = new Gson();
		
		JsonArray jsonArray = new JsonArray();
		
		res.setContentType("text/plain");
//		job.addProperty("name", "surge");
//		job.addProperty("url", "www.google.com");
//		job.addProperty("location", "banglore");
//		jsonArray.add(job);
		
			res.getWriter().write("200");
		
	//	res.getWriter().write(gson.toJson(jsonArray).toString());
		
		
		
	}
	   
	
}




