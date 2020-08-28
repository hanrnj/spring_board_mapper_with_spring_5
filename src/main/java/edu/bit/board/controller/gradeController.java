package edu.bit.board.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.bit.board.vo.gradeVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class gradeController {
	
	@RequestMapping("/restful/inputGrade")
	public int inputGrade(gradeVO gradevo){
		log.info("/restful/inputGrade");
		
		int list = gradevo.gradeSum(gradevo.getKor(), gradevo.getEng(), gradevo.getMath());
		
		return list;
	
	}
}
