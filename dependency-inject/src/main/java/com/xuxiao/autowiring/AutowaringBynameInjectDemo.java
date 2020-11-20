package com.xuxiao.autowiring;

import com.xuxiao.inject.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author xxle
 * @date 2020/6/14 14:46
 */
public class AutowaringBynameInjectDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		String classpath = "classpath:/META-INF/dependency-autowaring-setter-inject.xml";

		xmlBeanDefinitionReader.loadBeanDefinitions(classpath);

		UserHolder bean = beanFactory.getBean(UserHolder.class);
		System.out.println(bean);

	}
}
