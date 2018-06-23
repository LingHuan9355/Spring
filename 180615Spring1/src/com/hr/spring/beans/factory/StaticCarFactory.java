package com.hr.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Name  : StaticCarFactory
 * @Author : LH
 * @Date : 2018��6��23�� ����11:54:23
 * @Version : V1.0
 * 
 * @Description : ��̬����������ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է��� Bean ��ʵ��
 */
public class StaticCarFactory {

			private   static Map<String, Car> cars = new HashMap<String,Car>();

			static {
				cars.put("Audi", new Car("Audi",300000));
				cars.put("Ford", new Car("Ford",400000));
			}
			
			//��̬��������
			public static Car getCar(String name) {
				return cars.get(name);
			}
			
			
}
