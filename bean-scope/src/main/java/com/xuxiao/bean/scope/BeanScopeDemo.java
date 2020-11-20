package com.xuxiao.bean.scope;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import javax.management.MXBean;
import java.util.Collection;
import java.util.Map;

/**
 * @author xxle
 * @date 2020/6/15 14:32
 */
public class BeanScopeDemo {

	@Bean
	public static  User singletonUser(){
		return createUser();
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public static  User prototypeUser(){
		return createUser();
	}

	@Autowired
	@Qualifier("singletonUser")
	private User singletonUser;

	@Autowired
	@Qualifier("singletonUser")
	private User singletonUser1;
	@Autowired
	@Qualifier("prototypeUser")
	private User prototypeUser;

	@Autowired
	@Qualifier("prototypeUser")
	private User prototypeUser1;

	@Autowired
	private Collection<User> users;
	@Autowired
	private Map<String,User> usersMap;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanScopeDemo.class);
		context.refresh();

		System.out.println("BeanScopeDemo:"+context.getBeansOfType(BeanScopeDemo.class));

//		testSingletonAndPrototype(context);

		testSingletonAndPrototypeAutowired(context);

		context.close();
	}

	private static void testSingletonAndPrototypeAutowired(AnnotationConfigApplicationContext context) {

		BeanScopeDemo bean = context.getBean(BeanScopeDemo.class);

		System.out.println("bean.singletonUser"+bean.singletonUser);
		System.out.println("bean.singletonUser1"+bean.singletonUser1);
		System.out.println("bean.prototypeUser"+bean.prototypeUser);
		System.out.println("bean.prototypeUser1"+bean.prototypeUser1);
		System.out.println("bean.users"+bean.users);
		System.out.println("bean.usersMap"+bean.usersMap);
//		bean.users[User(id=1, name=1835604366926400), User(id=1, name=1835604371952800)]
//		bean.usersMap{singletonUser=User(id=1, name=1835604366926400), prototypeUser=User(id=1, name=1835604374741200)}
		// 结论 singletonUser  prototypeUser 都会执行初始化
		// 但是 singletonUser只会初始化一次 prototypeUser则会每次都初始化
		// 并且 prototypeUser 不会被销毁
	}

	private static void testSingletonAndPrototype(AnnotationConfigApplicationContext context) {

		for (int i = 0;i<3;i++){
			User bean = context.getBean("singletonUser",User.class);

			System.out.println("singletonUser"+bean);
			User prototypeUser = context.getBean("prototypeUser",User.class);
			System.out.println("prototypeUser"+prototypeUser);

		}
	}

	private static User createUser(){
		User user = new User();
		user.setName(System.nanoTime()+"");
		user.setId(1);
		return user;
	}


}
