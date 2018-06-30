package com.hr.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.spring.hibernate.service.BookShopService;
import com.hr.spring.hibernate.service.Cashier;

/**
 * 
 * @Name  : CashierImpl
 * @Author : LH
 * @Date : 2018年7月1日 上午12:11:16
 * @Version : V1.0
 * 
 * @Description :
 */

@Service
public class CashierImpl implements Cashier {

			@Autowired
			private BookShopService bookShopService;
	
			@Override
			public void checkout(String username, List<String> isbns) {
						for (String isbn : isbns) {
							   bookShopService.purchase(username, isbn);
						}
				
			}

}
