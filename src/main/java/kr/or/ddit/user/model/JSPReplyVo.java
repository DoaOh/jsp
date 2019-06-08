package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class JSPReplyVo {
	
	
	
	private String replycode;
	private String postid;
	private String reply;
	private Date replyred_dt;
	private String userid;
	private String reply_yn;
	
	
	
	  public String getReply_yn() {
		return reply_yn;
	}



	public void setReply_yn(String reply_yn) {
		this.reply_yn = reply_yn;
	}



	public String getreplyred_dtstr() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if(replyred_dt==null){
	    		return"";
	    		
	    	}
	    	
			return sdf.format(replyred_dt);
		}



	public String getReplycode() {
		return replycode;
	}



	public void setReplycode(String replycode) {
		this.replycode = replycode;
	}



	public String getPostid() {
		return postid;
	}



	public void setPostid(String postid) {
		this.postid = postid;
	}



	public String getReply() {
		return reply;
	}



	public void setReply(String reply) {
		this.reply = reply;
	}



	public Date getReplyred_dt() {
		return replyred_dt;
	}



	public void setReplyred_dt(Date replyred_dt) {
		this.replyred_dt = replyred_dt;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	@Override
	public String toString() {
		return "JSPReplyVo [replycode=" + replycode + ", postid=" + postid
				+ ", reply=" + reply + ", replyred_dt=" + replyred_dt
				+ ", userid=" + userid + "]";
	}



	public JSPReplyVo( String postid, String reply,String userid) {
		super();
		this.postid = postid;
		this.reply = reply;
		this.userid = userid;
		
	}



	public JSPReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	  
	  
	

}
