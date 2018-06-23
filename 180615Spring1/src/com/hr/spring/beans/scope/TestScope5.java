package com.hr.spring.beans.scope;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hr.spring.beans.autowire.Car;



/**
 * 
 * @Name  : TestScope5
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}19~{HU~} ~{OBNg~}10:53:45
 * @Version : V1.0
 * 
 * @Description :bean ~{5DWwSCSr#:~}singleton~{#;~}prototype~{#;~}WEB ~{;7>3WwSCSr~}
 * 					~{J9SC~}bean ~{5D~} scope ~{JtPT@4EdVC~} bean~{5DWwSCSr~}
 *					singleton~{#:D,HOV5#,H]Fw3uJ<J144=(~}bean~{5DJ5@}#,TZU{8vIzC|V\FZ@oV;44=(UbR;8v~}bean~{!#5%@}5D!#~}
 *					prototype: ~{T-PM5D#,H]Fw3uJ<J12;44=(~}bean~{5DJ5@}#,6xTZC?4NGkGsJG44=(R;8vPB5D~}bean~{5DJ5@}#,2"75;X!#~}
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
