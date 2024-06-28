package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldItem {

    @ValueMapValue
    private String firstname;

    @ValueMapValue
    private String dob;

    
    public String getFirstname() {
        return firstname;
    }
    
    public String getDOB() {
        return dob;
    }



}