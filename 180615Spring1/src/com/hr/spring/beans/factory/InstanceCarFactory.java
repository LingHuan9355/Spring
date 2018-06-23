package com.hr.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Name  : InstanceCarFactory
 * @Author : LH
 * @Date : 2018年6月24日 上午12:22:42
 * @Version : V1.0
 * 
 * @Description :实例工厂方法：实例工厂的方法，即需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 */
public class InstanceCarFactory {

			private   Map<String, Car> cars = null;

			public InstanceCarFactory (){
				cars = new HashMap<String, Car>();
				cars.put("宝马", new Car("宝马",3000000));
				cars.put("奔驰", new Car("奔驰",4000000));
			}
			
			//实例工厂方法
			public  Car getCar(String brand) {
				return cars.get(brand);
			}
			
			
}
