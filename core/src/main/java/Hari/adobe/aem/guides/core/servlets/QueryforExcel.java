package Hari.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service= Servlet.class)
@SlingServletPaths(value = { "/bin/siva/sai/warestrdtfg" })
public class QueryforExcel extends SlingAllMethodsServlet {
    String query = "SELECT s.*\r\n" + 
                   "FROM [nt:base] AS s\r\n" + 
                   "WHERE ISDESCENDANTNODE([/conf/global/settings/dam/adminui-entension/metadataschema/portal-schema/items/tabs/items/tab1/items/col1])\r\n" + 
                   "AND s.[fieldLabel] IS NOT NULL";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        Iterator<Resource> findResources = request.getResourceResolver().findResources(query, javax.jcr.query.Query.JCR_SQL2);
        while (findResources.hasNext()) {
            Resource next = findResources.next();
            boolean hasMatchingLabel = false; // Flag to track if a matching label is found

            // Get properties of the resource
            try {
                Node node = next.adaptTo(Node.class);
                if (node != null) {
                    JsonObjectBuilder propertiesJson = Json.createObjectBuilder();
                    Iterator<Property> properties = node.getProperties();
                    while (properties.hasNext()) {
                        Property property = properties.next();
                        String propertyName = property.getName();

                        // Check if property value matches any of the expected labels
                        String[] expectedLabels = {"Hide Hierarchy Product Tag","Document Metadata","Document Instance Id",
                                 "Asset Category *",
                                 "Is this file subject to Red Data (ITAR) or Yellow Data controls? *",
                                 "Document Title *",
                                 "File Name",
                                 "Document Description                    (1000 Characters Max) *",
                                "Asset Type *",
                                "Product Hierarchy Tag *",
                                 "Revision Date",
                                 "Document Status",
                                 "Software Upload Status",
                                "Document Owner Email",
                                 "Document Id",
                                 "Related Assets"};
                        for (String expectedLabel : expectedLabels) {
                            if (expectedLabel.equals(property.getValue().getString())) {
                                hasMatchingLabel = true;
                                break; // Exit loop if a match is found
                            }
                        }
                        if ("name".equals(propertyName)) {
                            // Extracting the property name after the last "/"
                            String propertyValue = property.getValue().getString();
                            int lastSlashIndex = propertyValue.lastIndexOf("/");
                            if (lastSlashIndex != -1) {
                                String extractedName = propertyValue.substring(lastSlashIndex + 1);
                                propertiesJson.add(propertyName, extractedName);
                            } else {
                                propertiesJson.add(propertyName, propertyValue); // No "/" found, add full value
                            }
                        }
                        
//                        // If the property is the "name" property, add it to the JSON object
//                        if ("name".equals(propertyName)) {
//                            propertiesJson.add(propertyName, property.getValue().getString());
//                        }
                    }

                    // Add path to JSON if there's a matching label
                    if (hasMatchingLabel) {
                        JsonObjectBuilder job = Json.createObjectBuilder();
                   //     job.add("path", next.getPath());
                        job.addAll(propertiesJson);
                        jab.add(job);
                    }
                }
            } catch (Exception e) {
                // Handle exception
                e.printStackTrace();
            }
        }
        response.getWriter().write(jab.build().toString());
    }
}