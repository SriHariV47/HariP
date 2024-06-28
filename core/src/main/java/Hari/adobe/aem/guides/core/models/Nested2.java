package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Nested2 {

	@ValueMapValue
	public String link;

	public String getLink() {
		return link;
	}
	
	@ValueMapValue
	public String name;

	public String getName() {
		return name;
	}

}




