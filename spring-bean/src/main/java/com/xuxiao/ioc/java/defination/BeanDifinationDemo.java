package com.xuxiao.ioc.java.defination;

import com.xuxiao.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xxle
 * @date 2020/6/11 15:52
 */
public class BeanDifinationDemo {
	public static void main(String[] args) {
		//1：通过BeanDefinitionBuilder 构建
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("id",1).addPropertyValue("name","xuxiao ADD ");
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//		beanDefinition.

		AbstractBeanDefinition abstractBeanDefinition = new GenericBeanDefinition();
		MutablePropertyValues propertyValues = new MutablePropertyValues() ;
		propertyValues.add("id",2)
				.add("name","xuxiao ADD 2");
		abstractBeanDefinition.setPropertyValues(propertyValues);
		abstractBeanDefinition.setBeanClass(User.class);
//		User user = new User();
		DefaultListableBeanFactory applicationContext = new DefaultListableBeanFactory();
		applicationContext.registerBeanDefinition("a",beanDefinition);
		User bean = applicationContext.getBean(User.class);
		System.out.println(bean);
	}
}
