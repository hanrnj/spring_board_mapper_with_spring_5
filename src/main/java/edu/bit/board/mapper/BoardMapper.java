package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	public abstract List<BoardVO> getList();
	
	public abstract BoardVO read(int bno);
	
	@Delete("Delete from mvc_board where bId = #{bno}")
	public abstract int delete(int bno);

	public abstract void inertBoard(BoardVO boardVO);

	public abstract void modify(BoardVO boardVO);

	public abstract void updateShape(@Param("boardVO")BoardVO boardVO);
	
	public abstract void inertReply(BoardVO boardVO);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	
}
