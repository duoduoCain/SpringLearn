package com.xuxiao.life.cycle;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author xxle
 * @date 2020/6/15 17:20
 */
public class AnnotatedBeanDefinitionReaderDemo {

	public static void main(String[] args) {


		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
		System.out.println("刚刚初始化完成的容器："+beanFactory.getBeanDefinitionCount());
		// 非component
		reader.registerBean(AnnotatedBeanDefinitionReaderDemo.class,"asdf");

		System.out.println("初始化完成之后的容器："+beanFactory.getBean("asdf"));

		System.out.println("初始化完成之后的容器："+beanFactory.getBeanDefinitionCount());

	}
}
