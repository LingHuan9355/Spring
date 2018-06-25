package com.hr.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : ValidationAspect
 * @Author : LH
 * @Date : 2018��6��26�� ����12:53:02
 * @Version : V1.0
 * 
 * @Description :
 */
public class ValidationAspect {

			public void validateArgs(JoinPoint joinPoint) {
				System.out.println("-->validate: " + Arrays.asList(joinPoint.getArgs()));
			}	
}
