package jsp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	
	
	@Test
	public void UserPagingListTest() {
		
		IuserService userService = new UserService();
		
		//테스트 작성
		/***Given***/
	
		PageVo pageVo = new PageVo(1,10);
	/*	pageVo.setPage(1);
		pageVo.setPageSize(10);
		*/
		/***When***/
		
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize =(Integer)resultMap.get("paginationSize");

		/***Then***/
	
		
		assertEquals(11, paginationSize);

	}
	
	

	
	
	
	@Test
	public void ceilTest() {
		
		IuserService userService = new UserService();
		
		//테스트 작성
		/***Given***/
		int usersCnt =106;
		int pageSize=10;
		

		/***When***/
		double PaginationSize = Math.ceil((double)usersCnt/10);
		logger.debug("PaginationSize{}",PaginationSize);

		/***Then***/
	assertEquals(11, PaginationSize);
		


	}
	
	
	
}
