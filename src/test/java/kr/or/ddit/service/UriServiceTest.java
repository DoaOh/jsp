package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.dao.IuriDao;
import kr.or.ddit.dao.UriDao;
import kr.or.ddit.model.urimappingVo;

import org.junit.Test;

public class UriServiceTest {
	
	 
	
	IuriService service = new UriService();
	
	

	
	@Test
	public void urimappingListTEST() {
		//테스트 작성
		/***Given***/
		
	

		/***When***/
		List<urimappingVo> urimappingList = service.urimappingList();

		/***Then***/
		
		assertEquals("/main.do",urimappingList.get(0).getUri());
	

	}
	
	

}
