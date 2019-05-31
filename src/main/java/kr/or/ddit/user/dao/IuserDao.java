package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	

List<UserVo> userList();
	
	
 UserVo getUser(String userId);	
 
 
 List<UserVo> userPagingList(PageVo pageVo);
 
 int usersCnt();
 																												
 
int insertUser(UserVo userVo);
 
int deleteUser(String userId);


int updateUser(UserVo userVo);

 
}
