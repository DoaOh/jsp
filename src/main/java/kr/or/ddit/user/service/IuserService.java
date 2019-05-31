package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;




import kr.or.ddit.paging.model.PageVo;
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

	Map<String, Object> userPagingList(PageVo pageVo);
	
	int insertUser(UserVo userVo);
	 
	
	int deleteUser(String userId);

int updateUser(UserVo userVo);
	
}
