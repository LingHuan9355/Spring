package com.hr.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @Name  : LoggingAspect
 * @Author : LH
 * @Date : 2018年6月25日 下午9:52:11
 * @Version : V1.0
 * 
 * @Description :  日志切面
 * 1.把这个类声明为一个切面：需要把改类放到IOC容器中，再声明为一个切面
 */

@Aspect
@Component
public class LoggingAspect {

			//声明改方法是一个前置通知：在目标方法开始之前执行
			@Before("execution(* com.hr.spring.aop.impl.*.*(int , int ))")
			public void  beforeMethod(JoinPoint joinPoint) {
				String methodName = joinPoint.getSignature().getName();
				List<Object> args = Arrays.asList(joinPoint.getArgs());
				System.out.println("The method " + methodName + " begins with " + args );
			}
			
			//后置通知：, 在目标方法执行之后（无论是否发生异常），执行的通知
			//后置通知中还不能访问目标方法执行的结果。
		   @After("execution(* com.hr.spring.aop.impl.*.*(int , int ))")
			public void afterMethod(JoinPoint joinPoint) {
			   String methodName = joinPoint.getSignature().getName();
			   System.out.println("The method " + methodName + " ends " );
			   
		   }
}
