package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ExtenrnalDataJson {

	private String id;
	private String name;
	private String username;
	private String email;
	private String address;
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private String geo;
	private String lat;
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getStreet() {
		return street;
	}


	public String getSuite() {
		return suite;
	}


	public String getCity() {
		return city;
	}


	public String getZipcode() {
		return zipcode;
	}


	public String getGeo() {
		return geo;
	}


	public String getLat() {
		return lat;
	}


	public String getLng() {
		return lng;
	}


	private String lng;
//	private String phone;
//	private String website;
//	private String company;
//	private String name1;
//	private String catchPhrase;
//	private String bs;
	
	
	private class ExternalData
	{
		
		private String id;
		private String name;
		private String username;
		private String email;
		private String phone;
		private String website;
		private String address;
		
		
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getUsername() {
			return username;
		}
		public String getEmail() {
			return email;
		}
		public String getPhone() {
			return phone;
		}
		public String getWebsite() {
			return website;
		}
		public String getAddress() {
			return address;
		}
		
		
	}
	
	
}
