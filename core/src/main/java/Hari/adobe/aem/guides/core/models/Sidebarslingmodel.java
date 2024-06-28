package Hari.adobe.aem.guides.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", options = {
        @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true")
})
public class Sidebarslingmodel {
	
	
	
	
    @ValueMapValue
    public String logopathfield;

    @ValueMapValue
    public String logomobileimage;

    @ValueMapValue
    public String logolink;

    @ValueMapValue
    public String checkbox;

    @ValueMapValue
    public String country;

    @ChildResource
    public List<Multifield1> Day1;

    @ChildResource
    public List<Multifield2> Day2;

    public String getLogopath() {
        return logopathfield;
    }

    public String getLogomobileimage() {
        return logomobileimage;
    }

    public String getLogolink() {
        return logolink;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public String getCountry() {
        return country;
    }

    public List<Multifield1> getDay1() {
        return Day1;
    }

    public List<Multifield2> getDay2() {
        return Day2;
    }
}
