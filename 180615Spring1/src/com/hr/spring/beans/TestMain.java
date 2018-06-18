package com.hr.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
		
				 @Test
				 public void testSpring() {
				   //创建HelloWorld的一个对象
				  // HelloWorld heWorld = new HelloWorld();
				   //为name的属性赋值
				   //heWorld.setName("Carl");
				   //调用hello的方法
				   //heWorld.hello();
				   
				   //1.创建Spring 的 IOC 容器对象
					 //ApplicationContext 代表IOC 容器
					 //ClassPathXmlApplicationContext :是ApplicationContext 接口的实现类，该实现类从类路径下来加载配置文件。
				   ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				   
				   //2.从IOC 容器中获取Bean实例
				   //利用id 定位到IOC容器中的bean
			      HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld2");
				  //利用类型返回 IOC 容器中的Bean ，但要求IOC容器中只能有一个该类型的Bean
			      //HelloWorld helloWorld =  context.getBean(HelloWorld.class);
			      System.out.println(helloWorld);
				   
				   //3.调用hello的方法
			    //  helloWorld.hello();
			      
			      Car car = (Car) context.getBean("car");
			      System.out.println(car);
	
			      car  = (Car) context.getBean("car2");
			      System.out.println(car);
				 }
}
