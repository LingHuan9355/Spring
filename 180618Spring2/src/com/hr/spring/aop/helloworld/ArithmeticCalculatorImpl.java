package com.hr.spring.aop.helloworld;

/**
 * 
 * @Name  : AtithmeticCalculator
 * @Author : LH
 * @Date : 2018年6月25日 下午4:19:47
 * @Version : V1.0
 * 
 * @Description : 加减乘除方法
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

			@Override
			public int add(int i, int j) {
					int result = i + j; 
					return result;
			}

			@Override
			public int sub(int i, int j) {
				int result = i - j; 
				return result;
			}

			@Override
			public int mul(int i, int j) {
				int result = i  *  j; 
				return result;
			}

			@Override
			public int div(int i, int j) {
					int result = i  /  j; 
					return result;
			}

}
