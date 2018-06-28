package com.hr.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.spring.tx.exception.BookStockException;
import com.hr.spring.tx.exception.UserAccountException;

/**
 * 
 * @Name  : BookShowImpl
 * @Author : LH
 * @Date : 2018��6��28�� ����6:46:44
 * @Version : V1.0
 * 
 * @Description :
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

			@Autowired
			private JdbcTemplate jdbcTemplate;
			
			/**
			 * //������Ż�ȡ��ĵ���
			 */
			@Override
			public int findBookPriceByIsbn(String isbn) {
				String sql = "SELECT price FROM book WHERE isbn = ?";
				
				return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
			}
		
			/**
			 * //������Ŀ�棬ʹ��Ŷ�Ӧ�Ŀ�� - 1
			 */
			@Override
			public void updateBookStock(String isbn) {
					
					//�����Ŀ���Ƿ��㹻�������������׳��쳣
					String sql= "select stock from book_stock  where isbn = ?";
					int stock =  jdbcTemplate.queryForObject(sql, Integer.class, isbn);
					if(stock == 0) {
						   throw new BookStockException("��治�㣡");
					}
					
					String sql2= "update book_stock set stock = stock -1 where isbn = ?";
					jdbcTemplate.update(sql2, isbn);
			}

			/**
			 * //�����û��˻���ʹ���û��� banlace - price
			 */
			@Override
			public void updateUserAccount(String username, int price) {
				
				//��֤����Ƿ��㹻�������㣬�����쳣
				String sql = "select balance from account where username = ?";
			 	int  balance =  jdbcTemplate.queryForObject(sql, Integer.class, username);
				if(balance  < price ) {
					throw new UserAccountException("���㣡");
				}
				String sql2 ="update account set balance = balance - ?  where  username = ?";
				jdbcTemplate.update(sql2, price, username);
			}

}
