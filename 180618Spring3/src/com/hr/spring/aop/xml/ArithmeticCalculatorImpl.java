package com.hr.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : ArithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018��6��26�� ����12:52:35
 * @Version : V1.0
 * 
 * @Description :
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
