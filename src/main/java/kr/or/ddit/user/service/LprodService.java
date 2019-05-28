package kr.or.ddit.user.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.ILprodDao;
import kr.or.ddit.user.dao.LprodDao;
import kr.or.ddit.user.model.LprodVo;


public class LprodService implements ILprodService{
	
	
	
	
	//사용자 전체 리스트 조회

	@Override
	public List<LprodVo> lprodList() {
		
	
	ILprodDao dao = new LprodDao();
		
		return dao.lprodList();
	
	}


	
	public Map<String, Object> lprodPagingList(PageVo pageVo) {

		ILprodDao dao = new LprodDao();
	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", dao.lprodPagingList(pageVo));
		
		
		int usersCnt =dao.lprodCnt();
		
		int paginationSize =(int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		 
		return resultMap;
	}







	
	


	
	

}
