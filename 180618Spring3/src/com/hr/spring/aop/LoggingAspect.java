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
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : LoggingAspect
 * @Author : LH
 * @Date : 2018年6月25日 下午11:13:24
 * @Version : V1.0
 * 
 * @Description :
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {

					/**
					 * 定义一个方法，用于声明切入点表达式，一般地该方法中再也不需要添加其他的代码
					 * 使用 @Pointcut  来声明切入点表达式。
					 * 后面的其他通知直接使用方法名来引入当前的切入点表达式。
					 */
					@Pointcut("execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))")
					public void declareJointPointExpression() {}
	
	
					/**
					 * 在int com.hr.spring.aop.ArithmeticCalculator  接口的每一个实现类的每一个方法开始之前执行的一段代码
					 */
					@Before("declareJointPointExpression()")
					public void beforeMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						List<Object> args = Arrays.asList(joinPoint.getArgs());
						System.out.println("The method "+ methodName+" begins with" +args);
					}
					
					/**
					 * 在方法执行之后执行的代码，无论方法是否出现异常
					 * @param joinPoint
					 */
					@After("declareJointPointExpression()")
					public void afterMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						System.out.println("The method " + methodName + " ends ");
					}
					
					/**
					 * 在方法正常结束受执行的代码，返回通知是可以返回方法的返回值！
					 * @param joinPoint
					 * @param result
					 */
					@AfterReturning(value="declareJointPointExpression()",returning="result")
					public void afterReturning(JoinPoint joinPoint, Object result) {
						  String  methodName = joinPoint.getSignature().getName();
						  System.out.println("The method " +methodName+ " ends withs " +result);
					}

					/**
					 * 在目标方法出现异常时会执行的代码，可以访问到异常对象；且可以指定在出现特定异常时在执行通知代码
					 * @param joinPoint
					 * @param ex
					 */
					@AfterThrowing(value="declareJointPointExpression()",throwing="ex")
					public void afterThrowing(JoinPoint joinPoint,Exception ex) {
						String  methodName = joinPoint.getSignature().getName();
						System.out.println("The method " +methodName+ " occurs excetion: " + ex);
					}
					
					/**
					 * 环绕通知需要携带 ProceedingJoinPoint 参数，
					 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法，
					 * 且环绕通知必须要有返回值，返回值即为目标方法的返回值
					 * @param pjd
					 */
					/*@Around("declareJointPointExpression()")
					public Object aroundMethod(ProceedingJoinPoint pjd) {
							Object result = null ;
							String methodName = pjd.getSignature().getName();

						    try {
						    		//前置通知
						    	System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
						    	//执行目标方法
						    	 result = pjd.proceed();
						    	// 	后置通知
						    	 System.out.println("The method  "+ methodName +" ends with " + result);
							} catch (Throwable e) {
								//异常通知
								System.out.println("The method " + methodName + "occurs exception: " + e);
								throw new RuntimeException(e);
							}
						    
						    //后置通知
						    System.out.println("The method " + methodName + " ends ");
							
							
							return result;
					}*/

}
