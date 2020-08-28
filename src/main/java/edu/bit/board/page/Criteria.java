package edu.bit.board.page;

public class Criteria {
	
	private int pageNum; //페이지 번호
	private int amount; //한페이지당 보여줄 데이터 개수
	
	//한 페이지에 10개의 데이터를 보여줌
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
