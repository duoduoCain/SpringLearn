package com.xuxiao.inject;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author xxle
 * @date 2020/6/14 14:20
 */
public class AnnotationDependencyInjectDemo {

//	@Autowired
//	private  UserHolder userHolder;

	@Autowired
	private List<User> users;


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext();
		context.register(AnnotationDependencyInjectDemo.class);

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);

		String classpath = "classpath:/META-INF/dependency-lookup.xml";

		xmlBeanDefinitionReader.loadBeanDefinitions(classpath);

		context.refresh();



		context.close();

	}

	@Bean
	public UserHolder getUserHolder(User user){
		UserHolder userHolder = new UserHolder(user);
		return userHolder;
	}

}
