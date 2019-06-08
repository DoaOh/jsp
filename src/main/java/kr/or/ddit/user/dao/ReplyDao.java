package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.user.model.JSPReplyVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyDao implements IReplyDao {

	
	
	@Override
	public JSPReplyVo getReply(String replycode) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		JSPReplyVo replyVo = sqlSession.selectOne("user.boardInfo",replycode);
		
		return replyVo;
	}

	

	@Override
	public List<JSPReplyVo> replyList(String postid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPReplyVo> replyList= sqlSession.selectList("user.replyList",postid);
		
		return replyList;
	}
	


	@Override
	public int replyCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int replyCnt =(Integer)sqlSession.selectOne("user.replyCnt");
		sqlSession.close();
		return replyCnt;
	}


	
	@Override
	public int insertReply (JSPReplyVo jspReplyVo) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertReply",jspReplyVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	
	@Override
	public int deleteReply (String replycode) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deleteReply",replycode);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	
	
	@Override
	public int updateReply (JSPReplyVo jspReplyVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int updateCnt=sqlSession.insert("user.updateReply",jspReplyVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}



	
	
	
	
	
}
