package Hari.adobe.aem.guides.core.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserDataModel {

    private String id;
    private String name;
    private String username;
    private String email;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String lat;

    @PostConstruct
    protected void init() {
        String apiUrl = "https://jsonplaceholder.typicode.com/users/1";	//Get data from json link to print component use sling model
        try (InputStream inputStream = new URL(apiUrl).openStream()) {
            String jsonString = IOUtils.toString(inputStream, "UTF-8");

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonString);

            id = root.get("id").asText();
            name = root.get("name").asText();
            username = root.get("username").asText();
            email = root.get("email").asText();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getLat() {
		return lat;
	}

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
