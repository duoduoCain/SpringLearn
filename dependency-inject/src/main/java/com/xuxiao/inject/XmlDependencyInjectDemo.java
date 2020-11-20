package com.xuxiao.inject;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author xxle
 * @date 2020/6/14 14:20
 */
public class XmlDependencyInjectDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		String classpath = "classpath:/META-INF/dependency-setter-inject.xml";

		xmlBeanDefinitionReader.loadBeanDefinitions(classpath);

		UserHolder bean = beanFactory.getBean(UserHolder.class);
		System.out.println(bean);
	}

}
