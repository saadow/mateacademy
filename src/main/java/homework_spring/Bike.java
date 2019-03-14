package homework_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:homework_spring/bike.properties" })
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bike {
	@Value("${model}")
	private String model;
	
	public String getModel() {
		return model;
	}
	

	public String toString() {
		return "Bike - model " + getModel();
	}
}
