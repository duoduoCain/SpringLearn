package com.xuxiao.ioc.java.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author xxle
 * @date 2020/6/10 22:04
 */
public class BeanInfoDemo {

	public static void main(String[] args) throws IntrospectionException {

		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
//		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
		Stream.of(beanInfo.getPropertyDescriptors())
				.forEach(propertyDescriptor ->{
					Class<?> propertyType = propertyDescriptor.getPropertyType();
					String name = propertyDescriptor.getName();
					if("age".equals(name)){
//						Integer.valueOf("12354")
						propertyDescriptor.setPropertyEditorClass(String2Integer.class);
					}
					System.out.println(propertyDescriptor);

				});
		Person person = new Person();
		person.setAge(123);
		person.setName("asdf");
		System.out.println(person);
	}
	static class String2Integer extends PropertyEditorSupport{
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Integer integer = Integer.valueOf(text);
			setValue(12341234);
//			super.setAsText(text);
		}
	}
}
