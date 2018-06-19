package com.hr.spring.beans.properties;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @Name  : TestProperties6
 * @Author : LH
 * @Date : 2018��6��19�� ����11:31:37
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestProperties6 {

			@SuppressWarnings("resource")
			@Test
			public void test() throws SQLException {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-properties.xml");

		        		DataSource dataSource = (DataSource) context.getBean("dataSource");
		        		System.out.println(dataSource.getConnection());
			}

}
