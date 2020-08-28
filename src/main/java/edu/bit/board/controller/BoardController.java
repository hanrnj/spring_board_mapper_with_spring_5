package edu.bit.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class BoardController{
	
	private BoardService service;
	
	@GetMapping("/jqueryList")
	public void jqueryList(Model model) {
		log.info("jqueryList()");
		model.addAttribute("jqueryList", service.getList());
	}
	
	 @GetMapping("/list3")
	 public void list3(Criteria cri, Model model) {	
		 log.info("list3");
		 log.info(cri);
		 model.addAttribute("list", service.getList(cri));	
		 
		 int total = service.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageDTO(cri,total));	
	 }
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list()");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view()");
		model.addAttribute("content_view", service.get(boardVO.getbId()));
		return "content_view";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete()");
		service.remove(boardVO.getbId());
		return "redirect:list";	
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("write_view()");
		return "write_view";	
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) throws Exception{
		log.info("write()");
		service.writeBoard(boardVO);
		return "redirect:list";	
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) throws Exception{
		log.info("modify()");
		service.modifyBoard(boardVO);
		return "redirect:list";	
	}
	
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) throws Exception{
		log.info("reply_view()");
		model.addAttribute("reply_view", service.get(boardVO.getbId()));
		return "reply_view";	
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) throws Exception{
		log.info("reply()");
		service.replyBoard(boardVO);
		return "redirect:list";	
	}
	
	@RequestMapping("/ajaxList")
	public String ajaxList() {
		log.info("ajaxList()");
		return "ajaxList";
	}
	
	@RequestMapping("/ajax/inputGrade")
	public String inputGrade() {
		log.info("inputGrade()");
		return "inputGrade";
	}
	
	@RequestMapping("/area")
	public String area() {
		log.info("area()");
		return "area";
	}	
}
