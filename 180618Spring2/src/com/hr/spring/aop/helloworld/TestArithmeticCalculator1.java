package com.hr.spring.aop.helloworld;


import org.junit.Test;

/**
 * 
 * @Name  : TestArithmeticCalculator1
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}4:30:11
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestArithmeticCalculator1 {

	
	
			@Test
			public void test() {
				
				/*ArithmeticCalculator arithmeticCalculator = null;
				arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();*/
				
				ArithmeticCalculator target = new ArithmeticCalculatorImpl();
				ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
				
				//~{4z@m6TOs~}
				System.out.println(proxy.getClass().getName());
				
				int result =  proxy.add(1, 2);
			    System.out.println("-->" + result);
			    
			    result = proxy.div(4, 2);
			    System.out.println("-->" + result);
		
			    
			    
			}

}
