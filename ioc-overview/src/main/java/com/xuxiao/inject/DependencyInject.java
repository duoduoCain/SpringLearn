package com.xuxiao.inject;

import com.xuxiao.domain.User;
import com.xuxiao.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author xxle
 * @date 2020/6/11 13:53
 */
public class DependencyInject {
	strictfp class MyClass{

	}

	public static void main(String[] args) {
		//配置和启动应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject.xml");
//		injectCollections(beanFactory);
		UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
		whoIsIocContainer(userRepository,beanFactory);
	}

	private static void injectCollections(BeanFactory beanFactory) {
		UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
		System.out.println(userRepository.getUsers());
		//当前的注入的BeanFactory 和此时的容器不是一个对象
		System.out.println(userRepository.getBeanFactory()==beanFactory);
//		org.springframework.beans.factory.support.DefaultListableBeanFactory@73f792cf: defining beans [user,objectFatory,superUser,userRepository]; root of factory hierarchy
		System.out.println(userRepository.getBeanFactory());
//		org.springframework.context.support.ClassPathXmlApplicationContext@37bba400, started on Thu Jun 11 14:15:24 CST 2020
		System.out.println(beanFactory);

		//但是 如果注入ApplicationContext的时候  是和当前的容器是一个对象的
		System.out.println("注入ApplicationContext的时候  是和当前的容器是一个对象的:"+
				(beanFactory == userRepository.getApplicationContextObjectFactory().getObject()));


		ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
		System.out.println(userObjectFactory.getObject());
		//这里错误了 表明 依赖查找的时候 是查不到BeanFactory对象的
//		System.out.println(beanFactory.getBean(BeanFactory.class));

		Environment environment  = beanFactory.getBean(Environment.class);
		System.out.println("这是容器自己给我植入的 Environment 对象"+environment);
	}

	private static void  whoIsIocContainer(UserRepository userRepository,BeanFactory beanFactory){
		System.out.println(userRepository.getBeanFactory()==beanFactory);
		// 其实 ApplicationContext 就是 BeanFactory
		//ApplicationContext 见过
	}
}
