package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IuriDao;
import kr.or.ddit.dao.UriDao;
import kr.or.ddit.model.urimappingVo;



public class UriService implements IuriService {

	IuriDao dao;
	
	

	public UriService() {
		dao = new UriDao();
	}



	@Override
	public List<urimappingVo> urimappingList() {

		return dao.urimappingList();

	}

}
