package jsp;

import static org.junit.Assert.*;


import kr.or.ddit.user.dao.IFileDao;
import kr.or.ddit.user.model.JSPFileVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(FileDaoTest.class);
	
	
	IFileDao dao = new kr.or.ddit.user.dao.FileDao();
	
	private IFileDao FileDao;


	
	
	@Test
	public void getfileTest(){
		
	
		
		/***Given***/
		String postid= "80001";

		/***When***/
		JSPFileVo jspfileVo = dao.getFile(postid);
		
		logger.debug("JSPPostVo {} ",jspfileVo);
		
		/***Then***/
		assertEquals("20001",jspfileVo.getFilepath());
		
			
	}
	
	
	
	@Test
	public void filedownTest(){
		
		
		
		/***Given***/
		String fileid= "20021";
		
		/***When***/
		JSPFileVo jspfileVo = dao.FileDown(fileid);
		
		logger.debug("JSPPostVo {} ",jspfileVo);
		
		/***Then***/
		assertEquals("20001",jspfileVo.getFilepath());
		
		
	}
	
	
	
	
	@Test
	public void insertFileTest(){
		
		
		/***Given***/
		//사용자 정보를 담고있는 vo객체 준비 
		
		 
		JSPFileVo jspFileVo=null;
		

		String postid= "";
		String filepath= "0";
		String filename="0";
		
		
		jspFileVo= new JSPFileVo(postid,filepath,filename);
		
		/***When***/
		
		int insertCnt=dao.insertFile(jspFileVo);

		/***Then***/

		assertEquals(1, insertCnt);
		
		/*int deleteCnt=dao.deleteBoard(jspBoardVo.getBoardid());
		
		assertEquals(1, deleteCnt);*/
		
	}
	
	

	

}
