package com.hr.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * 
 * @Name  : UserRepositoryImpl
 * @Author : LH
 * @Date : 2018年6月24日 下午6:29:55
 * @Version : V1.0
 * 
 * @Description :
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

		@Override
		public void save() {
				System.out.println("UserRepository Save() ....");
		}

		
}
