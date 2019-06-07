package kr.or.ddit.user.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.BPageVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IPostDao;
import kr.or.ddit.user.dao.PostDao;
import kr.or.ddit.user.model.JSPPostVo;


public class PostService implements IPostService{
	
	IPostDao dao = new PostDao();
	
	//사용자 전체 리스트 조회

	@Override
	public List<JSPPostVo> postList() {

		return dao.postList();
	
	}
	

	@Override
	public List<JSPPostVo> boardPostList(String boardid) {
		
		return dao.boardPostList(boardid);
		
	}


	
	public Map<String, Object> postPagingList(PageVo pageVo) {

		
	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("postList", dao.postPagingList(pageVo));
		
		
		int postCnt =dao.postCnt();
		
		int paginationSize =(int) Math.ceil((double)postCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		 
		return resultMap;
	}
	
	public Map<String, Object> boardPostPagingList(BPageVo BpageVo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardPostList", dao.boardPostPagingList(BpageVo));
		int postCnt =dao.postCnt();
		int paginationSize =(int) Math.ceil((double)postCnt/BpageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		return resultMap;
	}

	

	
	@Override
	public JSPPostVo getPost(String postId) {
	
		return dao.getPost(postId);
	}



	@Override
	public int insertPost(JSPPostVo jSPPostVo) {
		return dao.insertPost(jSPPostVo);
	}


/*
	@Override
	public int deletePost(String postId) {
		return dao.deletePost(postId);
	}
*/


	@Override
	public int updatePost(JSPPostVo jSPPostVo) {
		return dao.updatePost(jSPPostVo);
	}





	
	


	
	

}
