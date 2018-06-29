package com.hr.spring.aop;

import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : ArithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018年6月25日 下午10:59:27
 * @Version : V1.0
 * 
 * @Description :
 */
@Component("arithmeticCalculator")
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
