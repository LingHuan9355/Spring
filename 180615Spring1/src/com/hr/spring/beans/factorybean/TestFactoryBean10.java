package com.hr.spring.beans.factorybean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @Name  : TestFactoryBean9
 * @Author : LH
 * @Date : 2018��6��24�� ����12:35:11
 * @Version : V1.0
 * 
 * @Description :ʵ�� FactoryBean �ӿ��� Spring IOC ���������� Bean
 * 
 * Bean �����÷�ʽ��
 *  1.ͨ��ȫ���������䣩��
 *  2.ͨ��������������̬�������� & ʵ��������������
 *  3.FactoryBean
 */
public class TestFactoryBean10 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-factorybean.xml");

		        	Car car = (Car) context.getBean("car");
		        	System.out.println(car);
		        	
		        	
		        	
			}

}
