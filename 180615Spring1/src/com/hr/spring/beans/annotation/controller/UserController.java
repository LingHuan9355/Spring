package com.hr.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hr.spring.beans.annotation.service.UserService;

/**
 * 
 * @Name  : UserController
 * @Author : LH
 * @Date : 2018年6月24日 下午6:27:01
 * @Version : V1.0
 * 
 * @Description : 控制层
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
