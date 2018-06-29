package com.hr.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @Name  : CarFactoryBean
 * @Author : LH
 * @Date : 2018年6月24日 上午12:28:50
 * @Version : V1.0
 * 
 * @Description : 实现 FactoryBean 接口在 Spring IOC 容器中配置 Bean
 *     自定义的FactoryBean 需要实现 FactoryBean接口
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
