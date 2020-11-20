package com.xuxiao.source;

import com.xuxiao.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author xxle
 * @date 2020/6/15 11:02
 */
public class DependencySourceDemo{

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init(){
		System.out.println("beanFactory == applicationEventPublisher :"+(beanFactory == applicationEventPublisher));
		System.out.println("applicationEventPublisher == resourceLoader :"+(applicationEventPublisher == resourceLoader));
		System.out.println("resourceLoader == applicationContext :"+(resourceLoader == applicationContext));
		System.out.println("resourceLoader == applicationContext :"+(resourceLoader == applicationContext));
	}

	@PostConstruct
	public void initLookup(){
//		getBean(BeanFactory.class);
//		getBean(ApplicationEventPublisher.class);
//		getBean(ResourceLoader.class);
//		getBean(ApplicationContext.class);
		printException("BeanFactory",new FutureTask<BeanFactory>(()->getBean(BeanFactory.class)));
	}

	private BeanFactory getBean (Class<BeanFactory> tClass){
		return beanFactory.getBean(tClass);
	}

	private BeanFactory printException( String name , FutureTask<BeanFactory> runnable){
		try {
			runnable.run();
			BeanFactory beanFactory = runnable.get();
			return beanFactory;
		}  catch (NoSuchBeanDefinitionException e) {

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.err.println("没有找到bean :" +name+";错误消息为： "+e.getMessage()+"当前线程为："+Thread.currentThread().getName());
		}
		return null;
	}



	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DependencySourceDemo.class);
		context.refresh();

		System.out.println("AnnotationBeanDefinitionDemo:"+context.getBeansOfType(DependencySourceDemo.class));

		context.close();

	}

}
