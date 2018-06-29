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
 * @Date : 2018年6月26日 上午12:07:07
 * @Version : V1.0
 * 
 * @Description : 使用 @Order 注解指定切面的优先级，值越小优先级越高
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
