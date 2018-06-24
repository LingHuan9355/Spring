package com.hr.spring.beans.annotation.service;

import org.springframework.stereotype.Service;

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
		
		 public void add() {
			 System.out.println("UserService add() ...");
		 }
}
