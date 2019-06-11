package kr.or.ddit.user.dao;

import java.util.List;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	
List<UserVo> userList();
UserVo getUser(String userId);	
 

 
}
