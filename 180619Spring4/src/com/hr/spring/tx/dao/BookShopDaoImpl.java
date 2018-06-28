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
 * @Date : 2018年6月28日 下午6:46:44
 * @Version : V1.0
 * 
 * @Description :
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

			@Autowired
			private JdbcTemplate jdbcTemplate;
			
			/**
			 * //根据书号获取书的单价
			 */
			@Override
			public int findBookPriceByIsbn(String isbn) {
				String sql = "SELECT price FROM book WHERE isbn = ?";
				
				return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
			}
		
			/**
			 * //更新书的库存，使书号对应的库存 - 1
			 */
			@Override
			public void updateBookStock(String isbn) {
					
					//检查书的库存是否足够，若不够，则抛出异常
					String sql= "select stock from book_stock  where isbn = ?";
					int stock =  jdbcTemplate.queryForObject(sql, Integer.class, isbn);
					if(stock == 0) {
						   throw new BookStockException("库存不足！");
					}
					
					String sql2= "update book_stock set stock = stock -1 where isbn = ?";
					jdbcTemplate.update(sql2, isbn);
			}

			/**
			 * //更新用户账户余额，使用用户的 banlace - price
			 */
			@Override
			public void updateUserAccount(String username, int price) {
				
				//验证余额是否足够，若不足，则抛异常
				String sql = "select balance from account where username = ?";
			 	int  balance =  jdbcTemplate.queryForObject(sql, Integer.class, username);
				if(balance  < price ) {
					throw new UserAccountException("余额不足！");
				}
				String sql2 ="update account set balance = balance - ?  where  username = ?";
				jdbcTemplate.update(sql2, price, username);
			}

}
