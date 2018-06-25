package com.hr.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : LoggingAspect
 * @Author : LH
 * @Date : 2018��6��26�� ����12:52:54
 * @Version : V1.0
 * 
 * @Description :
 */
public class LoggingAspect {

					public void beforeMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						List<Object> args = Arrays.asList(joinPoint.getArgs());
						System.out.println("The method "+ methodName+" begins with" +args);
					}
					
					public void afterMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						System.out.println("The method " + methodName + " ends ");
					}
					public void afterReturning(JoinPoint joinPoint, Object result) {
						  String  methodName = joinPoint.getSignature().getName();
						  System.out.println("The method " +methodName+ " ends withs " +result);
					}

					public void afterThrowing(JoinPoint joinPoint,Exception ex) {
						String  methodName = joinPoint.getSignature().getName();
						System.out.println("The method " +methodName+ " occurs excetion: " + ex);
					}
					
					public Object aroundMethod(ProceedingJoinPoint pjd) {
							Object result = null ;
							String methodName = pjd.getSignature().getName();

						    try {
						    		//ǰ��֪ͨ
						    	System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
						    	//ִ��Ŀ�귽��
						    	 result = pjd.proceed();
						    	// 	����֪ͨ
						    	 System.out.println("The method  "+ methodName +" ends with " + result);
							} catch (Throwable e) {
								//�쳣֪ͨ
								System.out.println("The method " + methodName + "occurs exception: " + e);
								throw new RuntimeException(e);
							}
						    
						    //����֪ͨ
						    System.out.println("The method " + methodName + " ends ");
							
							
							return result;
					}

}
