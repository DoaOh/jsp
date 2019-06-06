package kr.or.ddit.user.service;


import java.util.List;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	
	
	IuserDao dao = new UserDao();
	
	
	//사용자 전체 리스트 조회

	@Override
	public List<UserVo> userList() {
		
		return dao.userList();
	
	}

	@Override
	public UserVo getUser(String userId) {
	
		return dao.getUser(userId);
	}



}
