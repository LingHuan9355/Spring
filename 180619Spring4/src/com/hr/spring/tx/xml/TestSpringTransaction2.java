package com.hr.spring.tx.xml;


import java.util.Arrays;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.tx.xml.service.BookShopService;
import com.hr.spring.tx.xml.service.Cashier;

/**
 * 
 * @Name  : TestSpringTransaction
 * @Author : LH
 * @Date : 2018年6月28日 下午10:37:35
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestSpringTransaction2 {

			private ApplicationContext  context = null;
			private BookShopDao bookShopDao = null;
			private BookShopService bookShopService = null;
			private Cashier cashier = null;
			
			{
				context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
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
			public void testBookShopService() {
				  bookShopService.purchase("Carl", "1001");
			}
			
			


}
