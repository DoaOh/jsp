package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.paging.model.BPageVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostDao implements IPostDao {

	private static final Logger logger = LoggerFactory
			.getLogger(PostDao.class);
	
	public static void main(String[] args) {
		
	}

	@Override
	public List<JSPPostVo> postList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPPostVo> postList= sqlSession.selectList("user.postList");
		sqlSession.close();
		return postList;
	}
	

	@Override
	public List<JSPPostVo> boardPostList(String boardid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPPostVo> boardPostList= sqlSession.selectList("user.boardPostList",boardid);
		sqlSession.close();
		return boardPostList;
	}


	
	@Override
	public List<JSPPostVo> postPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPPostVo> postPagingList = sqlSession.selectList("user.postPagingList",pageVo);
		sqlSession.close();
		return postPagingList;
	}
	
	
	@Override
	public List<JSPPostVo> boardPostPagingList(BPageVo BpageVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPPostVo> boardPostPagingList = sqlSession.selectList("user.boardPostPagingList",BpageVo);
		sqlSession.close();
		return boardPostPagingList;
	}
	
	
	
	

	@Override
	public int postCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int postCnt =(Integer)sqlSession.selectOne("user.postCnt");
		sqlSession.close();
		return postCnt;
	}
	
	
	@Override
	public int BoardPostCnt(String boardid) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int BoardPostCnt =(Integer)sqlSession.selectOne("user.BoardPostCnt",boardid);
		sqlSession.close();
		return BoardPostCnt;
	}

	
	@Override
	public JSPPostVo getPost(String postid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		JSPPostVo postVo = sqlSession.selectOne("user.postInfo",postid);
		return postVo;
	}

	
	
	
	
	@Override
	public int updatePost(JSPPostVo jSPPostVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int updateCnt=sqlSession.insert("user.updatePost",jSPPostVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	/*@Override
	public int deletePost(JSPPostVo jSPPostVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deletePost",jSPPostVo);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}*/

	
	
	
	@Override
	public int deletePost(String postId) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deletePost",postId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	
	
	@Override
	public int insertPost(JSPPostVo jSPPostVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertPost",jSPPostVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}


	@Override
	public int insertPost2(JSPPostVo jSPPostVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertPost2",jSPPostVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	
	
	
	
}
