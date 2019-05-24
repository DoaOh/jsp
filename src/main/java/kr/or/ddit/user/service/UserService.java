package kr.or.ddit.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	
	
	
	
	//사용자 전체 리스트 조회

	@Override
	public List<UserVo> userList() {
		
	
       SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userList");
		
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {

		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		UserVo uservo = sqlSession.selectOne("user.userInfo",userId);
		
		return uservo;
	}

	
	

}
