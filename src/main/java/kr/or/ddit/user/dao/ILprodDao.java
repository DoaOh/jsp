package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;

public interface ILprodDao {
	

List<LprodVo> lprodList();
	
 
 List<LprodVo> lprodPagingList(PageVo pageVo);
 
 int lprodCnt();
 
}
