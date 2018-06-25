package com.hr.spring.aop.impl;

import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : ArithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018年6月25日 下午9:42:20
 * @Version : V1.0
 * 
 * @Description :
 */

@Component
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
