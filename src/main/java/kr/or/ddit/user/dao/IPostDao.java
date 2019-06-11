package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.BPageVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;

public interface IPostDao {
	

List<JSPPostVo> postList();

List<JSPPostVo> boardPostList(String boardid);
	
 
 List<JSPPostVo> postPagingList(PageVo pageVo);
 
 List<JSPPostVo> boardPostPagingList(BPageVo BpageVo);
 
 int postCnt();
 int BoardPostCnt(String boardid);	

 
 JSPPostVo getPost(String postid);


int updatePost(JSPPostVo jSPPostVo);


//int deletePost(JSPPostVo jSPPostVo);


int deletePost(String postId);



int insertPost(JSPPostVo jSPPostVo);	
int insertPost2(JSPPostVo jSPPostVo);

 
}
