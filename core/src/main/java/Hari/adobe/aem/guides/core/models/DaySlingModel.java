package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DaySlingModel {

	
	@ValueMapValue
	private String text;
	
	@ValueMapValue
	private String pathfield;
	
	 public String getText() {
	        return text;
	    }
	 
	 public String getPathField() {
			return pathfield;
		}
	 
	 @ValueMapValue
	    private boolean checkbox;
	    
		public boolean isCheckbox() {
			return checkbox;
		}
	
	    @ChildResource
	    private List<MultifieldItem> details;

	    public List<MultifieldItem> getDetails() {
			return details;
		}


	   

	    
}
