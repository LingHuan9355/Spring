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
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}11:13:24
 * @Version : V1.0
 * 
 * @Description :
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {

					/**
					 * ~{6(ReR;8v7=7(#,SCSZIyCwGPHk5c1m4oJ=#,R;0c5X8C7=7(VPTYR22;PhR*Lm<SFdK{5D4zBk~}
					 * ~{J9SC~} @Pointcut  ~{@4IyCwGPHk5c1m4oJ=!#~}
					 * ~{:sCf5DFdK{M(V*V1=SJ9SC7=7(C{@4R}Hk51G05DGPHk5c1m4oJ=!#~}
					 */
					@Pointcut("execution(public int com.hr.spring.aop.ArithmeticCalculator.*(..))")
					public void declareJointPointExpression() {}
	
	
					/**
					 * ~{TZ~}int com.hr.spring.aop.ArithmeticCalculator  ~{=S?Z5DC?R;8vJ5OV@`5DC?R;8v7=7(?*J<V.G0V4PP5DR;6N4zBk~}
					 */
					@Before("declareJointPointExpression()")
					public void beforeMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						List<Object> args = Arrays.asList(joinPoint.getArgs());
						System.out.println("The method "+ methodName+" begins with" +args);
					}
					
					/**
					 * ~{TZ7=7(V4PPV.:sV4PP5D4zBk#,N^B[7=7(JG7q3vOVRl3#~}
					 * @param joinPoint
					 */
					@After("declareJointPointExpression()")
					public void afterMethod(JoinPoint joinPoint) {
						String methodName = joinPoint.getSignature().getName();
						System.out.println("The method " + methodName + " ends ");
					}
					
					/**
					 * ~{TZ7=7(U}3#=aJxJ\V4PP5D4zBk#,75;XM(V*JG?IRT75;X7=7(5D75;XV5#!~}
					 * @param joinPoint
					 * @param result
					 */
					@AfterReturning(value="declareJointPointExpression()",returning="result")
					public void afterReturning(JoinPoint joinPoint, Object result) {
						  String  methodName = joinPoint.getSignature().getName();
						  System.out.println("The method " +methodName+ " ends withs " +result);
					}

					/**
					 * ~{TZD?1j7=7(3vOVRl3#J1;aV4PP5D4zBk#,?IRT7CNJ5=Rl3#6TOs#;GR?IRTV86(TZ3vOVLX6(Rl3#J1TZV4PPM(V*4zBk~}
					 * @param joinPoint
					 * @param ex
					 */
					@AfterThrowing(value="declareJointPointExpression()",throwing="ex")
					public void afterThrowing(JoinPoint joinPoint,Exception ex) {
						String  methodName = joinPoint.getSignature().getName();
						System.out.println("The method " +methodName+ " occurs excetion: " + ex);
					}
					
					/**
					 * ~{;7HFM(V*PhR*P/4x~} ProceedingJoinPoint ~{2NJ}#,~}
					 * ~{;7HFM(V*@`KFSZ6/L,4z@m5DH+9}3L#:~}ProceedingJoinPoint ~{@`PM5D2NJ}?IRT>v6(JG7qV4PPD?1j7=7(#,~}
					 * ~{GR;7HFM(V*1XPkR*SP75;XV5#,75;XV5<4N*D?1j7=7(5D75;XV5~}
					 * @param pjd
					 */
					/*@Around("declareJointPointExpression()")
					public Object aroundMethod(ProceedingJoinPoint pjd) {
							Object result = null ;
							String methodName = pjd.getSignature().getName();

						    try {
						    		//~{G0VCM(V*~}
						    	System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
						    	//~{V4PPD?1j7=7(~}
						    	 result = pjd.proceed();
						    	// 	~{:sVCM(V*~}
						    	 System.out.println("The method  "+ methodName +" ends with " + result);
							} catch (Throwable e) {
								//~{Rl3#M(V*~}
								System.out.println("The method " + methodName + "occurs exception: " + e);
								throw new RuntimeException(e);
							}
						    
						    //~{:sVCM(V*~}
						    System.out.println("The method " + methodName + " ends ");
							
							
							return result;
					}*/

}
