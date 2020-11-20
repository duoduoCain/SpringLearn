package com.xuxiao.inject;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author xxle
 * @date 2020/6/14 14:20
 */
public class ApiDependencyInjectDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext();
//		context.register(ApiDependencyInjectDemo.class);
		context.registerBeanDefinition("userHolderBeanDefinitionasdf",createBeanDefinition());

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);

		String classpath = "classpath:/META-INF/dependency-lookup.xml";

		xmlBeanDefinitionReader.loadBeanDefinitions(classpath);

		context.refresh();

		UserHolder bean = context.getBean(UserHolder.class);
		System.out.println(context.getBean("userHolderBeanDefinitionasdf"));//
		System.out.println(bean);

		context.close();

	}

//	@Bean
//	public UserHolder getUserHolder(User user){
//		UserHolder userHolder = new UserHolder(user);
//		return userHolder;
//	}

	private static BeanDefinition createBeanDefinition(){

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
		builder.addPropertyReference("user","superUser");
		return builder.getBeanDefinition();
	}



}
