package com.hr.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @Name  : TestMain
 * @Author : LH
 * @Date : 2018��6��18�� ����5:27:09
 * @Version : V1.0
 * 
 * @Description :
 */
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
					 //ApplicationContext ����IOC ����
					 //ClassPathXmlApplicationContext :��ApplicationContext �ӿڵ�ʵ���࣬��ʵ�������·���������������ļ���
				   ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				   
				   //2.��IOC �����л�ȡBeanʵ��
				   //����id ��λ��IOC�����е�bean
			      HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");
				  //�������ͷ��� IOC �����е�Bean ����Ҫ��IOC������ֻ����һ�������͵�Bean
			      //HelloWorld helloWorld =  context.getBean(HelloWorld.class);
			      System.out.println(helloWorld);
				   
				   //3.����hello�ķ���
			    //  helloWorld.hello();
			      
			      Car car = (Car) context.getBean("car");
			      System.out.println(car);
	
			      car  = (Car) context.getBean("car2");
			      System.out.println(car);
			      
			      Person person = (Person) context.getBean("person");
			      System.out.println(person);
			      
				 }
}
