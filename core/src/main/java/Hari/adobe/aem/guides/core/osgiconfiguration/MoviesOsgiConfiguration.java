package Hari.adobe.aem.guides.core.osgiconfiguration;



import org.osgi.service.metatype.annotations.AttributeDefinition;

import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="movies details",description ="enter the movie details")
public @interface MoviesOsgiConfiguration {
	@AttributeDefinition(
			name="hero name",
			description ="enter hero name",
			type=AttributeType.STRING
			)
	public String getHeroName() default "balakrishna";
	
	@AttributeDefinition(
			name ="hero age",
			description ="enter hero age",
			type=AttributeType.INTEGER
			)
	public int getHeroAge() default 50;

}