package Hari.adobe.aem.guides.core.models;

import java.util.List;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sidebar {

	@ValueMapValue
	public String secondLevelEnabled;
	
	@ValueMapValue
	public String selectedIcon;
	
	@ValueMapValue
	public String mainAnchorDisabled;
	
	@ValueMapValue
	public String target;
	
	@ValueMapValue
	public String icon;
	
	@ValueMapValue
	public String name;
	
	@ValueMapValue
	public String path;

	public String getSecondLevelEnabled() {
		return secondLevelEnabled;
	}

	public String getSelectedIcon() {
		return selectedIcon;
	}

	public String getMainAnchorDisabled() {
		return mainAnchorDisabled;
	}

	public String getTarget() {
		return target;
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	@ChildResource
	public List<Nested1> secondlevelsidebarmanual;

	public List<Nested1> getsecondlevelsidebarmanual() {
		return secondlevelsidebarmanual;
	}
	
	
}
