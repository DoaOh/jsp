package kr.or.ddit.paging.model;

public class BPageVo {
	
	
	public BPageVo(int page, int pageSize,String boardid) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.boardid = boardid;
	}


	public BPageVo() {
	
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	private int page;  //페이지 번호 
	private int pageSize;  //페이지당 건수
	private String boardid;  //페이지당 건수
	public String getBoardid() {
		return boardid;
	}


	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

}
