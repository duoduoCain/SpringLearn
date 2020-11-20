package com.xuxiao.container;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author xxle
 * @date 2020/6/11 15:10
 */
public class ApplicationContextAnnotationAsIoCContainerDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ApplicationContextAnnotationAsIoCContainerDemo.class);
		//启动上下文
		applicationContext.refresh();
		lookupByCollection(applicationContext);
	}
	private static void lookupByCollection(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory cast = ListableBeanFactory.class.cast(beanFactory);
			Map<String, User> beansOfType = cast.getBeansOfType(User.class);
			// key 是 id
			System.out.println("集合类型查找："+beansOfType);
		}
	}
	@Bean
	public User getUser(){
		User user = new User();
		user.setId(1);
		user.setName("annotation user");
		return user;
	}

}
