package com.hr.spring.beans.annotation;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.annotation.controller.UserController;
import com.hr.spring.beans.annotation.repository.UserRepository;
import com.hr.spring.beans.annotation.service.UserService;


/**
 * 
 * @Name  : TestAnnotation11
 * @Author : LH
 * @Date : 2018年6月24日 下午6:36:32
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestAnnotation11 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
					ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
					
				/*	TestObject testObject = (TestObject) context.getBean("testObject");
					System.out.println(testObject);
					
					
					UserService userService = (UserService) context.getBean("userService");
					System.out.println(userService);
					
					UserRepository userRepository = (UserRepository) context.getBean("userRepository");
					System.out.println(userRepository);*/
					
					UserController userController = (UserController) context.getBean("userController");
					System.out.println(userController);
					userController.execute();
		        	
		        	
			}

}
