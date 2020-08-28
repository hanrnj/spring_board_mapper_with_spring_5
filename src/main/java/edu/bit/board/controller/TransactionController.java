package edu.bit.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.bit.board.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class TransactionController {
	
	private TransactionService transactionService;	
	
	@GetMapping("/tran/{num}")
	public void transaction(@PathVariable("num") int num) {
		if(num==1) {
			log.info("TransactionTest1 �׽�Ʈ");
			transactionService.TransactionTest1();
		} else if(num==2) {
			log.info("TransactionTest2 �׽�Ʈ");
			transactionService.TransactionTest2();	
			
		} else if(num==3) {
			log.info("TransactionTest3 �׽�Ʈ");
			transactionService.TransactionTest3();	
			
		} else if(num==4) {
			log.info("TransactionTest4 �׽�Ʈ");
			transactionService.TransactionTest4();	
			
		} else if(num==5) {
			log.info("TransactionTest5 �׽�Ʈ");
			try {						
				transactionService.TransactionTest5();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
		} else if(num==6) {
			log.info("TransactionTest6 �׽�Ʈ");
			try {						
				transactionService.TransactionTest6();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
		} 
	}
}
