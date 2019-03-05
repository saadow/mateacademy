package lesson13_rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

public class MainGrizzlyJerseyStart {
	public static void main(String[] args) throws IOException {

		final String baseUri = "http://localhost:9998/";
		final Map<String, String> initParams = new HashMap<String, String>();

		initParams.put("com.sun.jersey.config.property.packages", "lesson13_rest");
		initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

		System.out.println("Starting grizzly...");
		//GrizzlyWebContainerFactory.create(baseUri, initParams);
		System.out
				.println(String.format("Jersey started with WADL available at %sapplication.wadl.", baseUri, baseUri));
	}
}
