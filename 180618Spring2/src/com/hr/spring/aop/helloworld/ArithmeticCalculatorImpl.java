package com.hr.spring.aop.helloworld;

/**
 * 
 * @Name  : AtithmeticCalculatorImpl
 * @Author : LH
 * @Date : 2018��6��25�� ����4:22:34
 * @Version : V1.0
 * 
 * @Description :  ʵ�ּӼ��˳�����
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