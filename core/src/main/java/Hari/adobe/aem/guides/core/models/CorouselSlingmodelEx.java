package Hari.adobe.aem.guides.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CorouselSlingmodelEx {

	
	
	
	@ChildResource
	Resource details;
	
	
	public List<Map<String,Object>> getDetails(){
		List<Map<String,Object>> mainmap =new ArrayList<Map<String,Object>>();
		Map<String,Object> childmap;
		Iterator<Resource> iterator = details.getChildren().iterator();
		while(iterator.hasNext()) {
			Resource childresource = iterator.next();
			childmap=new HashMap<String,Object>();
			childmap.put("firstname",childresource.getValueMap().get("firstname",String.class) );
			childmap.put("pathfield",childresource.getValueMap().get("pathfield",String.class) );
			childmap.put("address",childresource.getValueMap().get("address",String[].class) );
			mainmap.add(childmap);
			
			
		}
		
		
		return mainmap;
		
		
	}
}
 