package Hari.adobe.aem.core.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Hari.adobe.aem.core.services.DataUtilService;

@Component(service =DataUtilService.class)
public class DataUtilServicesImpl implements DataUtilService {
	private static final Logger LOG=LoggerFactory.getLogger(DataUtilService.class);
	@Reference
	ResourceResolverFactory factory;
	
	ResourceResolver resolver;

	@Override
	public ResourceResolver getResourceResolver() {
		Map<String, Object> serviceUserMap=new HashMap<>();
		serviceUserMap.put(ResourceResolverFactory.SUBSERVICE,"hari");
		try {
			resolver=factory.getServiceResourceResolver(serviceUserMap);
		} catch (LoginException e) {
			LOG.error("error while getting the resolver using subservice of name {},error:{} ","hari",e);
		}
		return resolver;
	}

}