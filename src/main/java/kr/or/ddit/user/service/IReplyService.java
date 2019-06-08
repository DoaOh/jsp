package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.JSPReplyVo;

public interface IReplyService {
	

public JSPReplyVo getReply(String replycode);
	
List<JSPReplyVo> replyList(String postid);


int insertReply(JSPReplyVo jspReplyVo);	

int deleteReply(String replycode);

int updateReply(JSPReplyVo jspReplyVo);





}
