package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JSPPostVo {
	
	
	
	private String postid;
	private String userid;
	private String posttitle;
	private String postcontent;
	private Date postred_dt;
	private String postid2;
	private String boardid;
	private String lv;
	private String postuse_yn;
	private String group_seq;
	
	
	
	
    public String getGroup_seq() {
		return group_seq;
	}



	public void setGroup_seq(String group_seq) {
		this.group_seq = group_seq;
	}



	public String getPostuse_yn() {
		return postuse_yn;
	}



	public void setPostuse_yn(String postuse_yn) {
		this.postuse_yn = postuse_yn;
	}



	public String getLv() {
		return lv;
	}



	public void setLv(String lv) {
		this.lv = lv;
	}



	public String getpostred_dtstr() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	if(postred_dt==null){
    		return"";
    		
    	}
    	
		return sdf.format(postred_dt);
	}



	public JSPPostVo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public JSPPostVo(String postid,String userid, String posttitle,
			String postcontent, String postid2, String boardid,String group_seq) {
		
		super();
		
		this.postid=postid;
		this.userid = userid;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
		this.postid2 = postid2;
		this.boardid = boardid;
		this.group_seq = group_seq;
	}



	@Override
	public String toString() {
		return "JSPPostVo [postid=" + postid + ", userid=" + userid
				+ ", posttitle=" + posttitle + ", postcontent=" + postcontent
				+ ", postred_dt=" + postred_dt + ", postid2=" + postid2
				+ ", boardid=" + boardid + "]";
	}



	public String getPostid() {
		return postid;
	}



	public void setPostid(String postid) {
		this.postid = postid;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPosttitle() {
		return posttitle;
	}



	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}



	public String getPostcontent() {
		return postcontent;
	}



	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}



	public Date getPostred_dt() {
		return postred_dt;
	}



	public void setPostred_dt(Date postred_dt) {
		this.postred_dt = postred_dt;
	}



	public String getPostid2() {
		return postid2;
	}



	public void setPostid2(String postid2) {
		this.postid2 = postid2;
	}



	public String getBoardid() {
		return boardid;
	}



	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}
	
    
    

}
