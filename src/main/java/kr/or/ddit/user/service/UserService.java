package kr.or.ddit.user.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	IuserDao dao = new UserDao();
	
	
	//사용자 전체 리스트 조회

	@Override
	public List<UserVo> userList() {
		
	
	IuserDao dao = new UserDao();
		
		return dao.userList();
	
	}

	@Override
	public UserVo getUser(String userId) {

IuserDao dao = new UserDao();
		
		return dao.getUser(userId);
	}

	
	public Map<String, Object>userPagingList(PageVo pageVo) {
		/*
		1.list<userVo>  userCnt를 필드로 하는 vo
	    2.List<Object> resultList =new ArrayList<Object>()
		resultList.add(userList);
		resultList.add(userCnt);
		
		3.Map<String Objsect> resultMap = enw HashMap<String ,Object>();
		resultMap.put("userList",userList)
		resultMap.put("userCnt",userCnt)*/
		
		IuserDao dao = new UserDao();
	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", dao.userPagingList(pageVo));
		
		
		//resultMap.put("usersCnt", dao.usersCnt());
		
		int usersCnt =dao.usersCnt();
		
		int paginationSize =(int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		 
		return resultMap;
	}

	
	
	
	@Override
	public int insertUser(UserVo userVo) {

    IuserDao dao = new UserDao();
		
		return dao.insertUser(userVo);
	}

	
	
	
	
	
	@Override
	public int deleteUser(String userId) {

	    IuserDao dao = new UserDao();
			
			return dao.deleteUser(userId);
	}

	
	@Override
	public int updateUser(UserVo userVo) {
		 IuserDao dao = new UserDao();
		return dao.updateUser(userVo);
	}

	
	
	
	
	/**
	 * Method : encryptPassAlluser
	 * 작성자 : PC02
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 일괄 암호화 
	 */
	
	
	@Override
	public int encryptPassAllUser() {
		
		//이미 암호화 적용되어있음
		if(1==1){ return 0;}
		
		
		//sql실행에 필요한 sqlsession 객체를 생성 
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		
	
		//모든 사용자 정보 조회 단  기존 암호화 적용 사용자 제외 
		List<UserVo> userList =dao.userListForPassEncrypt(sqlSession);
		
		
		
		int udateCntSum=0;
		//조회된 사용자의 비밀번호를 암호화 적용후 사용자 업데이트 
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());	
			 userVo.setPass(encryptPass);
			 
			 
			 
			int updateCnt= dao.updateUserEncryptPass(sqlSession,userVo);
			
			 udateCntSum += updateCnt;
					
			if(updateCnt !=1){
				
				sqlSession.rollback();
				break;
			}
			
		}
		sqlSession.commit();
		sqlSession.close();
		
		//sqlsession 을 commit close
		return udateCntSum;
	}

	
	
	public static void main(String[] args) {
		
		IuserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt {} ", updateCnt);
	}
	
	

}
