package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Servlet to delete node property cssclass",
        "sling.servlet.methods=" + "POST",
        "sling.servlet.paths=" + "/bin/deleteCssClass"
})
public class PropertyUpdateServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Resource resource = request.getResource();
        ResourceResolver resourceResolver = request.getResourceResolver();

        String pagePath = request.getParameter("path");
        String nodePath = "";

        if (resource == null) {
            response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Resource not found");
            return;
        }
        if (pagePath != null) {
            if (pagePath.endsWith(".html")) {
                nodePath = pagePath.substring(0, pagePath.lastIndexOf(".html"));
            }
            nodePath += "/jcr:content/root/container/container/singlearticle";

            Resource containerResource = resourceResolver.getResource(nodePath);
            if (containerResource != null) {
                Resource singleArticleNode = findSingleArticleNode(containerResource);
                if (singleArticleNode != null) {
                    // Remove the property from the node
                    ModifiableValueMap properties = singleArticleNode.adaptTo(ModifiableValueMap.class);
                    properties.remove("cssclass");
                    resourceResolver.commit();
                    response.getWriter().write("Property 'cssclass' removed from node 'single_article'");
                } else {
                    response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().write("Node 'single_article' not found");
                }
            } else {
                response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("Container Resource not found");
            }
        } else {
            response.getWriter().write("Path is null");
        }
    }

    private Resource findSingleArticleNode(Resource resource) {
        if ("singlearticle".equals(resource.getName())) {
            return resource;
        }
        for (Resource child : resource.getChildren()) {
            Resource result = findSingleArticleNode(child);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
