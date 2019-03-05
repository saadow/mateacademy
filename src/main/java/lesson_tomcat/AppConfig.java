package lesson_tomcat;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("lesson_tomcat");
		property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
		register(JspMvcFeature.class);
	}
}
