package jsp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.user.dao.IPostDao;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.PostDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	IPostDao dao = new PostDao();
	
	private IPostDao postDao;

	
	@Test
	public void postListTEST() {
		//테스트 작성
		/***Given***/
	

		/***When***/
		List<JSPPostVo> postList = dao.postList();

		/***Then***/
		
		assertEquals("80017",postList.get(0).getPostid());
	

		logger.debug("postList {} ",postList);
		
	}
	
	
	
	@Test
	public void boardPostListTEST() {
		//테스트 작성
		/***Given***/
		
	   String boardid ="60001";

		/***When***/
		List<JSPPostVo> boardPostList = dao.boardPostList(boardid);

		/***Then***/
		
		assertEquals("80017",boardPostList.get(0).getPostid());
	

		logger.debug("postList {} ",boardPostList);
		
	}
	
	
	
	
	@Test
	public void getPostTest(){
		
		postDao = new PostDao();
		
		/***Given***/
		String postid= "80022";

		/***When***/
		JSPPostVo JSPPostVo = postDao.getPost(postid);
		
		logger.debug("JSPPostVo {} ",JSPPostVo);
		
		/***Then***/
		assertEquals("dkskqk00",JSPPostVo.getUserid());
		
			
	}
	
	
	@Test
	public void insertPostTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		
		 
		JSPPostVo jSPPostVo=null;
		
		String postid= "80002";
		String userid= "dkskqk00";
		String posttitle="생길까용";
		String postcontent="postcontent";
		String postid2 = "80001";
		String boardid= "60001";
		
	
		jSPPostVo= new JSPPostVo(postid, userid, posttitle, postcontent, postid2,  boardid);
		
		/***When***/
		
		int insertCnt=dao.insertPost(jSPPostVo);

		/***Then***/

		assertEquals(1, insertCnt);
		
		int deleteCnt=dao.deletePost(jSPPostVo.getPostid());
		
		assertEquals(0, deleteCnt);
		
	}
	
	
	
	
	
	

	@Test
	public void updatePostTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		
		 
		JSPPostVo jSPPostVo = null;
		String postid= "80008";
		String userid= "dkskqk00";
		String posttitle="바뀌나용";
		String postcontent="postcontent";
		String postid2 = "80001";
		String boardid= "60001";
		
	
		jSPPostVo= new JSPPostVo(postid,userid, posttitle, postcontent, postid2,  boardid);
		
		/***When***/
		
		int updtateCnt=dao.updatePost(jSPPostVo);

		/***Then***/

		assertEquals(1, updtateCnt);
		
		
		
	}
	
	
	
	

}
