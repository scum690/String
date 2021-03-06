package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체 생성
@Aspect //포인트컷 + 어드바이스
public class BeforeAdvice {
	
	//포인트 컷 설정 : 명칭은 메소드명을 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	//어드바이스에 동작시점 설정 + 적용할 포인트컷 지정
	@Before("getPointcut()")
	public void beforeLog(JoinPoint jp) {//어드바이스 메소드
		String methodName = jp.getSignature().getName(); //실행될 메소드명
		Object[] args = jp.getArgs(); //메소드에 전달된 값. 매개변수(인자-argument, 파라미터-parameter)
		
		System.out.println("[사전처리] " + methodName + "() 메소드"
				+ ", args정보: " + args[0].toString());
		
	}
}
