package Hari.adobe.aem.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Hari.adobe.aem.guides.core.osgiconfiguration.JsonOsgiConfig;

@Component(service = JsonOsgiConfigMethod.class,immediate = true)
@Designate(ocd = JsonOsgiConfig.class)
public class JsonOsgiConfigurationIMP implements JsonOsgiConfigMethod
{
	private String url;
	public static final Logger log=LoggerFactory.getLogger(JsonOsgiConfigurationIMP.class);
	@Activate
	public void activate(JsonOsgiConfig config)
	{
		url = config.getURL();
	}
	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}
	
}