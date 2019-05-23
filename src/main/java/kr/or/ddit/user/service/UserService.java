package kr.or.ddit.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	
	
	
	
	//사용자 전체 리스트 조회

	@Override
	public List<UserVo> userList() {
		
		
		List<UserVo> userList = new ArrayList<UserVo>();
			
			userList.add(new UserVo("브라운","brown","곰"));
			userList.add(new UserVo("코니","cony","토끼"));
			userList.add(new UserVo("샐리","sally","오리"));
			userList.add(new UserVo("제암스","james","띠용"));
			userList.add(new UserVo("문","moon","달"));
		return userList;
	}

	
	

}
