package kr.or.ddit.user.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	
	
	
	
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

	
	
	


	
	

}
