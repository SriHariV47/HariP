package Hari.adobe.aem.guides.core.osgiconfiguration;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Servlet OSGIConfig", description = "Configuration for My Servlet")
public @interface JsonOsgiConfig {

    
    @AttributeDefinition(name = "URL", description = "The URL to be printed on the server page")
    String getURL() default "https://jsonplaceholder.typicode.com/users/1"; // Default URL value
}


