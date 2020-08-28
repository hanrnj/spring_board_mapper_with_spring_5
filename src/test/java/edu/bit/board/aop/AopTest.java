package edu.bit.board.aop;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.board.service.BoardService;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/aop-context.xml" })
@Log4j
public class AopTest {

	@Inject
	private BoardService service;
	
	@Test
	public void testServiceAop() {
		log.info("리스트 시작");
		log.info(service.getList());
		log.info("리스트 끝");
	}
	
}
