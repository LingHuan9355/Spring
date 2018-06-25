package com.hr.spring.aop;

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
 * @Date : 2018��6��26�� ����12:07:07
 * @Version : V1.0
 * 
 * @Description : ʹ�� @Order ע��ָ����������ȼ���ֵԽС���ȼ�Խ��
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {

			@Before("LoggingAspect.declareJointPointExpression())")
			public void validateArgs(JoinPoint joinPoint) {
				System.out.println("-->validate: " + Arrays.asList(joinPoint.getArgs()));
			}	
}
