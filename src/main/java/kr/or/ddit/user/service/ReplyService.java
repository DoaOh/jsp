package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IReplyDao;
import kr.or.ddit.user.dao.ReplyDao;
import kr.or.ddit.user.model.JSPReplyVo;



public class ReplyService implements IReplyService{
	
	IReplyDao dao = new ReplyDao();

	@Override
	public JSPReplyVo getReply(String replycode) {
		
		return dao.getReply(replycode);
		
	}

	@Override
	public List<JSPReplyVo> replyList(String postid) {
		return dao.replyList(postid);
	}
	

	@Override
	public int insertReply(JSPReplyVo jspReplyVo) {
		return dao.insertReply(jspReplyVo);
	}

	@Override
	public int deleteReply(JSPReplyVo jspReplyVo) {
		return dao.deleteReply(jspReplyVo);
	}

	@Override
	public int updateReply(JSPReplyVo jspReplyVo) {
		return dao.updateReply(jspReplyVo);
	}
	

	

}
