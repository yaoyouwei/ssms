package com.yaoyouwei.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/** 
 * @ClassName: ExecutionTimeLog   
 * @Author yaoyouwei
 * @Date 2017年8月21日 下午10:29:39 
 * @Description: 统计执行时间的切面
 */

public class LogExecutionTime {

	
	
	public void logExecTime(ProceedingJoinPoint jp){
		try {
			long start = System.currentTimeMillis(); 
			jp.proceed();
			long end = System.currentTimeMillis();		
			String executionTime = (end - start) + "ms";		
			if(end - start > 1000){
				executionTime = (end - start) / 1000 + "s";
			}
			System.out.println("=============================aop 测试花费时间:"+executionTime);
		} catch (Throwable e) {
			System.out.println("=============================aop方法异常");
			e.printStackTrace();
		}
	}

}
