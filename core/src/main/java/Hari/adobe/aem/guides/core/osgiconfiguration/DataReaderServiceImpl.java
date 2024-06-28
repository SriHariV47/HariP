package Hari.adobe.aem.guides.core.osgiconfiguration;


import java.io.IOException;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import Hari.adobe.aem.guides.core.osgiconfiguration.DataReaderService;;
@Component(service = DataReaderService.class,immediate = true)



public class DataReaderServiceImpl  implements DataReaderService{
	
	 private static final Logger LOG=LoggerFactory.getLogger(DataReaderServiceImpl.class);
	    @Override
	    public JsonArray getDataReader() {
	        HttpClient client=HttpClientBuilder.create().build();
	        HttpGet get=new HttpGet("https://gorest.co.in/public/v2/users");
	        get.setHeader("accept","application/json");
	        JsonArray userData=null;
	        try {
	            HttpResponse response=client.execute(get);
	            if(response.getStatusLine().getStatusCode()==200){
	                HttpEntity entity=response.getEntity();
	                String userStr=EntityUtils.toString(entity);
	                userData=new Gson().fromJson(userStr, JsonArray.class);
	                LOG.info("UserData :"+userData);
	            }
	        } catch (ClientProtocolException e) {
	            LOG.error("Error While Writing User API ", e);
	        } catch (IOException e) {
	            LOG.error("Error While Writing User API ", e);
	        }
	        return userData;
	    }
  
}

