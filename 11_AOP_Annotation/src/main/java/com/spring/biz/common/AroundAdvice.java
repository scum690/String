package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

	//포인트 컷 설정 : 명칭은 메소드명을 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}	
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch(); 
		stopWatch.start();
		
		System.out.println("[Around BEFORE] 비즈니스 메소드 실행전 처리작업");
		Object returnObj = pjp.proceed(); //실행할 메소드 동작 시키기
		System.out.println("[Around AFTER] 비즈니스 메소드 실행후 처리작업");
				
		stopWatch.stop();
		System.out.println("[around] " + methodName + "()메소드"
				+ ", 실행시간: " + stopWatch.getTotalTimeMillis() + "초(ms)");
		
		return returnObj;
	}
}
