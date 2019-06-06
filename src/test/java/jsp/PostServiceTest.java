package jsp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PostServiceTest.class);
	
	

	IuserService userService = new UserService();
	
	@Test
	public void UserListTest() {
		//테스트 작성
		/***Given***/
		
		/***When***/
		List<UserVo> userList = userService.userList();
		
		/***Then***/
		assertEquals("11",userList.get(0).getUserId());
		assertEquals(116, userList.size());

		logger.debug("userList {} ",userList);
		
	}
	
	@Test
	public void getUserTest(){
		
		/***Given***/
		
		String userId= "black";

		/***When***/
		UserVo uservo  =userService.getUser(userId);

		/***Then***/
		assertEquals("김대용",uservo.getName());
		logger.debug("userInfo {} ",uservo);
		
	}
	
	
}
