package Hari.adobe.aem.guides.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import Hari.adobe.aem.guides.core.models.ItemModel;

@Model(adaptables = Resource.class, adapters = ItemModel.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ItemModelImpl implements ItemModel {
	
    @ValueMapValue
    private String mobile;
    
    @ValueMapValue
    private String dob;
    
    @Override
    public String getMobile() {
        return mobile;
    }
    
    @Override
    public String getDob() {
        return dob;
    }
}
