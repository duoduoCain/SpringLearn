package com.xuxiao.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置
 * @author xxle
 * @date 2020/6/15 13:46
 */
@Configuration
@PropertySource("META-INF/default.properties")
public class ResolverDependencySourceDemo {

	@Value("${user.id}")
	private Long id;

	@Value("${user.resource}")
	private Resource resource;


	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ResolverDependencySourceDemo.class);
		context.refresh();
		ResolverDependencySourceDemo bean = context.getBean(ResolverDependencySourceDemo.class);

		System.out.println("ResolverDependencySourceDemo:"+context.getBeansOfType(DependencySourceDemo.class));
		System.out.println(bean.id);
		System.out.println(bean.resource);
		context.close();

	}
}
