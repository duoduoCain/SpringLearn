package com.xuxiao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author xxle
 * @date 2020/6/11 11:31
 */
@Getter
@Setter
@ToString
public class User implements BeanNameAware,InitializingBean,DisposableBean{

	private Integer id;

	private String name;

	private transient  String beanName ;

	public static User createUser(){
		User user = new User();
		user.setId(1);
		user.setName("default");
		return user;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("user bean 开始销毁 ：beanName 是："+this.beanName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("user bean 开始初始化 ：beanName 是："+this.beanName);
	}
}
