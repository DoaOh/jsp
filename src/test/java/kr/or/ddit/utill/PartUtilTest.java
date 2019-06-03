package kr.or.ddit.utill;
import static org.junit.Assert.*;

import java.util.UUID;

import kr.or.ddit.util.PartUtil;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PartUtilTest {

	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);
	
	@Test
	public void getNameTest() {
	
		/***Given***/
		String contentDisposition= "form-data; name=\"profile\"; filename=\"sally.png\"";

		/***When***/
				String filename = PartUtil.getFileName(contentDisposition);

		/***Then***/
		assertEquals("brown", filename);
	}

	
	
	@Test
	public void uuidTest(){
		
		
		/***Given***/
		

		/***When***/
		logger.debug("UUID.randomUUID : {} ", UUID.randomUUID().toString());

		/***Then***/

		
	}
	
	
	
@Test
	
	public void getExtTest(){
		
		
		/***Given***/
		
		String filename ="brown.png";
		String filename2 ="brown.picture.png";
		String filename3 ="brown";

		/***When***/

		String ext = PartUtil.getExt(filename);
		String ext2 = PartUtil.getExt(filename2);
		String ext3 = PartUtil.getExt(filename3);
		/***Then***/
		
		assertEquals("png", ext);
		assertEquals("png", ext2);
		assertEquals("", ext3);
	
}
	


	@Test

	public void gwt() {

		
		/***Given***/
		String yyyyMM="201906";
		

		/***When***/
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);
		

		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);
		
	}


	
}
