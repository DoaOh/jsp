package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.JSPReplyVo;


public interface IReplyDao {
	

 

 public JSPReplyVo getReply(String replycode);
	
 List<JSPReplyVo> replyList(String postid);
 
 int replyCnt();

 int insertReply(JSPReplyVo jspReplyVo);	

 int deleteReply(JSPReplyVo jspReplyVo);

 int updateReply(JSPReplyVo jspReplyVo);



}
