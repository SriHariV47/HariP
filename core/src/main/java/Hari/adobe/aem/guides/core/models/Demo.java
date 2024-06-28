package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Demo {

	
	@ValueMapValue
	public String firstname;
	
	@ValueMapValue
	public String pathfield;

	public String getFirsname() {
		return firstname;
	}

	public String getPathfield() {
		return pathfield;
	}
	
	@ChildResource
	public List<Car> subject;
	
	public List<Car> getSubject()
	{
		return subject;
	}
	
}
