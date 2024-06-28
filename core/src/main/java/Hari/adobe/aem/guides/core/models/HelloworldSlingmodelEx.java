package Hari.adobe.aem.guides.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HelloworldSlingmodelEx {
	
	@ValueMapValue
	private String text;
	
	@ValueMapValue
	private String age;
	
	@ValueMapValue
	private String dob;
	
	@ValueMapValue
	private String email;
	
	@ValueMapValue
	private String password;
	
	@ValueMapValue
	private String[] subjects;

	public String getText() {
		return text;
	}

	public String getAge() {
		return age;
	}

	public String getDob() {
		return dob;
	}

	public String getEMail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String[] getSubjects() {
		return subjects;
	}
	
	


}