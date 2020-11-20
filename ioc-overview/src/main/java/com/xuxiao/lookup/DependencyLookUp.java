package com.xuxiao.lookup;

import com.xuxiao.annontation.Super;
import com.xuxiao.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;

/**
 * @author xxle
 * @date 2020/6/11 11:26
 */
public class DependencyLookUp {


	@Resource
	private User usr;

	public static void main(String[] args) {

		//配置和启动应用上下文
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

//		lookUpRealTime(beanFactory);

//		lookupLazy(beanFactory);

//		lookupByType(beanFactory);
//		lookupByCollection(beanFactory);
//		lookupIdAndType(beanFactory);
		lookupByAnnotation(beanFactory);
	}

	private static void lookupByAnnotation(BeanFactory beanFactory) {

		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory cast = ListableBeanFactory.class.cast(beanFactory);
			Map<String, Object> beansWithAnnotation = cast.getBeansWithAnnotation(Super.class);
			User user = (User) beansWithAnnotation.get("superUser");
			Annotation[] annotations = user.getClass().getAnnotations();

			System.out.println(user.getClass().getAnnotations());
			System.out.println(beansWithAnnotation);
//			String[] annotation = cast.getBeanNamesForAnnotation(Super.class);
//			System.out.println(Arrays.asList(annotation).toString());
		}

	}

	private static void lookupIdAndType(BeanFactory beanFactory) {
		User user = beanFactory.getBean("user", User.class);
		System.out.println(user);
	}

	private static void lookupByCollection(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory cast = ListableBeanFactory.class.cast(beanFactory);
			Map<String, User> beansOfType = cast.getBeansOfType(User.class);
			// key 是 id
			System.out.println("集合类型查找："+beansOfType);
		}
	}

	private static void lookupByType(BeanFactory beanFactory) {
		User bean = beanFactory.getBean(User.class);
		System.out.println("依照类型查找："+bean);
	}

	private static void lookupLazy(BeanFactory beanFactory) {
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFatory");

		User object = objectFactory.getObject();
		System.out.println("延迟查找："+object);
	}

	private static void lookUpRealTime(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user");//这是实时查找
		System.out.println("实时查找："+user);
	}
}
