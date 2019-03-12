package lesson_spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import lesson_spring.Tiger;

@Component
public class TigerConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(Tiger.class);
		bd.getPropertyValues().add("voice", "MURMYAU");

		((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("tiger1101", bd);
	}
}