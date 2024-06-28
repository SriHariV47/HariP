package Hari.adobe.aem.guides.core.models.impl;

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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import Hari.adobe.aem.guides.core.models.HeaderSlingmodelExIn;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, 
       adapters = HeaderSlingmodelExIn.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderSlingmodelExImpl implements HeaderSlingmodelExIn {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String checkbox;

    @ValueMapValue
    private String pathfield;

    @ChildResource
    private Resource details;

    @Override
    public String getPathfield() {
        return pathfield;
    }

    @Override
    public String getCheckbox() {
        if ("on".equalsIgnoreCase(checkbox)) {
            return "on";
        } else {
            return "off";
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<Map<String, Object>> getDetails() {
        List<Map<String, Object>> mainMap = new ArrayList<>();
        if (details != null) {
            Iterator<Resource> iterator = details.getChildren().iterator();
            while (iterator.hasNext()) {
                Resource childResource = iterator.next();
                Map<String, Object> childMap = new HashMap<>();
                childMap.put("firstname", childResource.getValueMap().get("firstname", String.class));
                childMap.put("dob", childResource.getValueMap().get("dob", String.class));
                mainMap.add(childMap);
            }
        }
        return mainMap;
    }
}
