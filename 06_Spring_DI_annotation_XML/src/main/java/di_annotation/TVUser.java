package di_annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//BeanFactory factory = new BeanFactory();
		//1. 스프링 컨테이너 구동(스프링설정파일 읽어서)
		System.out.println("--- 컨테이너 구동전 ---");
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("--- 컨테이너 구동 후 ---");

		//2. 스프링컨테이너에서 생성한 객체 요청(Lookup)
		TV tv = (TV) factory.getBean("lgTV");
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		System.out.println(tv);
		System.out.println("------------");
		
		//3. 스프링컨테이너 종료(close)
		factory.close();
		System.out.println("--- 컨테이너 종료 ---");
	}

}
