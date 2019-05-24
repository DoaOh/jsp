package kr.or.ddit.user.Service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	
	
	
	
	private IuserDao userDao;
	
	
	@BeforeClass
	public static void beforeclass(){
		logger.debug("beforeclass");
		
	}
	

	@Before
	public void setup(){
		
		 userDao = new UserDao();

		logger.debug("setup");
		
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterclass");
		
	}
	
	
	
	
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
		
		/***Given***/
		
		String userId= "black";

		/***When***/
		UserVo uservo  =userDao.getUser(userId);

		/***Then***/
		assertEquals("김대용",uservo.getName());
		logger.debug("userInfo {} ",uservo);
		
	}
	
	
	
	
	
	

}
