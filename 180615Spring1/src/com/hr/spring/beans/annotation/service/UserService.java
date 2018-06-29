package com.hr.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hr.spring.beans.annotation.repository.UserRepository;

/**
 * 
 * @Name  : UserService
 * @Author : LH
 * @Date : 2018年6月24日 下午6:31:51
 * @Version : V1.0
 * 
 * @Description :业务逻辑层
 */

@Service
public class UserService {

		//@Autowired
		//@Qualifier("userRepositoryImpl")
		private UserRepository userRepository;
	
		@Autowired
		//@Qualifier("userRepositoryImpl")
		 public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
			this.userRepository = userRepository;
		}


		public void add() {
			 System.out.println("UserService add() ...");
			 userRepository.save();
		 }
}
