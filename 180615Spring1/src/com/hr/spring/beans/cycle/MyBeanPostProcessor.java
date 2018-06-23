package com.hr.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * @Name  : MyBeanPostProcessor
 * @Author : LH
 * @Date : 2018��6��20�� ����1:01:09
 * @Version : V1.0
 * 
 * @Description :��� Bean ���ô������� Bean ����������
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
