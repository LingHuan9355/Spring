package com.hr.spring.tx.xml.service;

import java.util.List;

/**
 * 
 * @Name  : Cashier
 * @Author : LH
 * @Date : 2018��6��28�� ����11:48:51
 * @Version : V1.0
 * 
 * @Description :�¶��� Cashier �ӿ�: ��ʾ�ͻ��Ľ��˲���
 */
public interface Cashier {
	
	
		public void checkout(String username,List<String> isbns);
		
		
		
}
