package kr.or.ddit.Dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.dao.IuriDao;
import kr.or.ddit.dao.UriDao;
import kr.or.ddit.model.urimappingVo;


public class UriDaoTest {

	
	IuriDao dao = new UriDao();
	
	
	
	@Test
	public void urimappingListTEST() {
		//테스트 작성
		/***Given***/
	

		/***When***/
		List<urimappingVo> urimappingList = dao.urimappingList();

		/***Then***/
		
		assertEquals("/main.do",urimappingList.get(0).getUri());
	

	}
	
	

	

}
