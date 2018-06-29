package com.hr.spring.beans.scope;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.autowire.Car;

/**
 * 
 * @Name  : TestScope5
 * @Author : LH
 * @Date : 2018年6月19日 下午10:53:45
 * @Version : V1.0
 * 
 * @Description :bean 的作用域：singleton；prototype；WEB 环境作用域
 * 					使用bean 的 scope 属性来配置 bean的作用域
 *					singleton：默认值，容器初始时创建bean的实例，在整个生命周期里只创建这一个bean。单例的。
 *					prototype: 原型的，容器初始时不创建bean的实例，而在每次请求是创建一个新的bean的实例，并返回。
 */
public class TestScope5 {

			@SuppressWarnings("resource")
			@Test
			public void test() {
		        	ApplicationContext context = new  ClassPathXmlApplicationContext("beans-scope.xml");

		        	Car car = (Car) context.getBean("car");
		        	Car car2 = (Car) context.getBean("car");
		        	System.out.println(car == car2);
			}

}
