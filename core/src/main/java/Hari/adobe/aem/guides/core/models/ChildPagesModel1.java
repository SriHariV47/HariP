package Hari.adobe.aem.guides.core.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.day.cq.commons.jcr.JcrConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service = { Servlet.class },
        property = {
                Constants.SERVICE_DESCRIPTION + "=Get Child Pages Servlet",
                "sling.servlet.methods=" + "GET",
                "sling.servlet.paths=" + "/bin/getChildPages"
        })
public class ChildPagesModel1 extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String path = request.getParameter("path");

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(path);

        List<String> childPageNames = new ArrayList<>();
        if (resource != null) {
            Iterator<Resource> children = resource.listChildren();
            while (children.hasNext()) {
                Resource child = children.next();
                if (child.isResourceType("cq:Page")) {
                    Resource content = child.getChild(JcrConstants.JCR_CONTENT);
                    if (content != null) {
                        String title = content.getValueMap().get(JcrConstants.JCR_TITLE, String.class);
                        childPageNames.add(title != null ? title : child.getName());
                    }
                }
            }
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"childPageNames\": " + new ObjectMapper().writeValueAsString(childPageNames) + "}");
    }
}
