package com.hr.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 
 * @Name  : ArithmeticCalculatorLoggingProxy
 * @Author : LH
 * @Date : 2018年6月25日 下午4:38:45
 * @Version : V1.0
 * 
 * @Description : 使用动态代理解决
 * 代码混乱：越来越多的非业务需求(日志和验证等)加入后, 原有的业务方法急剧膨胀. 
 *  每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点. 
 *  代码分散: 以日志需求为例, 只是为了满足这个单一需求, 就不得不在多个模块（方法）
 *  里多次重复相同的日志代码. 如果日志需求发生变化, 必须修改所有模块.
 *  
 *  
 *  代理设计模式的原理: 使用一个代理将对象包装起来, 然后用该代理对象取代原始对象. 
 *  任何对原始对象的调用都要通过代理. 代理对象决定是否以及何时将方法调用转到原始对象上.
 */
public class ArithmeticCalculatorLoggingProxy {

	
			//Ҫ����Ķ���
			private ArithmeticCalculator target;
			
            
			
			public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
				this.target = target;
			}



			@SuppressWarnings("rawtypes")
			public  ArithmeticCalculator getLoggingProxy() {
				ArithmeticCalculator proxy = null;
				
				//�����������һ����������������
				ClassLoader loader = target.getClass().getClassLoader();
				//�����������ͣ�����������Щ����
				Class [] interfaces = new Class[] {ArithmeticCalculator.class};
				//�����ô���������еķ���ʱ����ִ�еĴ���
				InvocationHandler invocationHandler = new InvocationHandler() {
					
					/**
					 * proxy : ���ڷ��صĴ������һ������£���invoke �����ж���ʹ�øö��󡣻������ѭ�����ڴ����
					 * method �����ڱ����õķ���
					 * args�� ���÷���ʱ������Ĳ���
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String methodName= method.getName();
						
						//��־
						System.out.println("ATGUIGU->The method " + methodName + " begins  with " + Arrays.asList(args)) ;
						//ִ�з���
						Object result = null; 
						try {
							//ǰ��֪ͨ
							result =	method.invoke(target, args);
						   //����֪ͨ�����Է��ʵ������ķ���ֵ
						}catch (Exception e) {
						   e.printStackTrace();
						   //�쳣֪ͨ�����Է��ʵ��������ֵ��쳣	
						}
						 //����֪ͨ����Ϊ�������ܻ�����쳣�����Է��ʲ��������ķ���ֵ
						
								//��־
						System.out.println("ATGUIGU->The method " + methodName+ " ends with " + result);
						
						return result;
					}
				};
				
				proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
				return proxy;
			}
}
