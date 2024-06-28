package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Business {

	@ValueMapValue
	public String selectionName;

	public String getSelectionName() {
		return selectionName;
	}
	
	@ChildResource
	public List<Nested2> items;

	public List<Nested2> getitems() {
		return items;
	}
	
}
