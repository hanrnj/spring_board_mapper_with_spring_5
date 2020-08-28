package edu.bit.board.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.userVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class loginController {
	
	private LoginService loginService;
	
	@GetMapping("/")
	public String home() throws Exception{
		log.info("home()");
		return "login";	
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		log.info("post login");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		userVO login = loginService.loginUser(id, pw);
		 
		if(login == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg",false);
			
		}else if(login.getUsername().equals("member")) {
			
			session.setAttribute("user", login);
			
		} else {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg",false);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value ="/logout")
	public String logout(HttpSession session) throws Exception{
		
		log.info("logout()");
		session.invalidate();
		
		return "redirect:/";	
	}
	
}
