package com.hr.spring.aop.helloworld;

/**
 * 
 * @Name  : AtithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018年6月25日 下午4:22:34
 * @Version : V1.0
 * 
 * @Description :  需求1-日志：在程序执行期间追踪正在发生的活动 ，实现加减乘除方法
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
