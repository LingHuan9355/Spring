package com.hr.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hr.spring.hibernate.dao.BookShopDao;
import com.hr.spring.hibernate.exception.BookStockException;
import com.hr.spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {

			@Autowired
			private SessionFactory sessionFactory;
			
			//不推荐使用HibernateTemplate 和 HibernateDaoSupport
			//因为这样会导致 Dao 和 Spring  的API 进行耦合 ，可以移植性变差
			//private HibernateTemplate hibernateTemplate;
			
			//获取和当前线程绑定的 Session
			private Session getSession() {
				return sessionFactory.getCurrentSession();
			}
	
	
			@Override
			public int findBookPriceByIsbn(String isbn) {
					String hql = "select b.price from Book b where b.isbn = ?";
					Query query = getSession().createQuery(hql).setString(0, isbn);
					return (Integer) query.uniqueResult();
			}
		
			@Override
			public void updateBookStock(String isbn) {
					//验证书的库存是否充足。
				  String hql2 = "select b.stock from Book b where b.isbn = ?";
				  int stock = (int)getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
				  if(stock == 0 ) {
					  throw new BookStockException("库存不足！");
				  }
				  
				  String hql = "update Book b set  b.stock = b.stock - 1 where  b.isbn = ? ";
				  getSession().createQuery(hql).setString(0, isbn).executeUpdate();
			}
		
			@Override
			public void updateUserAccount(String username, int price) {
						//验证余额是否足够
						String hql2 = "select a.balance  from Account  a  where  a.userName =  ?";
						int balance = (int) getSession().createQuery(hql2).setString(0, username).uniqueResult();
						if(balance < price) {
							throw new UserAccountException("余额不足 ！");
						}
						
						String hql = "update Account a  set  a.balance = a.balance - ?  where a.userName = ?";
						getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
			}

}
