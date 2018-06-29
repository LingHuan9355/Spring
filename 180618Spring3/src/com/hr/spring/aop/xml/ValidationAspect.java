package com.hr.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * 
 * @Name  : ValidationAspect
 * @Author : LH
 * @Date : 2018年6月26日 上午12:53:02
 * @Version : V1.0
 * 
 * @Description :
 */
public class ValidationAspect {

			public void validateArgs(JoinPoint joinPoint) {
				System.out.println("-->validate: " + Arrays.asList(joinPoint.getArgs()));
			}	
}
