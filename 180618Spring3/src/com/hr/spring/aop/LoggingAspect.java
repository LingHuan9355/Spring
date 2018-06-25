package com.hr.spring.aop;

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
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : LoggingAspect
 * @Author : LH
 * @Date : 2018��6��25�� ����11:13:24
 * @Version : V1.0
 * 
 * @Description :
 */
@Aspect
@Component
public class LoggingAspect {

					/**
					 * ��int com.hr.spring.aop.ArithmeticCalculator  �ӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ�е�һ�δ���
					 */
					@Before("execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))")
					public void beforeMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						List<Object> args = Arrays.asList(joinPoint.getArgs());
						System.out.println("The method "+ methodName+" begins with" +args);
					}
					
					/**
					 * �ڷ���ִ��֮��ִ�еĴ��룬���۷����Ƿ�����쳣
					 * @param joinPoint
					 */
					@After("execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))")
					public void afterMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						System.out.println("The method " + methodName + " ends ");
					}
					
					/**
					 * �ڷ�������������ִ�еĴ��룬����֪ͨ�ǿ��Է��ط����ķ���ֵ��
					 * @param joinPoint
					 * @param result
					 */
					@AfterReturning(value="execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))",returning="result")
					public void afterReturning(JoinPoint joinPoint, Object result) {
						  String  methodName = joinPoint.getSignature().getName();
						  System.out.println("The method " +methodName+ " ends withs " +result);
					}

					/**
					 * ��Ŀ�귽�������쳣ʱ��ִ�еĴ��룬���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
					 * @param joinPoint
					 * @param ex
					 */
					@AfterThrowing(value="execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))",throwing="ex")
					public void afterThrowing(JoinPoint joinPoint,Exception ex) {
						String  methodName = joinPoint.getSignature().getName();
						System.out.println("The method " +methodName+ " occurs excetion: " + ex);
					}
					
					/**
					 * ����֪ͨ��ҪЯ�� ProceedingJoinPoint ������
					 * ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽����
					 * �һ���֪ͨ����Ҫ�з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
					 * @param pjd
					 */
					/*@Around("execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))")
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
					}*/

}
