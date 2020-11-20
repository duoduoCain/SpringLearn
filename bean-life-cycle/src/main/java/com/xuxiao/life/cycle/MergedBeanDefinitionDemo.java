package com.xuxiao.life.cycle;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;


/**
 * @author xxle
 * @date 2020/6/15 21:58
 */
public class MergedBeanDefinitionDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		String location = "META-INF/dependency-lookup.xml";

		Resource resource = new ClassPathResource(location);

		EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");

		reader.loadBeanDefinitions(encodedResource);

		System.out.println(beanFactory.getBean("superUser"));
	}

}
