package com.yaoyouwei.spring.aop.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: ExecutionTimeLog   
 * @Author yaoyouwei
 * @Date 2017年8月21日 下午10:29:39 
 * @Description: 统计执行时间的切面
 * 使用注解,可以在JavaConfig中使用@EnableAspectJAutoProxy启用AspectJ自动代理
 * 在xml配置中使用<aop:aspectj-autoproxy/>标签启用AspectJ自动代理
 */
@Component("logExecutionTimeAnnotation")
@Aspect
public class LogExecutionTime {
	
	private static Log logger = LogFactory.getLog(LogExecutionTime.class);
	
	@Pointcut("execution(* com.yaoyouwei.service.impl.UserServiceImpl.queryUserByLoginId(..))")
	public void log(){}
	
	@Around("log()")
	public Object logExecTime(ProceedingJoinPoint jp){
		Object user = null;
		try {
			long start = System.currentTimeMillis(); 
			user = jp.proceed();
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
		return user;
	}

}
