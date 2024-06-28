package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class HeaderLinks {

	
	@ValueMapValue
	public String hideInMobileMenu;
	
	@ValueMapValue
	public String url;
	
	@ValueMapValue
	public String icon;
	
	@ValueMapValue
	public String name;

	public String getHideInMobileMenu() {
		return hideInMobileMenu;
	}

	public String getUrl() {
		return url;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}
	
	
}
