package com.dtech.boot.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogTimeAspect {

	@Around("@annotation(com.dtech.boot.web.aspect.LogTime)")
	public Object logTime(ProceedingJoinPoint jp) throws Throwable {
		
		StopWatch watch = new StopWatch();
		
		watch.start();
		
		Object object = jp.proceed();
		
		watch.stop();
		
		System.out.println("Time taken to execute method : [" + watch.getTotalTimeMillis() + "] ms");
		
		return object;
	}
	
}
