package com.xuxiao.domain;

import com.xuxiao.annontation.Super;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xxle
 * @date 2020/6/11 11:58
 */
@Setter
@Getter
@Super
public class SuperUser extends  User {
	private String address;

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
