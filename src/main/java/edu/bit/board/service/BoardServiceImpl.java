package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList.........");
		
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bno) {
		log.info("get.........");
		
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		log.info("remove.........");
		
		return mapper.delete(bno);	
		
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("writeBoard.........");
		
		mapper.inertBoard(boardVO);
	}

	@Override
	public void modifyBoard(BoardVO boardVO) {
		log.info("modifyBoard.........");
		
		mapper.modify(boardVO);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void replyBoard(BoardVO boardVO) {
		log.info("replyBoard.........");
		mapper.updateShape(boardVO);
		mapper.inertReply(boardVO);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("get List with criteria"  + criteria);
		return mapper.getListWithPaging(criteria);
	}
}
