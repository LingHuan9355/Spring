package com.hr.spring.beans.generic.di;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @Name  : TestGenericDI12
 * @Author : LH
 * @Date : 2018年6月25日 下午12:44:35
 * @Version : V1.0
 * 
 * @Description : Spring 4.x 中可以为子类注入子类对应的泛型类型的成员变量的引用
 */
public class TestGenericDI12 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
					ApplicationContext context = new ClassPathXmlApplicationContext("beans-generic-di.xml");
					
		        	UserService userService = (UserService) context.getBean("userService");
		        	userService.add();
			}

}
