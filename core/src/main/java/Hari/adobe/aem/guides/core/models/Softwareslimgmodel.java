package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Softwareslimgmodel {

	@ChildResource
	public List<HeaderLinks> headerLinks;

	public List<HeaderLinks> getHeaderLinks() {
		return headerLinks;
	}
	
	@ChildResource
	public List<Sidebar> sidebar;

	public List<Sidebar> getsedebar() {
		return sidebar;
	}
	
	@ChildResource
	public List<Business> businesses;

	public List<Business> getbusinesses() {
		return businesses;
	}

	
	
	
	
	
}
