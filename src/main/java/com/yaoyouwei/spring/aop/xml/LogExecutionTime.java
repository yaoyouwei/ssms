package com.yaoyouwei.spring.aop.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/** 
 * @ClassName: ExecutionTimeLog   
 * @Author yaoyouwei
 * @Date 2017年8月21日 下午10:29:39 
 * @Description: 统计执行时间的切面
 */

public class LogExecutionTime {
	
	private static Log logger = LogFactory.getLog(LogExecutionTime.class);
	
	public Object logExecTime(ProceedingJoinPoint jp){
		Object obj = null;
		try {
			long start = System.currentTimeMillis(); 
			obj = jp.proceed();
			long end = System.currentTimeMillis();		
			String executionTime = (end - start) + "ms";		
			if(end - start > 1000){
				executionTime = (end - start) / 1000 + "s";
			}
			logger.info("=============================aop 测试花费时间:"+executionTime);
		} catch (Throwable e) {
			logger.info("=============================aop方法异常");
			e.printStackTrace();
		}
		return obj;
	}

}
