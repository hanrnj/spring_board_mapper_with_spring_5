package edu.bit.board.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.vo.areaVO;
import edu.bit.board.vo.gradeVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class areaController {
	
	@RequestMapping("/restful/area")
	public int area(areaVO areavo){
		log.info("/restful/area");
		
		int list = areavo.getArea(areavo.getHeight(), areavo.getWidth());
		
		return list;
	
	}
}
