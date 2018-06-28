package com.hr.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hr.spring.tx.dao.BookShopDao;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}28~{HU~} ~{OBNg~}11:08:31
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

			@Autowired
			private BookShopDao bookShopDao;
			
			//~{Lm<SJBNqW"=b~}
			//~{J9SC~}propagation ~{V86(JBNq5D4+2%PPN*#,<451G0JBNq7=7(1;AmMbR;8vJBNq7=7(5wSCJ1~}
			//~{Hg:NJ9SCJBNq#,D,HOH!V5~} REQUIRED ~{#,<4J9SC5wSC7=7(5DJBNq~}
			//REQUIRES_NEW:~{J9SCWT<:5DJBNq#,5wSC5DJBNq7=7(5DJBNq1;9RFp~}
			@Transactional(propagation =Propagation.REQUIRES_NEW)
			@Override
			public void purchase(String username, String isbn) {
					//1.~{;qH!Ji5D5%<[~}
					int price = bookShopDao.findBookPriceByIsbn(isbn);
				
					//2.~{8|PBJi5D?b4f~}
					 bookShopDao.updateBookStock(isbn);
				
					//3.~{8|PBSC;'5DS`6n~}
					 bookShopDao.updateUserAccount(username, price);
			}

}
