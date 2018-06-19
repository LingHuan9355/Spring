package com.hr.spring.beans.scope;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.autowire.Car;



/**
 * 
 * @Name  : TestScope5
 * @Author : LH
 * @Date : 2018年6月19日 下午10:53:45
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestScope5 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-scope.xml");

		        	Car car = (Car) context.getBean("car");
		        	Car car2 = (Car) context.getBean("car");
		        	System.out.println(car == car2);
			}

}
