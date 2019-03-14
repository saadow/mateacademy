package homework_spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TruckBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		GenericBeanDefinition gbd = new GenericBeanDefinition();
		gbd.setBeanClass(Truck.class);
		gbd.getPropertyValues().add("model", "1601REIX5");

		((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("truck", gbd);
	}
}