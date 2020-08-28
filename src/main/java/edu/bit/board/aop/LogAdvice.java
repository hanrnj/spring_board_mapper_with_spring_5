package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*Aspect : 공통기능이 들어있는 클래스
  Advice : Aspect 클래스 안에 들어 있는 공통 기능(한마디로 Aspect 안의 함수)
  JoinPoint : Advice 함수가 적용되는 함수
  PointCut : JoinPoint의 부분으로 실제로 적용되는 함수내의 지점(@Before,@After,@Around)
  weaving : Advice를 적용하는 행위
  */
@Aspect
@Component
public class LogAdvice {
	
	@Before("within(edu.bit.board..*)")
	public void printLogging() {
		System.out.println("공통기능 - 프린트 로그");
	}
}
