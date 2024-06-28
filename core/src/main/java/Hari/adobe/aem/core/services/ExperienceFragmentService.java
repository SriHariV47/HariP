package Hari.adobe.aem.core.services;

import org.apache.sling.api.resource.ResourceResolver;

public interface ExperienceFragmentService {
    String getFragmentHtml(String path,ResourceResolver resourceResolver);
}