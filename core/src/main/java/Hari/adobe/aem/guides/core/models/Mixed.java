package Hari.adobe.aem.guides.core.models;



import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import Hari.adobe.aem.core.services.ContentFragmentService;
import Hari.adobe.aem.core.services.ExperienceFragmentService;

import org.apache.sling.api.resource.ResourceResolver;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Mixed {

    @Inject
    private Resource resource; // Injected resource

    @Inject
    private String experienceFragmentPath;

    @Inject
    private String contentFragmentPath;

    @OSGiService
    private ExperienceFragmentService experienceFragmentService;

    @OSGiService
    private ContentFragmentService contentFragmentService;

    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        this.resourceResolver = resource.getResourceResolver();
    }
    public String getExperienceFragmentHtml() {
        return experienceFragmentService.getFragmentHtml(experienceFragmentPath, resourceResolver);
    }

    public String getContentFragmentContent() {
        return contentFragmentService.getFragmentContent(contentFragmentPath, resourceResolver);
    }
}