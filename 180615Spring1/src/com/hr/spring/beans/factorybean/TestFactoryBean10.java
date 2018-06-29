package com.hr.spring.beans.factorybean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * 
 * @Name  : TestFactoryBean9
 * @Author : LH
 * @Date : 2018年6月24日 上午12:35:11
 * @Version : V1.0
 * 
 * @Description :实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean
 * 
 * Bean 的配置方式：
 *  1.通过全类名（反射）、
 *  2.通过工厂方法（静态工厂方法 & 实例工厂方法）、
 *  3.FactoryBean
 */
public class TestFactoryBean10 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-factorybean.xml");

		        	Car car = (Car) context.getBean("car");
		        	System.out.println(car);
		        	
		        	
		        	
			}

}
