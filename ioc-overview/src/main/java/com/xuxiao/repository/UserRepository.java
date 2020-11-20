package com.xuxiao.repository;

import com.xuxiao.annontation.Super;
import com.xuxiao.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author xxle
 * @date 2020/6/11 13:57
 */
@Getter
@Setter
@ToString
public class UserRepository {

	private Collection<User> users;

	private BeanFactory beanFactory;

	private ObjectFactory<User> userObjectFactory;

	private ObjectFactory<ApplicationContext> applicationContextObjectFactory;
}
