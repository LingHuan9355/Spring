package com.hr.spring.beans.autowire;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestMain3
 * @Author : LH
 * @Date : 2018年6月18日 下午5:27:15
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestMain3 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-autowire.xml");
		        	
		        	Person person = (Person) context.getBean("person");
		        	System.out.println(person);
			}

}
