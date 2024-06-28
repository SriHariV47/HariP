package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class },defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class item0 {
	
	@ValueMapValue
	public String mobile;
	
	@ValueMapValue
	public String dob;

	public String getMobile() {
		return mobile;
	}

	public String getDob() {
		return dob;
	}
	
	
	


}
