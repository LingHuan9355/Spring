package com.hr.spring.tx;

import static org.junit.Assert.*;

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
 * @Date : 2018��6��28�� ����10:37:35
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestSpringTransaction {

			private ApplicationContext  context = null;
			private BookShopDao bookShopDao = null;
			private BookShopService bookShopService = null;
	
			{
				context = new ClassPathXmlApplicationContext("applicationContext.xml");
				bookShopDao = context.getBean(BookShopDao.class);
				bookShopService = context.getBean(BookShopService.class);
			}
	
			/**
			 * ������������鼮�������£��Լ��˺������µ�ҵ�����
			 */
			@Test
			public void testBookShowService() {
				  bookShopService.purchase("Carl", "1001");
			}
			
			
			/**
			 * ������Ż�ȡ��ĵ���
			 */
			@Test
			public void testBookShopDaoFindBookPriceByIsbn() {
					System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
			}
			
			/**
			 * ������Ŀ�棬ʹ��Ŷ�Ӧ�Ŀ�� - 1
			 */
			@Test
			public void testBookShopDaoUpdateBookStock() {
				    bookShopDao.updateBookStock("1001");
			}
			
			/**
			 * �����û��˻���ʹ���û��� banlace - price
			 */
			@Test
			public void testBookShopDaoUpdateUserAccount() {
					bookShopDao.updateUserAccount("Carl", 100);
			}

}
