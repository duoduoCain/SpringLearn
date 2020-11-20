package com.xuxiao.difination;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xxle
 * @date 2020/6/12 11:09
 */
public class BeanInstantiationDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/instantiation-way.xml");

	}
}
