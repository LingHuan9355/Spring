package com.hr.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hr.spring.beans.annotation.TestObject;

/**
 * 
 * @Name  : UserRepositoryImpl
 * @Author : LH
 * @Date : 2018年6月24日 下午6:29:55
 * @Version : V1.0
 * 
 * @Description :
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	    @Autowired(required=false)
		private TestObject testObject;
		
		@Override
		public void save() {
				System.out.println("UserRepository Save() ....");
				System.out.println(testObject);
		}

		
}
