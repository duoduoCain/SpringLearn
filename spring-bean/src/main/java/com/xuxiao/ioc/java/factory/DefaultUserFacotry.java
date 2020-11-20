package com.xuxiao.ioc.java.factory;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author xxle
 * @date 2020/6/12 11:27
 */
public class DefaultUserFacotry implements UserFacotry,InitializingBean {
	@Override
	public User createUser(){

		return User.createUser();
	};

	@PostConstruct
	public void initPostConstruct(){
		System.out.println("PostConstruct 开始初始化");
	}
	public void initAnnotation(){
		System.out.println("initAnnotation 自定义 开始初始化");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" InitializingBean afterPropertiesSet 开始初始化");
	}
}
