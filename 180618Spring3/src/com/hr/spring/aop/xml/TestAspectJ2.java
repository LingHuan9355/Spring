package com.hr.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestAspectJ2
 * @Author : LH
 * @Date : 2018年6月26日 上午12:52:44
 * @Version : V1.0
 * 
 * @Description :用基于 XML 的配置声明切面
 */
public class TestAspectJ2 {
				
			@SuppressWarnings("resource")
			public static void main(String[] args) {
				 
				     ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
				     
				     ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) applicationContext.getBean("arithmeticCalculator");
				
				     //System.out.println(arithmeticCalculator.getClass().getName());
				     
				     int result = arithmeticCalculator.add(1, 1);
				     System.out.println("result: " + result);
				     
				     result = arithmeticCalculator.div(1000, 10);
				     System.out.println("result: " + result);
			}
}
