package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Read Child Pages Servlet",
                "sling.servlet.methods=GET",
                "sling.servlet.paths=/bin/readChildPages"
        })
public class ChildPagesServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getParameter("path");
        if (path == null || path.isEmpty()) {
            response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Path parameter is required\"}");
            return;
        }

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(path);
        if (resource == null) {
            response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\": \"Resource not found\"}");
            return;
        }

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page parentPage = pageManager.getContainingPage(resource);

        if (parentPage == null) {
            response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\": \"Page not found\"}");
            return;
        }

        Map<String, String> childPages = new HashMap<>();
        Iterator<Page> childrenIterator = parentPage.listChildren();
        while (childrenIterator.hasNext()) {
            Page childPage = childrenIterator.next();
            childPages.put(childPage.getPath(), childPage.getTitle());
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        OBJECT_MAPPER.writeValue(response.getWriter(), childPages);
    }
}
