package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDao implements ILprodDao {

	private static final Logger logger = LoggerFactory
			.getLogger(LprodDao.class);
	
	public static void main(String[] args) {
		
	}

	@Override
	public List<LprodVo> lprodList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<LprodVo> lprodList= sqlSession.selectList("user.lprodList");
		
		return lprodList;
	}


	
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<LprodVo> lprodPagingList = sqlSession.selectList("user.lprodPagingList",pageVo);
		sqlSession.close();
		return lprodPagingList;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int lprodCnt =(Integer)sqlSession.selectOne("user.lprodCnt");
		sqlSession.close();
		return lprodCnt;
	}

	
}
