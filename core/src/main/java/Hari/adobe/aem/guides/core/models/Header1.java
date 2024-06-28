package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header1 {

	
	@ValueMapValue
	private String text;
	
	@ValueMapValue
	private String checkbox;
	
	@ValueMapValue
	private String pathfield;

	public String getText() {
		return text;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public String getPathfield() {
		return pathfield;
	}
	
	@ChildResource
	public List<item0> multifield;
	
	public List<item0> getMultifield(){
		return multifield;
		
	}
	
	
	
	
}
