package com.xuxiao.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xxle
 * @date 2020/6/12 15:17
 */
//@Configuration
public class ObjectProviderDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext config= new AnnotationConfigApplicationContext();
		config.register(ObjectProviderDemo.class);// 这里表明 @Configuration不是必须的注解
		config.refresh();

		lookupByDependencyObjectProvider(config);

		config.close();
	}

	private static void	 lookupByDependencyObjectProvider(ApplicationContext applicationContext){
		//  spring 5.X 提供的 ObjectProvider
		ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);


		System.out.println(beanProvider.getObject());

	}

	@Bean
	public String helloworld(){
		return "hello world";
	}


}
