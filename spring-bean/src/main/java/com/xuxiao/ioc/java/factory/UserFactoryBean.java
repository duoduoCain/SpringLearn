package com.xuxiao.ioc.java.factory;

import com.xuxiao.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author xxle
 * @date 2020/6/12 11:32
 */
public class UserFactoryBean implements FactoryBean<User> {
	@Nullable
	@Override
	public User getObject() throws Exception {
		User user = new User();
		user.setId(1);
		user.setName("UserFactoryBean");
		return user;
	}

	@Nullable
	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
