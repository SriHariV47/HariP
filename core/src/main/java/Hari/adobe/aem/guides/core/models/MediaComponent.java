package Hari.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class)
public class MediaComponent {

    @SlingObject
    private Resource resource;

    @Default(values = "")
    private String title;

    @Default(values = "")
    private String description;

    @Default(values = "")
    private String paragraph;

    @Default(values = "")
    private String image;

    @Default(values = "top")
    private String imagePosition;

    @Default(values = "")
    private String buttonText;

    @Default(values = "")
    private String buttonUrl;

    @Default(booleanValues = false)
    private boolean isCTA;

    @Default(values = "")
    private String ctaText;

    @Default(values = "")
    private String ctaUrl;

    // Getters for all properties

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getImage() {
        return image;
    }

    public String getImagePosition() {
        return imagePosition;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public boolean isCTA() {
        return isCTA;
    }

    public String getCtaText() {
        return ctaText;
    }

    public String getCtaUrl() {
        return ctaUrl;
    }
}
