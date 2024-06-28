package Hari.adobe.aem.guides.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class SingleArticleModel {
    
    @Inject
    private Resource resource;

    public String getNodePath() {
        return resource.getPath();
    }
    
    

    
    
    
}
