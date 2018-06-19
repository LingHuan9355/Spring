package com.hr.spring.beans.spel;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestSpel7
 * @Author : LH
 * @Date : 2018��6��20�� ����12:15:37
 * @Version : V1.0
 * 
 * @Description :SpEL��
 * 1.������
 * 2.���� Bean�����Ժͷ���
 * 3.֧�ֵ��������
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
