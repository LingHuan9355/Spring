package com.hr.spring.beans.cycle;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.cycle.Car;

/**
 * 
 * @Name  : TestCycle8
 * @Author : LH
 * @Date : 2018年6月20日 上午12:29:53
 * @Version : V1.0
 * 
 * @Description :IOC 容器中 Bean 的生命周期方法
 */
public class TestCycle8 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
				
				ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("beans-cycle.xml");

		        	Car	car = (Car) context.getBean("car");
		        	System.out.println(car );
		        	
		        	//关闭IOC容器
		        	context.close();
			}

}
