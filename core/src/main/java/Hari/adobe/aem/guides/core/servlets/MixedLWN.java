package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths(value = { "/bin/apps/Demomix" })
public class MixedLWN extends SlingAllMethodsServlet  
{
	public void  doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException
	{
		 String parameter = request.getParameter("session");
		 String Type = request.getParameter("type");
		 
	           if(parameter != null && Type!= null ) {
	        	   if(Type.equalsIgnoreCase("Numbers")){
	        		  response.getWriter().write(generateRandomNumber(6));
	        		  }
	        	   else if(Type.equalsIgnoreCase("Letters")) {
	        		   response.getWriter().write(generateRandomWord(6));
	        	   }
	        	   else if(Type.equalsIgnoreCase("Mixed")) {
	        		   response.getWriter().write(generateRandomMixed(6));
	        	   }
	        	   else
	        	   {
	        		   response.getWriter().write(" Wrong Parameter  ");   
	        	   }
	           }
	           else {
	        	   response.getWriter().write("no parameters");  
	           }       
	          }         
	    
	 private String generateRandomWord(int length) {	       
	     
	        StringBuilder randomWord = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
		    	 char randomword=(char)('A'+random.nextInt(26));
		    	 randomWord.append(randomword);
	        }

	        return randomWord.toString();
	    }
	 
	    private String generateRandomNumber(int length) {
	        StringBuilder randomNumber = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            randomNumber.append(random.nextInt(10)); 
	        }
	        return randomNumber.toString();
	    }
	    
	    private String generateRandomMixed(int length) {
	        StringBuilder mixedString = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < length / 2; i++) {
	            char letter = (char) ('A' + random.nextInt(26));
	            mixedString.append(letter);
	        }

	        for (int i = 0; i < length / 2; i++) {
	            mixedString.append(random.nextInt(10));
	        }

	        return mixedString.toString();
	    }
}


