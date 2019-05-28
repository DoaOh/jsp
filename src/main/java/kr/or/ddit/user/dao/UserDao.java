package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	public static void main(String[] args) {
		
		
		/***Given***/
		
		IuserDao userDao= new UserDao();
		String userId= "brown";

		/***When***/
		List<UserVo> userList = userDao.userList();
		UserVo uservo  =userDao.getUser(userId);
		
		/***Then***/

		
		logger.debug("userList {} ",userList);
		logger.debug("userInfo {} ",uservo);
		
		
		
	}

	@Override
	public List<UserVo> userList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList= sqlSession.selectList("user.userList");
		
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {

		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		UserVo uservo = sqlSession.selectOne("user.userInfo",userId);
		
		return uservo;
	
	
	}

	
	
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList",pageVo);
		sqlSession.close();
		return userList;
	}

	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int userCnt =(Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return userCnt;
	}	
}
