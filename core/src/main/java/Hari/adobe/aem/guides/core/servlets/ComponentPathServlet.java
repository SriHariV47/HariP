package Hari.adobe.aem.guides.core.servlets;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = { Servlet.class }, property = {
        Constants.SERVICE_DESCRIPTION + "=Component Path Servlet",
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/yourServletPath/removeproprty",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=POST"
})
public class ComponentPathServlet extends SlingAllMethodsServlet {

	
	
	 
	 private String Const_path="path";
	 private String Compo_path="componentPath"; 
	
	 @Override
		protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
		    
		    String receivedComponentPath = request.getParameter(Compo_path);
		    String pagepath=request.getParameter(Const_path);

		    // Obtain the ResourceResolver and adapt it to a Resource
		    ResourceResolver resourceResolver = request.getResourceResolver();
		    Resource resource = resourceResolver.getResource(receivedComponentPath);

		    if (resource != null) {
		        ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
		        if (properties != null && properties.containsKey("cssclass")) {
		            // Remove the cssclass property
		            properties.remove("cssclass");
		            // Commit the changes
		            resourceResolver.commit();
		        } else {
		            response.getWriter().write("The cssclass property does not exist on the node.");
		        }
		    } else {
		        response.getWriter().write("The specified component path does not resolve to a resource.");
		    }
		}
}