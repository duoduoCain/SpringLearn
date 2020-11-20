package com.xuxiao.life.cycle;

import com.xuxiao.domain.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * @author xxle
 * @date 2020/6/16 13:43
 */
public class InstantiationAwareBeanPostProcessorDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//		beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		String[] location = {"META-INF/dependency-lookup.xml","META-INF/constract-inject.xml"};


		reader.loadBeanDefinitions(location);

		System.out.println("superUser："+beanFactory.getBean("superUser"));
		System.out.println("user："+beanFactory.getBean("user"));
		System.out.println("userHolder："+beanFactory.getBean("userHolder"));

	}

	static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
		@Override
		public  Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
			if(ObjectUtils.nullSafeEquals(beanName,"superUser")){
				SuperUser s = new SuperUser();
				s.setAddress("asdf");
				s.setId(2);
				s.setName("super MyInstantiationAwareBeanPostProcessor");
				return s;
			}
			return null;
		}
	}


}
