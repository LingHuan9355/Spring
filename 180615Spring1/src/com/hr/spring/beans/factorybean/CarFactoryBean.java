package com.hr.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @Name  : CarFactoryBean
 * @Author : LH
 * @Date : 2018��6��24�� ����12:28:50
 * @Version : V1.0
 * 
 * @Description : ʵ�� FactoryBean �ӿ��� Spring IOC ���������� Bean
 *     �Զ����FactoryBean ��Ҫʵ�� FactoryBean�ӿ�
 */
public class CarFactoryBean  implements FactoryBean<Car>{

	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * ���� bean �Ķ���
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car(brand,500000);
	}

	/**
	 * ���� bean ������
	 */
	@Override
	public Class<?> getObjectType() {
		return null;
	}

	/**
	 * FactoryBean ���ص�ʵ���Ƿ�Ϊ����
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

}
