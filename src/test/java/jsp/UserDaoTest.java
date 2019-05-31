package jsp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.paging.model.PageVo;
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
	
	
	
	
	
	/**
	 * Method : UserPagingListTest
	 * 작성자 : PC02
	 * 변경이력 :
	 * Method 설명 :사용자 페이징 리스트 조회 테스트 
	 */
	@Test
	public void UserPagingListTest() {
		
		//테스트 작성
		/***Given***/
	
		PageVo pageVo = new PageVo(1,10);
	/*	pageVo.setPage(1);
		pageVo.setPageSize(10);
		*/
		/***When***/
		List<UserVo> userList = userDao.userPagingList(pageVo);

		/***Then***/
	
		
		assertNotNull(userList);
		assertEquals(10, userList.size());

	}
	
	
	@Test
	public void usersCntTest() {
		
		
		/***Given***/

		
		/***When***/
int usersCnt = userDao.usersCnt();
		/***Then***/
	
		

		assertEquals(106, usersCnt);
	}
	
	
	
	@Test
	public void insertUserTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		

		 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		 
		 UserVo userVo=null;
		
		try {
			userVo= new UserVo("name","id","ali","pass","addr1","addr2","zip",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		/***When***/
		
		int insertCnt=userDao.insertUser(userVo);

		/***Then***/

		assertEquals(1, insertCnt);
		
		int deleteCnt=userDao.deleteUser(userVo.getUserId());
		
		assertEquals(1, deleteCnt);
		
	}
	
	


	
	
	


}
