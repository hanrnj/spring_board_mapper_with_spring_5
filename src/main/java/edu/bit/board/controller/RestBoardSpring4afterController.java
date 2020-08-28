package edu.bit.board.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//스프링 4.0 이전 버전(@Controller + @ResponseBody)
@Controller
@Log4j
@AllArgsConstructor
public class RestBoardSpring4afterController {
	
	private BoardService boardService;
	
	@ResponseBody
	@RequestMapping("/restful/before")
	public List<BoardVO> before(){
		log.info("/restful/before");
		List<BoardVO> list = boardService.getList();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
	public int restDelete(@PathVariable("bId") int bId) {
		log.info("restDelete");
		return boardService.remove(bId);			
	}

}
