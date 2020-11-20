package com.xuxiao.ioc.java.defination;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @author xxle
 * @date 2020/6/11 16:41
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotationBeanDefinitionDemo.class);
		context.refresh();
		Map<String, Config> beansOfType = context.getBeansOfType(Config.class);
		System.out.println("Config:"+context.getBeansOfType(Config.class));
		System.out.println("user:"+context.getBeansOfType(User.class));

		System.out.println("AnnotationBeanDefinitionDemo:"+context.getBeansOfType(AnnotationBeanDefinitionDemo.class));
		//1:通过 @Bean
		// 2: 通过@Component
		//3： 通过@Import导入

	}

	public static void apiRegister(BeanDefinitionRegistry beanDefinitionRegistry,String name){
		BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
		BeanDefinitionBuilder beanDefinitionBuilder1 = beanDefinitionBuilder.addPropertyValue("id", 101).addPropertyValue("name", "101xx");

		beanDefinitionRegistry.registerBeanDefinition(name,beanDefinitionBuilder1.getBeanDefinition());
		//两张API凡是注册
		BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder1.getBeanDefinition(),beanDefinitionRegistry);
	}
	@Component
	public static class Config{
		@Bean(name = {"user","xx-user"})
		public User user(){
			User user1 = new User();
			user1.setName("a");
			user1.setId(1);
			return user1;
		}
	}

}
