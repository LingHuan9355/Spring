package com.hr.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Name  : StaticCarFactory
 * @Author : LH
 * @Date : 2018年6月23日 下午11:54:23
 * @Version : V1.0
 * 
 * @Description : 静态工厂方法：直接调用某一个类的静态方法就可以返回 Bean 的实例
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
