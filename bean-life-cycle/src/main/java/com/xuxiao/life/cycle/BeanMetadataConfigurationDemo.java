package com.xuxiao.life.cycle;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author xxle
 * @date 2020/6/15 16:56
 */
@Configuration
public class BeanMetadataConfigurationDemo {

	public static void main(String[] args) throws Exception{
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
		int i = propertiesBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/user.properties");
		System.out.println(i);
		System.out.println(beanFactory.getBean("user",User.class));
	}
}
