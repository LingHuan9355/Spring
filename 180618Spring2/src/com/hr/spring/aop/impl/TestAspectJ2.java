package com.hr.spring.aop.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestAspectJ2
 * @Author : LH
 * @Date : 2018��6��25�� ����9:44:02
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestAspectJ2 {

			@Test
			public void test() {
				//1.����Spring �� IOC ����
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				//2.�� IOC ���� �л�ȡ bean ��ʵ��
				ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);
				
				//3.ʹ��Bean
				int result = arithmeticCalculator.add(3, 6);
				System.out.println("result: " + result);
			
				 result = arithmeticCalculator.div(12, 6);
				System.out.println("result: " + result);
				
			}

}
