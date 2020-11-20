package com.xuxiao.inject;

import com.xuxiao.domain.User;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xxle
 * @date 2020/6/14 14:26
 */
@Getter
@Setter
public class UserHolder {

	private User user;

	public UserHolder(User user) {
		this.user = user;
	}

	public UserHolder() {
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
