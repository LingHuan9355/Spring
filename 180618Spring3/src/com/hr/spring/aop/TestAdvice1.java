package com.hr.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestAdvice1
 * @Author : LH
 * @Date : 2018��6��25�� ����11:04:32
 * @Version : V1.0
 * 
 * @Description :   Spring_����֪ͨ&�쳣֪ͨ&����֪ͨ
 */
public class TestAdvice1 {
				
			@SuppressWarnings("resource")
			public static void main(String[] args) {
				 
				     ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				     
				     ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) applicationContext.getBean("arithmeticCalculator");
				
				     System.out.println(arithmeticCalculator.getClass().getName());
				     
				     int result = arithmeticCalculator.add(1, 1);
				     System.out.println("result: " + result);
				     
				     result = arithmeticCalculator.div(1000, 10);
				     System.out.println("result: " + result);
			}
}
