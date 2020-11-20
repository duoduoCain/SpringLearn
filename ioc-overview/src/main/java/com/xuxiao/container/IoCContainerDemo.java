package com.xuxiao.container;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author xxle
 * @date 2020/6/11 15:10
 */
public class IoCContainerDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader beanDefinition = new XmlBeanDefinitionReader(defaultListableBeanFactory);

		System.out.println(beanDefinition.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml"));

	}

}
