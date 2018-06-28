package com.hr.spring.tx.xml.service;

import java.util.List;

/**
 * 
 * @Name  : Cashier
 * @Author : LH
 * @Date : 2018年6月28日 下午11:48:51
 * @Version : V1.0
 * 
 * @Description :新定义 Cashier 接口: 表示客户的结账操作
 */
public interface Cashier {
	
	
		public void checkout(String username,List<String> isbns);
		
		
		
}
