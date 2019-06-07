package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;










import kr.or.ddit.paging.model.BPageVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;

public interface IPostService {
	

List<JSPPostVo> postList();
List<JSPPostVo> boardPostList(String boardid);
 
Map<String, Object> postPagingList(PageVo pageVo);

Map<String, Object> boardPostPagingList(BPageVo BpageVo);

public JSPPostVo getPost(String postId);

int insertPost(JSPPostVo jSPPostVo);	

//int deletePost(JSPPostVo jSPPostVo);
int deletePost(String postId);

int updatePost(JSPPostVo jSPPostVo);





}
