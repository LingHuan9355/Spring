package com.hr.spring.aop.helloworld;

/**
 * 
 * @Name  : AtithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}4:22:34
 * @Version : V1.0
 * 
 * @Description :  ~{PhGs~}1-~{HUV>#:TZ3LPrV4PPFZ<dW7WYU}TZ7"Iz5D;n6/~} ~{#,J5OV<S<u3K3}7=7(~}
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

			@Override
			public int add(int i, int j) {
					System.out.println("ATGUIGU->The method add begins with [" + i + "," + "]");
					
					int result = i + j; 
					System.out.println("ATGUIGU->The method add ends " + result);
					
					return result;
			}

			@Override
			public int sub(int i, int j) {
				System.out.println("ATGUIGU->The method sub begins with [" + i + "," + "]");
				
				int result = i - j; 
				System.out.println("ATGUIGU->The method sub ends " + result);
				
				return result;
			}

			@Override
			public int mul(int i, int j) {
				System.out.println("ATGUIGU->The method mul begins with [" + i + "," + "]");
				
				int result = i  *  j; 
				System.out.println("ATGUIGU->The method mul ends " + result);
				
				return result;
			}

			@Override
			public int div(int i, int j) {
					System.out.println("ATGUIGU->The method div begins with [" + i + "," + "]");
				
					int result = i  /  j; 
					System.out.println("ATGUIGU->The method div ends " + result);
				
				return result;
			}

}
