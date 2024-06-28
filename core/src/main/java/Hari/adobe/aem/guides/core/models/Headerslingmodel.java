package Hari.adobe.aem.guides.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Headerslingmodel {
	
	@ValueMapValue
	private String name;
	
	@ValueMapValue
	private String image;
	
	@ValueMapValue
	private boolean student;
	
	public String getName() {
		return name;
		
	}
	
	public String getImage() {
		return image;
		
	}
	public boolean isStudent() {
		return student;
		
	}
	
	@ChildResource
	public List<item0> multifield;
	
	public List<item0> getMultifield(){
		return multifield;
		
	}
	
	@Inject
    private Resource resource;

    public String getNodePath() {
        return resource.getPath();
    }
	
	

}
