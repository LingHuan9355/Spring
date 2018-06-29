package com.hr.spring.tx.dao;

/**
 * 
 * @Name  : BookShopDao
 * @Author : LH
 * @Date : 2018年6月28日 下午6:41:34
 * @Version : V1.0
 * 
 * @Description :
 */
public interface BookShopDao {

			//根据书号获取书的单价
			public int findBookPriceByIsbn(String isbn);
			
			//更新书的库存，使书号对应的库存 - 1
			public void updateBookStock(String isbn);
			
			//更新用户账户余额，使用用户的 banlace - price
			public void updateUserAccount(String username,int price);
	
}
