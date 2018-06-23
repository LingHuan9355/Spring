package com.hr.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * @Name  : MyBeanPostProcessor
 * @Author : LH
 * @Date : 2018年6月20日 上午1:01:09
 * @Version : V1.0
 * 
 * @Description :添加 Bean 后置处理器后 Bean 的生命周期
 * 
 * 
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization: " +bean+", "+beanName);
		
		if("car".equals(beanName)) {
			
		  System.out.println(",,,,");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization: " +bean+", "+beanName);
		Car car = new Car();
		car.setBrand("Ford");
		return car;
	}
}
