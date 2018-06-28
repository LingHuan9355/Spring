package com.hr.spring.tx.xml.service.impl;

import java.util.List;

import com.hr.spring.tx.xml.service.BookShopService;
import com.hr.spring.tx.xml.service.Cashier;

/**
 * 
 * @Name  : CashierImpl
 * @Author : LH
 * @Date : 2018年6月28日 下午11:51:24
 * @Version : V1.0
 * 
 * @Description :
 */
public class CashierImpl implements Cashier {

			private BookShopService bookShopService;
				
			public void setBookShopService(BookShopService bookShopService) {
				this.bookShopService = bookShopService;
			}
			
			@Override
			public void checkout(String username, List<String> isbns) {
						for (String isbn : isbns) {
								bookShopService.purchase(username, isbn);
						}
			}

}
