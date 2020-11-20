package com.xuxiao.ioc.java.defination;

import com.xuxiao.domain.User;
import com.xuxiao.ioc.java.factory.DefaultUserFacotry;
import com.xuxiao.ioc.java.factory.UserFacotry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * @author xxle
 * @date 2020/6/12 11:22
 */
public class SpecialBeanInstantiationDemo {

	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-ceation-context.xml");
//		ServiceLoaderFactoryBean userFactoryServiceLoader = (ServiceLoaderFactoryBean) beanFactory.getBean("userFactoryServiceLoader");
//		System.out.println(userFactoryServiceLoader);
		AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
		UserFacotry bean = autowireCapableBeanFactory.createBean(DefaultUserFacotry.class);
		System.out.println(bean.createUser());
//		printServiceloader();
	}

	public static void printServiceloader(){
		ServiceLoader<UserFacotry> serviceLoader = load(UserFacotry.class,Thread.currentThread().getContextClassLoader());
		Iterator<UserFacotry> iterator = serviceLoader.iterator();
		boolean b = iterator.hasNext();
		while(b){
			UserFacotry next = iterator.next();
			System.out.println(next);
		}
	}

}
