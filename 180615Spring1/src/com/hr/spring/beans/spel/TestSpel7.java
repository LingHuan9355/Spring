package com.hr.spring.beans.spel;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestSpel7
 * @Author : LH
 * @Date : 2018年6月20日 上午12:15:37
 * @Version : V1.0
 * 
 * @Description :SpEL：
 * 1.字面量
 * 2.引用 Bean、属性和方法
 * 3.支持的运算符号
 */
public class TestSpel7 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-spel.xml");
		        	
		        	Address address = (Address) context.getBean("address");
		        	System.out.println(address);

		        	Car car = (Car) context.getBean("car");
		        	System.out.println(car);
		
		        	Person person =(Person) context.getBean("person");
		        	System.out.println(person);
			}

}
