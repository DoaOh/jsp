package jsp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import kr.or.ddit.user.dao.IReplyDao;
import kr.or.ddit.user.model.JSPReplyVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReplyDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDaoTest.class);
	
	IReplyDao dao = new kr.or.ddit.user.dao.ReplyDao();
	
	private IReplyDao ReplyDao;

	
	@Test
	public void preplyListTEST() {
		//테스트 작성
		/***Given***/
	String postid= "80009";

		/***When***/
		List<JSPReplyVo> replyList = dao.replyList(postid);

		/***Then***/
		
		assertEquals("30001",replyList.get(0).getReplycode());
	

		logger.debug("postList {} ",replyList);
		
	}
	
	@Test
	public void insertReplyTest(){
		
		
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
	public void updateReplyTest(){
		
		
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
