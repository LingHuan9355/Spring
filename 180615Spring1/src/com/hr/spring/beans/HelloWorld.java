package com.hr.spring.beans;

/**
 * 
 * @Name  : HelloWorld
 * @Author : LH
 * @Date : 2018��6��15�� ����4:33:57
 * @Version : V1.0
 * 
 * @Description :
 */
public class HelloWorld {

		private String name;

		
		
		public HelloWorld() {
          System.out.println("HelloWorld's Constructor...");
		}

		public void setName2(String name) {
			System.out.println("setName: " +name);
			this.name = name;
		}
		
		public void hello() {
			System.out.println("Hello  : " + name);
		}
		
		
}
