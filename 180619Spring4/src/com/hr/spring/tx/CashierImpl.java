package com.hr.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.spring.tx.service.BookShopService;

/**
 * 
 * @Name  : CashierImpl
 * @Author : LH
 * @Date : 2018年6月28日 下午11:51:24
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("cashier")
public class CashierImpl implements Cashier {

			@Autowired
			private BookShopService bookShopService;
				
			@Transactional
			@Override
			public void checkout(String username, List<String> isbns) {
						for (String isbn : isbns) {
								bookShopService.purchase(username, isbn);
						}
			}

}
