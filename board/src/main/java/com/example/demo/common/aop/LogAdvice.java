package com.example.demo.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect
public class LogAdvice {
	 @Pointcut("execution(* com.example..*Impl.*(..))")  //여러개가능
	   public void  allpointcut() {}
	 
	 @Pointcut("execution(* com.example..*Impl.get*(..))") 
	   public void  getpointcut() {}

	@Before("allpointcut()") 
	public void beforeLog(JoinPoint jp) { 
		  //매서드 이름 출력
		  String methodName = jp.getSignature().getName(); 
		  log.info("[before]" + methodName);
		  
		  //파라미터 출력
		  Object[] obj = jp.getArgs();
		  if(obj != null) {
			  log.info("parameter: ");
			  Arrays.asList(obj).forEach(p -> log.info(p.toString()));
		  }
		} 
	
	@AfterReturning(value = "getpointcut()", returning = "result")
	public void after(JoinPoint jp, Object result) {
		  //매서드 이름 출력
		  String methodName = jp.getSignature().getName(); 
		  log.info("[after returning]" + methodName);
		  //서비스 리턴
		  log.info("return:" + result);
	}
	
}
