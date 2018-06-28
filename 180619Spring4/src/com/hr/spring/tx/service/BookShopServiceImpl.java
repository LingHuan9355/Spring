package com.hr.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.spring.tx.dao.BookShopDao;

/**
 * 
 * @Name  : BookShopServiceImpl
 * @Author : LH
 * @Date : 2018��6��28�� ����11:08:31
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

			@Autowired
			private BookShopDao bookShopDao;
			
			//�������ע��
			@Transactional
			@Override
			public void purchase(String username, String isbn) {
					//1.��ȡ��ĵ���
					int price = bookShopDao.findBookPriceByIsbn(isbn);
				
					//2.������Ŀ��
					 bookShopDao.updateBookStock(isbn);
				
					//3.�����û������
					 bookShopDao.updateUserAccount(username, price);
			}

}
