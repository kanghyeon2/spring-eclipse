package com.example.demo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
//@Aspect
public class AroundAdvice {

	@Around("LogAdvice.allpointcut()")
	public Object logTime(ProceedingJoinPoint pjp) {
		//서비스메서드 실행 전
		long start = System.currentTimeMillis();
		Object obj = null;
		
		//서비스 메서드 호출
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//서비스메서드 실행 후
		long end = System.currentTimeMillis();
		log.info("TIME: " + (end-start));
		
		return obj;
	}
}
