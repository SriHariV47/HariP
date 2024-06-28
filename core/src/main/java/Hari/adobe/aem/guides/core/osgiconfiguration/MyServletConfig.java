package Hari.adobe.aem.guides.core.osgiconfiguration;

import org.osgi.service.metatype.annotations.AttributeDefinition;


import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Servlet Configuration", description = "Configuration for My Servlet")
public @interface MyServletConfig {

    @AttributeDefinition(name = "Name", description = "The name to be printed on the server page")
    String getName() default "World"; // Default value can be set here

}
