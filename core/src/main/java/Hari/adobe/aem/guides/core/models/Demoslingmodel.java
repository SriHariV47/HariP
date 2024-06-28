package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Demoslingmodel {
	
	
	 @ChildResource
	    private List<Demo> details;

	    public List<Demo> getDetails() {
			return details;
		}

}