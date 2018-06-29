package com.hr.spring.beans.collections;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestMain2
 * @Author : LH
 * @Date : 2018年6月18日 下午5:27:15
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestMain2 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		        	
		        	Person person = (Person) context.getBean("person5");
		        	System.out.println(person);
			
		        	NewPerson newPerson = (NewPerson) context.getBean("newPerson");
		            System.out.println(newPerson);
		            
		            DataSource dataSource = (DataSource) context.getBean("dataSource");
		            System.out.println(dataSource.getProperties());
			}

}
