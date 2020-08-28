package edu.bit.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import edu.bit.board.vo.userVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		log.info("preHandle 실행");
		
		HttpSession session = request.getSession();
		userVO user = (userVO)session.getAttribute("user");
		
		if(user == null) {
			log.info("user가 null");
			response.sendRedirect(request.getContextPath());	
			return false;
		}
			
		return true;	
		
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception{
		
		super.postHandle(request, response, handler, modelAndView);
			log.info("postHandle 실행");
			
	}
}
