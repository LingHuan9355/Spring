package com.hr.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : LoggingAspect
 * @Author : LH
 * @Date : 2018��6��25�� ����9:52:11
 * @Version : V1.0
 * 
 * @Description :  ��־����
 * 1.�����������Ϊһ�����棺��Ҫ�Ѹ���ŵ�IOC�����У�������Ϊһ������
 */

@Aspect
@Component
public class LoggingAspect {

			//�����ķ�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
			@Before("execution(public int com.hr.spring.aop.impl.ArithmeticCalculatorImpl.*(int , int ))")
			public void  beforeMethod(JoinPoint joinPoint) {
				String methodName = joinPoint.getSignature().getName();
				List<Object> args = Arrays.asList(joinPoint.getArgs());
				System.out.println("The method " + methodName + " begins with " + args );
			}
		
}
