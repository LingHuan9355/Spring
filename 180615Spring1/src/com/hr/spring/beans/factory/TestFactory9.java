package com.hr.spring.beans.factory;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *  
 * @Name  : TestFactory9
 * @Author : LH
 * @Date : 2018��6��24�� ����12:06:21
 * @Version : V1.0
 * 
 * @Description :ͨ�����þ�̬������������ Bean
 * 
 * ���þ�̬������������ Bean�ǽ����󴴽��Ĺ��̷�װ����̬������. 
 * ���ͻ�����Ҫ����ʱ, ֻ��Ҫ�򵥵ص��þ�̬����, ����ͬ���Ĵ��������ϸ��.
 *
 * Bean �����÷�ʽ��
 *  1.ͨ��ȫ���������䣩��
 *  2.ͨ��������������̬�������� & ʵ��������������
 *  3.FactoryBean

 */
public class TestFactory9 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-factory.xml");

		        	Car car1 = (Car) context.getBean("car1");
		        	System.out.println(car1);
		        	
		        	Car car2 = (Car) context.getBean("car2");
		        	System.out.println(car2);
		        	
		        	
			}

}
