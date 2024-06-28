package Hari.adobe.aem.guides.core.servlets;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComponentPathServletTest {

    private ComponentPathServlet servlet;
    private SlingHttpServletRequest request;
    private SlingHttpServletResponse response;
    private ResourceResolver resourceResolver;
    private Resource resource;
    private ModifiableValueMap properties;
    private PrintWriter writer;

    @BeforeEach
    public void setUp() throws IOException {
        servlet = new ComponentPathServlet();
        request = mock(SlingHttpServletRequest.class);
        response = mock(SlingHttpServletResponse.class);
        resourceResolver = mock(ResourceResolver.class);
        resource = mock(Resource.class);
        properties = mock(ModifiableValueMap.class);
        writer = mock(PrintWriter.class);

        when(request.getResourceResolver()).thenReturn(resourceResolver);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoPost_RemoveCssClassProperty() throws ServletException, IOException {
        String componentPath = "/content/test/component";
        when(request.getParameter("componentPath")).thenReturn(componentPath);
        when(request.getParameter("path")).thenReturn("/content/test/page");
        when(resourceResolver.getResource(componentPath)).thenReturn(resource);
        when(resource.adaptTo(ModifiableValueMap.class)).thenReturn(properties);
        when(properties.containsKey("cssclass")).thenReturn(true);

        servlet.doPost(request, response);

        verify(properties, times(1)).remove("cssclass");
        verify(resourceResolver, times(1)).commit();
        verify(writer, never()).write(anyString());
    }

    @Test
    public void testDoPost_PropertyDoesNotExist() throws ServletException, IOException {
        String componentPath = "/content/test/component";
        when(request.getParameter("componentPath")).thenReturn(componentPath);
        when(request.getParameter("path")).thenReturn("/content/test/page");
        when(resourceResolver.getResource(componentPath)).thenReturn(resource);
        when(resource.adaptTo(ModifiableValueMap.class)).thenReturn(properties);
        when(properties.containsKey("cssclass")).thenReturn(false);

        servlet.doPost(request, response);

        verify(properties, never()).remove("cssclass");
        verify(resourceResolver, never()).commit();
        verify(writer, times(1)).write("The cssclass property does not exist on the node.");
    }

    @Test
    public void testDoPost_ResourceDoesNotExist() throws ServletException, IOException {
        String componentPath = "/content/test/component";
        when(request.getParameter("componentPath")).thenReturn(componentPath);
        when(request.getParameter("path")).thenReturn("/content/test/page");
        when(resourceResolver.getResource(componentPath)).thenReturn(null);

        servlet.doPost(request, response);

        verify(properties, never()).remove("cssclass");
        verify(resourceResolver, never()).commit();
        verify(writer, times(1)).write("The specified component path does not resolve to a resource.");
    }
}
