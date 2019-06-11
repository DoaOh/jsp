package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
public class UserDao implements IuserDao {



	@Override
	public List<UserVo> userList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList= sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {

		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		UserVo uservo = sqlSession.selectOne("user.userInfo",userId);
		sqlSession.close();
		return uservo;
	
	
	}

	
	
}
