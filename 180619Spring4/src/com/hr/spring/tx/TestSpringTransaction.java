package com.hr.spring.tx;


import java.util.Arrays;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.tx.dao.BookShopDao;
import com.hr.spring.tx.service.BookShopService;

/**
 * 
 * @Name  : TestSpringTransaction
 * @Author : LH
 * @Date : 2018年6月28日 下午10:37:35
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
			 * 测试事务的传播行为
			 */
			@Test
			public void testTransactionalPropagation() {
					cashier.checkout("Carl", Arrays.asList("1001","1002"));
			}
			
	
			/**
			 * 事务管理：购买书籍，库存更新，以及账号余额更新的业务操作
			 */
			@Test
			public void testBookShowService() {
				  bookShopService.purchase("Carl", "1001");
			}
			
			
			/**
			 * 根据书号获取书的单价
			 */
			@Test
			public void testBookShopDaoFindBookPriceByIsbn() {
					System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
			}
			
			/**
			 * 更新书的库存，使书号对应的库存 - 1
			 */
			@Test
			public void testBookShopDaoUpdateBookStock() {
				    bookShopDao.updateBookStock("1001");
			}
			
			/**
			 * 更新用户账户余额，使用用户的 banlace - price
			 */
			@Test
			public void testBookShopDaoUpdateUserAccount() {
					bookShopDao.updateUserAccount("Carl", 100);
			}

}
