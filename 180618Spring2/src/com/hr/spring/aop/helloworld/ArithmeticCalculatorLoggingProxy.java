package com.hr.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 
 * @Name  : ArithmeticCalculatorLoggingProxy
 * @Author : LH
 * @Date : 2018~{Dj~}6~{TB~}25~{HU~} ~{OBNg~}4:38:45
 * @Version : V1.0
 * 
 * @Description : ~{J9SC6/L,4z@m=b>v~}
 * ~{4zBk;lBR#:T=@4T=6`5D7GR5NqPhGs~}(~{HUV>:MQiV$5H~})~{<SHk:s~}, ~{T-SP5DR5Nq7=7(<1>gErUM~}. 
 *  ~{C?8v7=7(TZ4&@m:KPDB_<-5DM,J1;91XPk<f9KFdK{6`8v9XW"5c~}. 
 *  ~{4zBk7VI"~}: ~{RTHUV>PhGsN*@}~}, ~{V;JGN*AKBzWcUb8v5%R;PhGs~}, ~{>M2;5C2;TZ6`8vD#?i#(7=7(#)~}
 *  ~{@o6`4NVX84O`M,5DHUV>4zBk~}. ~{Hg9{HUV>PhGs7"Iz1d;/~}, ~{1XPkP^8DKySPD#?i~}.
 *  
 *  
 *  ~{4z@mIh<FD#J=5DT-@m~}: ~{J9SCR;8v4z@m=+6TOs0|W0Fp@4~}, ~{H;:sSC8C4z@m6TOsH!4zT-J<6TOs~}. 
 *  ~{HN:N6TT-J<6TOs5D5wSC6<R*M(9}4z@m~}. ~{4z@m6TOs>v6(JG7qRT<0:NJ1=+7=7(5wSCW*5=T-J<6TOsIO~}.
 */
public class ArithmeticCalculatorLoggingProxy {

	
			//~{R*4z@m5D6TOs~}
			private ArithmeticCalculator target;
			
            
			
			public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
				this.target = target;
			}



			@SuppressWarnings("rawtypes")
			public  ArithmeticCalculator getLoggingProxy() {
				ArithmeticCalculator proxy = null;
				
				//~{4z@m6TOsSIDDR;8v@`<STXFw8:Tp<STX~}
				ClassLoader loader = target.getClass().getClassLoader();
				//~{4z@m6TOs5D@`PM#,<4FdVPSPDGP)7=7(~}
				Class [] interfaces = new Class[] {ArithmeticCalculator.class};
				//~{515wSC4z@m6TOsFdVP5D7=7(J1#,8CV4PP5D4zBk~}
				InvocationHandler invocationHandler = new InvocationHandler() {
					
					/**
					 * proxy : ~{U}TZ75;X5D4z@m6TOs#,R;0cGi?vOB#,TZ~}invoke ~{7=7(VP6<2;J9SC8C6TOs!#;a2zIzK@Q-;7#,DZ4fRg3v~}
					 * method ~{#:U}TZ1;5wSC5D7=7(~}
					 * args~{#:~} ~{5wSC7=7(J1#,4+Hk5D2NJ}~}
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String methodName= method.getName();
						
						//~{HUV>~}
						System.out.println("ATGUIGU->The method " + methodName + " begins  with " + Arrays.asList(args)) ;
						//~{V4PP7=7(~}
						Object result = null; 
						try {
							//~{G0VCM(V*~}
							result =	method.invoke(target, args);
						   //~{75;XM(V*#,?IRT7CNJ5=7=7(5D75;XV5~}
						}catch (Exception e) {
						   e.printStackTrace();
						   //~{Rl3#M(V*#,?IRT7CNJ5=7=7(3vOV5DRl3#~}	
						}
						 //~{:sVCM(V*#,RrN*7=7(?ID\;a3vOVRl3##,KyRT7CNJ2;5=7=7(5D75;XV5~}
						
								//~{HUV>~}
						System.out.println("ATGUIGU->The method " + methodName+ " ends with " + result);
						
						return result;
					}
				};
				
				proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
				return proxy;
			}
}
