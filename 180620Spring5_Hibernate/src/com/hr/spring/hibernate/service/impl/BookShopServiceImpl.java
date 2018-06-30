package com.hr.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.spring.hibernate.dao.BookShopDao;
import com.hr.spring.hibernate.service.BookShopService;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018年7月1日 上午12:07:49
 * @Version : V1.0
 * 
 * @Description : 业务逻辑操作
 */
@Service
public class BookShopServiceImpl implements BookShopService {

			@Autowired
			private BookShopDao bookShopDao;
	
			/**
			 * Spring hibernate 事务的流程
			 * 1.在方法开始之前
			 * ①.获取 Session
			 * ② 把 Session 和当前线程绑定，这样就可以在 Dao 中使用 SessionFactory的
			 *  getCurrentSession() 方法来获取 Session
			 *  ③开启事务
			 *  
			 *  2.若方法正常结束，即没有出现异常，则
			 *  ①.提交事务
			 *  ②.使和当前线程绑定的Session 解除绑定
			 *  ③.关闭 Session
			 *  
			 *  3.若方法出现异常，则：
			 *  ①.回滚事务
			 *  ②.使和当前绑定的Session 解除绑定
			 *  ③.关闭Session
			 */
			@Override
			public void purchase(String username, String isbn) {
					int price = bookShopDao.findBookPriceByIsbn(isbn);
					bookShopDao.updateBookStock(isbn);
					bookShopDao.updateUserAccount(username, price);
			}

}
