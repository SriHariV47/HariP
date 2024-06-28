package Hari.adobe.aem.guides.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true")
})
public class HeaderSlingmodelex {

    @ValueMapValue
    public String text;

    @ValueMapValue
    public String checkbox;

    @ValueMapValue
    public String pathfield;

    @ChildResource
    private Resource details;

    public String getPathfield() {
        return pathfield;
    }

    public String getCheckbox() {
        if ("on".equalsIgnoreCase(checkbox)) {
            return "on";
        } else {
            return "off";
        }
    }

    public String getText() {
        return text;
    }

    public List<Map<String, Object>> getDetails() {
        List<Map<String, Object>> mainmap = new ArrayList<>();
        Map<String, Object> childmap;
        Iterator<Resource> iterator = details.getChildren().iterator();
        while (iterator.hasNext()) {
            Resource childresource = iterator.next();
            childmap = new HashMap<>();
            childmap.put("firstname", childresource.getValueMap().get("firstname", String.class));
            childmap.put("dob", childresource.getValueMap().get("dob", String.class));
            // childmap.put("address", childresource.getValueMap().get("address", String.class));
            mainmap.add(childmap);
        }
        return mainmap;
    }
}
