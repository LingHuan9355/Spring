package com.hr.spring.hibernate.service;

import java.util.List;

/**
 * 
 * @Name  : Cashier
 * @Author : LH
 * @Date : 2018年6月30日 下午11:30:07
 * @Version : V1.0
 * 
 * @Description : 新定义 Cashier 接口: 表示客户的结账操作
 */
public interface Cashier {
	
	
		public void checkout(String username,List<String> isbns);
		
		
		
}
