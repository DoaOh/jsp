package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myBatis.MyBataisUtill;
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
		

		/***When***/
		List<UserVo> userList = userDao.userList();
		
		
		/***Then***/

		
		logger.debug("userList {} ",userList);
		
		
		
	}

	@Override
	public List<UserVo> userList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList= sqlSession.selectList("user.userList");
		
		return userList;
	}
	
	
	
	
}
