package com.hr.spring.aop.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestAspectJ2
 * @Author : LH
 * @Date : 2018年6月25日 下午9:44:02
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestAspectJ2 {

			@Test
			public void test() {
				//1.创建Spring 的 IOC 容器
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				//2.从 IOC 容器 中获取 bean 的实例
				ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);
				
				//3.使用Bean
				int result = arithmeticCalculator.add(3, 6);
				System.out.println("result: " + result);
			
				 result = arithmeticCalculator.div(12, 6);
				System.out.println("result: " + result);
				
			}

}
