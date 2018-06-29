package com.hr.spring.beans.factory;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *  
 * @Name  : TestFactory9
 * @Author : LH
 * @Date : 2018年6月24日 上午12:06:21
 * @Version : V1.0
 * 
 * @Description :通过调用静态工厂方法创建 Bean
 * 
 * 调用静态工厂方法创建 Bean是将对象创建的过程封装到静态方法中. 
 * 当客户端需要对象时, 只需要简单地调用静态方法, 而不同关心创建对象的细节.
 *
 * Bean 的配置方式：
 *  1.通过全类名（反射）、
 *  2.通过工厂方法（静态工厂方法 & 实例工厂方法）、
 *  3.FactoryBean
 *  
 */
public class TestFactory9 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-factory.xml");

		        	Car car1 = (Car) context.getBean("car1");
		        	System.out.println(car1);
		        	
		        	Car car2 = (Car) context.getBean("car2");
		        	System.out.println(car2);
		        	
		        	
			}

}
