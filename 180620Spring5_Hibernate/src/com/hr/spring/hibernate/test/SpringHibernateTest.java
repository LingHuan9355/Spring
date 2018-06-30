package com.hr.spring.hibernate.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.hibernate.service.BookShopService;
import com.hr.spring.hibernate.service.Cashier;

/**
 * 
 * @Name  : SpringHibernateTest
 * @Author : LH
 * @Date : 2018年6月30日 下午10:39:02
 * @Version : V1.0
 * 
 * @Description :
 */
public class SpringHibernateTest {
                
			private ApplicationContext  context = null;
			private BookShopService bookShopService = null;
			private Cashier cashier = null;
			
			{
				context = new ClassPathXmlApplicationContext("applicationContext.xml");
				bookShopService = context.getBean(BookShopService.class);
				cashier = context.getBean(Cashier.class);
			}
			
			@Test
			public void testCashier() {
				cashier.checkout("carl", Arrays.asList("1001","1002"));
			}
			
			@Test
			public void testBookShopService() {
				bookShopService.purchase("carl", "1001");
			}
			
			
			@Test
			public void testDataSource() throws SQLException {
						DataSource dataSource = context.getBean(DataSource.class);
						System.out.println(dataSource.getConnection());
			}
}
