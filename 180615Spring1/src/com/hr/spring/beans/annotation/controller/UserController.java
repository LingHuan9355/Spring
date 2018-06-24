package com.hr.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hr.spring.beans.annotation.service.UserService;

/**
 * 
 * @Name  : UserController
 * @Author : LH
 * @Date : 2018��6��24�� ����6:27:01
 * @Version : V1.0
 * 
 * @Description : ���Ʋ�
 */

@Controller
public class UserController {

		@Autowired
		private UserService userService;
	
		public  void execute() {
			System.out.println("UserController execute() ...");
				userService.add();
		}
}
