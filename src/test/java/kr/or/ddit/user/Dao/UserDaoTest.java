package kr.or.ddit.user.Dao;

import static org.junit.Assert.*;

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


public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
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
	
	
	
	/**
	 * Method : UserListTest
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 조회 테스트
	 * 
	 */
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
	
		String userId= "brown";

		/***When***/
		UserVo uservo  =userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운",uservo.getName());
		

		logger.debug("userInfo {} ",uservo);
		
	}
	
	
	
	//사용자 페이징 리스트 조회 
	//고려사항 
	//몇번짼 페이지 조회인지 
	// 페이지당 몇건씩 데이터를 보여줄건지? 쿼리 실행 파라미터 
	//정렬순서 로직 파라미터화 시킬수 있다 
	//사용자 아이디 순으로 정렬

}
