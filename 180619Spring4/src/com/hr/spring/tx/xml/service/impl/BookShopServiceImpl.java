package com.hr.spring.tx.xml.service.impl;

import com.hr.spring.tx.xml.BookShopDao;
import com.hr.spring.tx.xml.service.BookShopService;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018年6月28日 下午11:08:31
 * @Version : V1.0
 * 
 * @Description :
 */
public class BookShopServiceImpl implements BookShopService {

			private BookShopDao bookShopDao;
			
			public void setBookShopDao(BookShopDao bookShopDao) {
				this.bookShopDao = bookShopDao;
			}
			
			@Override
			public void purchase(String username, String isbn) {
				
				/*try {
					Thread.sleep(1000);//超过5秒事务强制回滚
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				
				
					//1.获取书的单价
					int price = bookShopDao.findBookPriceByIsbn(isbn);
				
					//2.更新书的库存
					 bookShopDao.updateBookStock(isbn);
				
					//3.更新用户的余额
					 bookShopDao.updateUserAccount(username, price);
			}

}
