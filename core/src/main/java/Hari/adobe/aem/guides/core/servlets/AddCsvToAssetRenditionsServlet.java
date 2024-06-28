package Hari.adobe.aem.guides.core.servlets;

 

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

 

@Component(service = Servlet.class, immediate = true, property = {

        Constants.SERVICE_DESCRIPTION + "=Add CSV to Asset Renditions Servlet",

        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/add-csv-to-asset-renditions",

        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST

})

 

public class AddCsvToAssetRenditionsServlet extends SlingAllMethodsServlet {

       

    @Override

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

   

      String assetRenditionPath=request.getParameter("paramName1");

      String csvContent=request.getParameter("paramName2");

      if(assetRenditionPath == null || csvContent == null){

        response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);

      }

      ResourceResolver resolver =request.getResourceResolver();

      try{

        Resource assetRenditionResource = resolver.getResource(assetRenditionPath);

        Resource renditionsResource = assetRenditionResource.getChild("renditions");

        Resource csvFileResource = resolver.create(renditionsResource,"Metadata.csv",new HashMap<>());

        Node csvNode = csvFileResource.adaptTo(Node.class);

        Session session = resolver.adaptTo(Session.class);

        InputStream inputStream=new ByteArrayInputStream(csvContent.getBytes());

        Binary binary=session.getValueFactory().createBinary(inputStream);

        csvNode.setProperty("jcr:data", binary);

        resolver.commit();

      } catch (Exception e) {

        response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        response.getWriter().write("Error:"+e.getMessage());

      }

    }  

}