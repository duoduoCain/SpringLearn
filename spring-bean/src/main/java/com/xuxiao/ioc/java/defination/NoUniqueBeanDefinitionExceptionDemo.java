package com.xuxiao.ioc.java.defination;

import com.xuxiao.domain.User;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author xxle
 * @date 2020/6/14 12:13
 */
public class NoUniqueBeanDefinitionExceptionDemo {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(NoUniqueBeanDefinitionExceptionDemo.class);
//		context.refresh();

		try {

//			User bean1 = context.getBean(User.class);//NoSuchBeanDefinitionException
//
//			String bean = context.getBean(String.class);//NoUniqueBeanDefinitionException

			createBeanInstantiationException( context);

		} catch (NoUniqueBeanDefinitionException ex) {
//			e.printStackTrace();
			System.out.println("不是唯一的bean ："+ex.getMessage());
		}catch (NoSuchBeanDefinitionException ex){
			System.out.println("NoSuchBeanDefinitionException ："+ex.getMessage());
		}catch (BeanInstantiationException ex){
			System.out.println("BeanInstantiationException 卧槽："+ex);
		}finally {
			context.close();
		}

	}

	private static void createBeanInstantiationException(AnnotationConfigApplicationContext context) throws BeanInstantiationException{
		try {
			BeanDefinitionBuilder beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
			context.registerBeanDefinition("asdf",beanDefinition.getBeanDefinition());
			context.refresh();
		} catch (BeansException e) {
			if(e instanceof BeanInstantiationException){
				BeanInstantiationException cast = BeanInstantiationException.class.cast(e);
				throw cast;
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	@Bean
	public  static String bean1(){
		return "111";
	}


	@Bean
	public  static String bean2(){
		return "222";
	}

}
