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
		
		log.info("TransactionTest1() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardMapper.inertBoard(boardVO);
	}
	
	public void TransactionTest2() {
		
		log.info("TransactionTest2() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardVO = null;
		
		boardMapper.inertBoard(boardVO);
	}
	
	@Transactional
	public void TransactionTest3() {
		
		log.info("TransactionTest3() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardVO = null;
		
		boardMapper.inertBoard(boardVO);
	}
	
	@Transactional
	public void TransactionTest4() {
		
		log.info("TransactionTest4() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
		
	}
	
	@Transactional
	public void TransactionTest5() throws SQLException {
		
		log.info("TransactionTest5() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new SQLException("SQLException for rollback");
			
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void TransactionTest6() throws SQLException {
		
		log.info("TransactionTest6() �׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.inertBoard(boardVO);
		
		throw new SQLException("SQLException for rollback");
			
	}
}
