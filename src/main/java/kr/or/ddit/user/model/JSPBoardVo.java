package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JSPBoardVo {
	
	private String boardid;
	private String boardname;
	private String boarduse_yn;
	private String userid;
	private Date reg_dt;
	
	
	
	
    public String getreg_dtstr() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if(reg_dt==null){
    		return"";
    		
    	}
    	
		return sdf.format(reg_dt);
	}
	
	
	public String getBoardid() {
		return boardid;
	}



	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}



	public String getBoardname() {
		return boardname;
	}



	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}



	public String getBoarduse_yn() {
		return boarduse_yn;
	}



	public void setBoarduse_yn(String boarduse_yn) {
		this.boarduse_yn = boarduse_yn;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public Date getReg_dt() {
		return reg_dt;
	}



	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}



	@Override
	public String toString() {
		return "JSPBoardVo [boardid=" + boardid + ", boardname=" + boardname
				+ ", boarduse_yn=" + boarduse_yn + ", userid=" + userid
				+ ", reg_dt=" + reg_dt + "]";
	}



	public JSPBoardVo(String boardid,String boardname,String boarduse_yn,String userid) {
		super();
		
		this.boardid = boardid;
		this.boardname = boardname;
		this.boarduse_yn = boarduse_yn;
		this.userid = userid;
		
	}



	public JSPBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}



	

}
