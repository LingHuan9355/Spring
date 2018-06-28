package com.hr.spring.tx.xml;

/**
 * 
 * @Name  : BookShopDao
 * @Author : LH
 * @Date : 2018��6��28�� ����6:41:34
 * @Version : V1.0
 * 
 * @Description :
 */
public interface BookShopDao {

			//������Ż�ȡ��ĵ���
			public int findBookPriceByIsbn(String isbn);
			
			//������Ŀ�棬ʹ��Ŷ�Ӧ�Ŀ�� - 1
			public void updateBookStock(String isbn);
			
			//�����û��˻���ʹ���û��� banlace - price
			public void updateUserAccount(String username,int price);
	
}
