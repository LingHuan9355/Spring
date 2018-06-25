package com.hr.spring.beans.generic.di;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @Name  : TestGenericDI12
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}12:44:35
 * @Version : V1.0
 * 
 * @Description : Spring 4.x ~{VP?IRTN*WS@`W"HkWS@`6TS&5D7:PM@`PM5D3IT11dA?5DR}SC~}
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
