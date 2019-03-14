package homework_spring;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@PropertySource({"classpath:homework_spring/deadmoto.properties"})
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeadMoto {
	@Value("${supplyNum}")
	private String supplyNum;
	@Value("${city}")
	private String city;
	private String id;

	public DeadMoto() {
		id = "ID" + (int) (Math.random() * 1000);
	}

	@Override
	public String toString() {
		return "DeadMoto - " + city + "-" + supplyNum + "-" + id;
	}

}
