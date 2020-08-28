package edu.bit.board.service;


import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionService{
	
	private BoardMapper boardMapper;
	
	public void TransactionTest1() {
		
		log.info("TransactionTest1() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("∆Æ∑£¿Ëº«2");
		boardVO.setbName("∆Æ∑£¿Ëº«2");
		boardVO.setbTitle("∆Æ∑£¿Ëº«2");
		
		boardMapper.inertBoard(boardVO);
	}
	
	public void TransactionTest2() {
		
		log.info("TransactionTest2() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("∆Æ∑£¿Ëº«2");
		boardVO.setbName("∆Æ∑£¿Ëº«2");
		boardVO.setbTitle("∆Æ∑£¿Ëº«2");
		
		boardVO = null;
		
		boardMapper.inertBoard(boardVO);
	}
	
	@Transactional
	public void TransactionTest3() {
		
		log.info("TransactionTest3() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("∆Æ∑£¿Ëº«2");
		boardVO.setbName("∆Æ∑£¿Ëº«2");
		boardVO.setbTitle("∆Æ∑£¿Ëº«2");
		
		boardVO = null;
		
		boardMapper.inertBoard(boardVO);
	}
	
	@Transactional
	public void TransactionTest4() {
		
		log.info("TransactionTest4() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
		
	}
	
	@Transactional
	public void TransactionTest5() throws SQLException {
		
		log.info("TransactionTest5() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new SQLException("SQLException for rollback");
			
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void TransactionTest6() throws SQLException {
		
		log.info("TransactionTest6() ≈◊Ω∫∆Æ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("∆Æ∑£¿Ëº«1");
		boardVO.setbName("∆Æ∑£¿Ëº«1");
		boardVO.setbTitle("∆Æ∑£¿Ëº«1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new SQLException("SQLException for rollback");
			
	}
}
