package Hari.adobe.aem.core.services;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

public class ExperienceFragmentServiceImpl implements ExperienceFragmentService {

    @Override
    public String getFragmentHtml(String path, ResourceResolver resourceResolver) {
        Resource resource = resourceResolver.getResource(path);
        if (resource != null) {
            return resource.getValueMap().get("html", String.class);
        }
        return "<div>Experience Fragment not found or no HTML content available.</div>";
    }
}