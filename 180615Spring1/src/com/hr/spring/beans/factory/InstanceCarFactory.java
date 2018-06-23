package com.hr.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Name  : InstanceCarFactory
 * @Author : LH
 * @Date : 2018��6��24�� ����12:22:42
 * @Version : V1.0
 * 
 * @Description :ʵ������������ʵ�������ķ���������Ҫ�������������ٵ��ù�����ʵ������������bean��ʵ��
 */
public class InstanceCarFactory {

			private   Map<String, Car> cars = null;

			public InstanceCarFactory (){
				cars = new HashMap<String, Car>();
				cars.put("����", new Car("����",3000000));
				cars.put("����", new Car("����",4000000));
			}
			
			//ʵ����������
			public  Car getCar(String brand) {
				return cars.get(brand);
			}
			
			
}
