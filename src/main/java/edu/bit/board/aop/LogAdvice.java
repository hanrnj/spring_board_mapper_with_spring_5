package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*Aspect : �������� ����ִ� Ŭ����
  Advice : Aspect Ŭ���� �ȿ� ��� �ִ� ���� ���(�Ѹ���� Aspect ���� �Լ�)
  JoinPoint : Advice �Լ��� ����Ǵ� �Լ�
  PointCut : JoinPoint�� �κ����� ������ ����Ǵ� �Լ����� ����(@Before,@After,@Around)
  weaving : Advice�� �����ϴ� ����
  */
@Aspect
@Component
public class LogAdvice {
	
	@Before("within(edu.bit.board..*)")
	public void printLogging() {
		System.out.println("������ - ����Ʈ �α�");
	}
}
