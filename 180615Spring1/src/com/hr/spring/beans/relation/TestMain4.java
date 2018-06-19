package com.hr.spring.beans.relation;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.autowire.Address;
import com.hr.spring.beans.autowire.Person;


/**
 * 
 * @Name  : TestMain4
 * @Author : LH
 * @Date : 2018年6月18日 下午5:27:15
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestMain4 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-relation.xml");
		        	
		        	Address address =  (Address) context.getBean("address3");
		        	 System.out.println(address);
		        	
		        	 address =  (Address) context.getBean("address2");
		        	System.out.println(address);
	
		        	Person person = (Person) context.getBean("person");
		        	System.out.println(person);
			}

}
