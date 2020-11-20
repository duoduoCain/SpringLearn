package com.xuxiao.life.cycle.domain;

import com.xuxiao.domain.User;

/**
 * @author xxle
 * @date 2020/6/16 14:42
 */
public class UserHolder {

	private User user;

	public UserHolder(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
