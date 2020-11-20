package com.xuxiao.autowired;

import com.xuxiao.domain.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.Optional;

/**
 * @author xxle
 * @date 2020/6/14 22:12
 */
@Configuration
@Getter
public class DependencyResolverDemo {

	@Autowired
	@Lazy
	private User userLazy;

	@Autowired
	private User user;

	@Autowired
	private Map<String,User> map;

	@Autowired
	private Optional<User> userOptional;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext();
		context.register(DependencyResolverDemo.class);

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);

		String classpath = "classpath:/META-INF/dependency-lookup.xml";

		xmlBeanDefinitionReader.loadBeanDefinitions(classpath);

		context.refresh();

		DependencyResolverDemo demo = context.getBean(DependencyResolverDemo.class);

		System.out.println("demo.user:"+demo.user);

		System.out.println("demo.map:"+demo.map);


		System.out.println("demo.userOptional:"+demo.userOptional);

		context.close();

	}

}
