package jsp;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	private IuserDao userDao;
	

	
	@Test
	public void UserListTest() {
		//테스트 작성
		/***Given***/
	

		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		
		assertEquals("black",userList.get(0).getUserId());
		assertEquals(106, userList.size());

		logger.debug("userList {} ",userList);
		
	}
	
	
	
	@Test
	public void getUserTest(){
		userDao = new UserDao();
		/***Given***/
		String userId= "brown";

		/***When***/
		UserVo uservo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운",uservo.getName());
		logger.debug("userInfo {} ",uservo);	
	}
	
	
	
	

}
