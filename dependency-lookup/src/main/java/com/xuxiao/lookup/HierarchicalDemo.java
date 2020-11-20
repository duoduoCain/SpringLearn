package com.xuxiao.lookup;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xxle
 * @date 2020/6/12 15:51
 */
public class HierarchicalDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext config= new AnnotationConfigApplicationContext();
		config.register(HierarchicalDemo.class);// 这里表明 @Configuration不是必须的注解
		config.refresh();

		ConfigurableListableBeanFactory beanFactory = config.getBeanFactory();

		beanFactory.setParentBeanFactory(createParentBeanFactory());

		System.out.println(beanFactory.getParentBeanFactory());

		config.close();
	}


	private static BeanFactory createParentBeanFactory(){
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/dependency-lookup.xml");
		return defaultListableBeanFactory;
	}

}
