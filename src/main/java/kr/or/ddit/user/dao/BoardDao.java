package kr.or.ddit.user.dao;

import java.util.List;
import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.user.model.JSPBoardVo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDao implements IBoardDao {

	private static final Logger logger = LoggerFactory
			.getLogger(BoardDao.class);
	
	public static void main(String[] args) {
		
	}

	@Override
	public List<JSPBoardVo> boardList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPBoardVo> boardList= sqlSession.selectList("user.boardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public List<JSPBoardVo> boardALLList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPBoardVo> boardList= sqlSession.selectList("user.boardALLList");
		sqlSession.close();
		return boardList;
	}
	

	


	@Override
	public int boardCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int boardCnt =(Integer)sqlSession.selectOne("user.boardCnt");
		sqlSession.close();
		return boardCnt;
	}

	
	@Override
	public JSPBoardVo getBoard(String boardid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		JSPBoardVo boardVo = sqlSession.selectOne("user.boardInfo",boardid);
		sqlSession.close();
		return boardVo;
	}

	
	
	
	
	@Override
	public int updateBoard (JSPBoardVo jspBoardVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int updateCnt=sqlSession.insert("user.updateBoard",jspBoardVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deleteBoard (String boardid) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deleteBoard",boardid);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int insertBoard (JSPBoardVo jspBoardVo) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertBoard",jspBoardVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	
	
	
	
	
}
