package jsp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.user.dao.BoardDao;
import kr.or.ddit.user.dao.IBoardDao;
import kr.or.ddit.user.model.JSPBoardVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BoardDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	
	
	IBoardDao dao = new BoardDao();
	
	private IBoardDao boardDao;

	
	@Test
	public void boardListTEST() {
		//테스트 작성
		/***Given***/
	

		/***When***/
		List<JSPBoardVo> boardList = dao.boardList();

		/***Then***/
		
		assertEquals("60024",boardList.get(0).getBoardid());
	

	}
	
	
	
	@Test
	public void getBoardTest(){
		
		boardDao = new BoardDao();
		
		/***Given***/
		String boardid= "60001";

		/***When***/
		JSPBoardVo jspBoardVo = boardDao.getBoard(boardid);
		
		logger.debug("JSPPostVo {} ",jspBoardVo);
		
		/***Then***/
		assertEquals("dkskqk00",jspBoardVo.getUserid());
		
			
	}
	
	
	@Test
	public void insertBoardTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		
		 
		JSPBoardVo jspBoardVo=null;
		
		String boardid= "60004"; 
		String boardname= "식단표";
		String userid= "dkskqk00";
		String boarduse_yn="0";
		//String boardid= "60002";
		
		jspBoardVo= new JSPBoardVo(boardid,boardname,boarduse_yn, userid);
		
		/***When***/
		
		int insertCnt=dao.insertBoard(jspBoardVo);

		/***Then***/

		assertEquals(1, insertCnt);
		
		/*int deleteCnt=dao.deleteBoard(jspBoardVo.getBoardid());
		
		assertEquals(1, deleteCnt);*/
		
	}
	
	
	
	
	
	

	@Test
	public void updatePostTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		JSPBoardVo jspBoardVo=null;
		
		String boardid= "60004"; 
		String boardname= "오늘의식단표";
		String userid= "dkskqk00";
		String boarduse_yn="0";
		jspBoardVo= new JSPBoardVo(boardid,boardname,boarduse_yn, userid);
		/***When***/
		
		int updtateCnt=dao.updateBoard(jspBoardVo);

		/***Then***/

		assertEquals(1, updtateCnt);
		
		
		
	}
	
	
	@Test
	public void deletePostTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		JSPBoardVo jspBoardVo=null;
		
		String boardid= "60004"; 
		String boardname= "오늘의식단표";
		
		String userid= "dkskqk00";
		String boarduse_yn="0";
		jspBoardVo= new JSPBoardVo(boardid,boardname,boarduse_yn, userid);
		/***When***/
		
		int deleteCnt=dao.deleteBoard(boardid);

		/***Then***/

		assertEquals(1, deleteCnt);
		
		
		
	}
	
	
	

}
