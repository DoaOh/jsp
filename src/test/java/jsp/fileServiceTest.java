package jsp;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.UUID;

import kr.or.ddit.user.model.JSPFileVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.FileService;
import kr.or.ddit.user.service.IFileService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class fileServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(fileServiceTest.class);
	

	IFileService fileService = new FileService();
	
	
	@Test
	public void getFile(){
		

		/***Given***/
		String postid= "80001";

		/***When***/
		JSPFileVo jspfileVo = fileService.getFile(postid);
		
		logger.debug("JSPPostVo {} ",jspfileVo);
		
		/***Then***/
		assertEquals("20001",jspfileVo.getFilepath());
		
	}
	
	
	
	
	
	@Test
	public void filedownTest(){
		
		
		
		/***Given***/
		String fileid= "20021";
		
		/***When***/
		JSPFileVo jspfileVo = fileService.FileDown(fileid);
		
		logger.debug("JSPPostVo {} ",jspfileVo);
		
		/***Then***/
		assertEquals("20001",jspfileVo.getFilepath());
		
		
	}
	
	
	
	
	
	
	@Test
	public void insertFile(){
		

		/***Given***/
		String postid= "0";
		String filepath= "80001";
		String filename= "80001";

		JSPFileVo JSPFileVo=null;
		JSPFileVo = new JSPFileVo(postid,filepath,filename);
		/***When***/
		
		int insertCnt=fileService.insertFile(JSPFileVo);

		
		
		/***Then***/
		assertEquals(1, insertCnt);
		
		
		

		
		
		
	}
	
	
	
}
