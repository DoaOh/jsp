package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	/**
	 * Method : userList
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 :
	 */
	List<UserVo> userList();
	
	
	public UserVo getUser(String userId);	


}
