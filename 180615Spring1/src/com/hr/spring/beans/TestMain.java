package com.hr.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
		
				 @Test
				 public void testSpring() {
				   //����HelloWorld��һ������
				  // HelloWorld heWorld = new HelloWorld();
				   //Ϊname�����Ը�ֵ
				   //heWorld.setName("Carl");
				   //����hello�ķ���
				   //heWorld.hello();
				   
				   //1.����Spring �� IOC ��������
				   @SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				   
				   //2.��IOC �����л�ȡBeanʵ��
			      HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
				   
				   //3.����hello�ķ���
			    //  helloWorld.hello();
				 }
}
