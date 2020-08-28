package edu.bit.board.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//스프링 4.0 이후 버전(@Controller + @RestController)
@RestController //(@Controller + @ResponseBody)
@Log4j
@AllArgsConstructor
public class RestBoardSpring4BeforeController {
	
	private BoardService boardService;
	
	@RequestMapping("/restful/after")
	public List<BoardVO> after(){
		log.info("/restful/after");
		List<BoardVO> list = boardService.getList();
		
		return list;
				
	}	
}
