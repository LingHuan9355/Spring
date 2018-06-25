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
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}9:52:11
 * @Version : V1.0
 * 
 * @Description :  ~{HUV>GPCf~}
 * 1.~{0QUb8v@`IyCwN*R;8vGPCf#:PhR*0Q8D@`7E5=~}IOC~{H]FwVP#,TYIyCwN*R;8vGPCf~}
 */

@Aspect
@Component
public class LoggingAspect {

			//~{IyCw8D7=7(JGR;8vG0VCM(V*#:TZD?1j7=7(?*J<V.G0V4PP~}
			@Before("execution(* com.hr.spring.aop.impl.*.*(int , int ))")
			public void  beforeMethod(JoinPoint joinPoint) {
				String methodName = joinPoint.getSignature().getName();
				List<Object> args = Arrays.asList(joinPoint.getArgs());
				System.out.println("The method " + methodName + " begins with " + args );
			}
			
			//~{:sVCM(V*#:~}, ~{TZD?1j7=7(V4PPV.:s#(N^B[JG7q7"IzRl3##)#,V4PP5DM(V*~}
			//~{:sVCM(V*VP;92;D\7CNJD?1j7=7(V4PP5D=a9{!#~}
		   @After("execution(* com.hr.spring.aop.impl.*.*(int , int ))")
			public void afterMethod(JoinPoint joinPoint) {
			   String methodName = joinPoint.getSignature().getName();
			   System.out.println("The method " + methodName + " ends " );
			   
		   }
}
