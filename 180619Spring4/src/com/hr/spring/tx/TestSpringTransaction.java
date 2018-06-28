package com.hr.spring.tx;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.naming.Context;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.tx.dao.BookShopDao;
import com.hr.spring.tx.service.BookShopService;

/**
 * 
 * @Name  : TestSpringTransaction
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}28~{HU~} ~{OBNg~}10:37:35
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestSpringTransaction {

			private ApplicationContext  context = null;
			private BookShopDao bookShopDao = null;
			private BookShopService bookShopService = null;
			private Cashier cashier = null;
			
			{
				context = new ClassPathXmlApplicationContext("applicationContext.xml");
				bookShopDao = context.getBean(BookShopDao.class);
				bookShopService = context.getBean(BookShopService.class);
				cashier = context.getBean(Cashier.class);
			}
			
			/**
			 * ~{2bJTJBNq5D4+2%PPN*~}
			 */
			@Test
			public void testTransactionalPropagation() {
					cashier.checkout("Carl", Arrays.asList("1001","1002"));
			}
			
	
			/**
			 * ~{JBNq9\@m#:9:BrJi<.#,?b4f8|PB#,RT<0UK:ES`6n8|PB5DR5Nq2YWw~}
			 */
			@Test
			public void testBookShowService() {
				  bookShopService.purchase("Carl", "1001");
			}
			
			
			/**
			 * ~{8y>]Ji:E;qH!Ji5D5%<[~}
			 */
			@Test
			public void testBookShopDaoFindBookPriceByIsbn() {
					System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
			}
			
			/**
			 * ~{8|PBJi5D?b4f#,J9Ji:E6TS&5D?b4f~} - 1
			 */
			@Test
			public void testBookShopDaoUpdateBookStock() {
				    bookShopDao.updateBookStock("1001");
			}
			
			/**
			 * ~{8|PBSC;'UK;'S`6n#,J9SCSC;'5D~} banlace - price
			 */
			@Test
			public void testBookShopDaoUpdateUserAccount() {
					bookShopDao.updateUserAccount("Carl", 100);
			}

}
