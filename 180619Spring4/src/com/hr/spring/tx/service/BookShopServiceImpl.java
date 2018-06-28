package com.hr.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.spring.tx.dao.BookShopDao;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018年6月28日 下午11:08:31
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

			@Autowired
			private BookShopDao bookShopDao;
			
			//添加事务注解
			@Transactional
			@Override
			public void purchase(String username, String isbn) {
					//1.获取书的单价
					int price = bookShopDao.findBookPriceByIsbn(isbn);
				
					//2.更新书的库存
					 bookShopDao.updateBookStock(isbn);
				
					//3.更新用户的余额
					 bookShopDao.updateUserAccount(username, price);
			}

}
