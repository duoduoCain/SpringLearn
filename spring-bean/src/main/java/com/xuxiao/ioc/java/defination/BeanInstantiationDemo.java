package com.xuxiao.ioc.java.defination;

import com.xuxiao.domain.User;
import com.xuxiao.ioc.java.factory.DefaultUserFacotry;
import com.xuxiao.ioc.java.factory.UserFacotry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xxle
 * @date 2020/6/12 11:22
 */
@Configuration
public class BeanInstantiationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();

		beanFactory.register(BeanInstantiationDemo.class);

		beanFactory.refresh();

		UserFacotry bean = beanFactory.getBean(UserFacotry.class);
		System.out.println(bean);
//		demoTest(beanFactory);

	}

	@Bean(initMethod = "initAnnotation")
	public UserFacotry userFacotry(){
		return new DefaultUserFacotry();
	}

	private static void demoTest(BeanFactory beanFactory) {
		User bean = beanFactory.getBean("userByStaticMethod",User.class);
		User userByUserFactory = beanFactory.getBean("userByUserFactory", User.class);
		System.out.println(bean);

		System.out.println(userByUserFactory);

		print(beanFactory);
	}

	public static void print(BeanFactory beanFactory){
		if(beanFactory instanceof ApplicationContext){
			ApplicationContext cast = ApplicationContext.class.cast(beanFactory);
			Map<String, User> beansOfType = cast.getBeansOfType(User.class);

			System.out.println(beansOfType);
		}
	}

}
