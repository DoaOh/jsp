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
	
	
	
	

}
