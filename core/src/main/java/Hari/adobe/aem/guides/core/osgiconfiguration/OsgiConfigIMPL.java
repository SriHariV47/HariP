package Hari.adobe.aem.guides.core.osgiconfiguration;




import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service =OsgiconfigMethods.class)
@Designate(ocd = MoviesOsgiConfiguration.class)
public class OsgiConfigIMPL implements OsgiconfigMethods{

	private String heroName;
	private int heroAge;
	@Activate()
	protected void start(MoviesOsgiConfiguration config){
		heroName = config.getHeroName();
		heroAge = config.getHeroAge();
		
	}	
	@Override
	public String getHeroName() {
		
		return heroName;
	}

	@Override
	public int getHeroAge() {
		// TODO Auto-generated method stub
		return heroAge;
	}
	

}