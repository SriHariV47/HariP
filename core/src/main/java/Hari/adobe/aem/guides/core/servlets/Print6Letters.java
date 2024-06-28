package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class,
property = {
		"sling.servlet.paths=/bin/example/dernjrjkjhvhmo",
		"sling.servlet.resourceTypes=cq/gui/components/authoring/dialog"
		
})
@SlingServletPaths(value = { "/bin/apps/demokjbjkbjbh" })
@SlingServletResourceTypes(resourceTypes = "cq/gui/components/authoring/dialog",
selectors = "sample1")
public class Print6Letters extends SlingAllMethodsServlet  
{

	public void  doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException
	{
		 String parameter = request.getParameter("session");
		 
	           if(parameter != null ) {
	       	            response.getWriter().write(generateRandomWord(6));
	            
	           }else {
	        	   response.getWriter().write("no parameters");  
	           }
	    }         
	
	    private  String generateRandomWord(int length) {	       
	     
	        StringBuilder randomWord = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
		    	 char randomword=(char)('A'+random.nextInt(26));
		    	 randomWord.append(randomword);
	        }

	        return randomWord.toString();																						        
	        																													
	    }
	    
}


