package kr.or.ddit.dao;

import java.util.List;
import kr.or.ddit.model.urimappingVo;
import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.myBatis.MyBataisUtill;

public  class UriDao implements IuriDao {

	
/*	@Override
	public urimappingVo uriInfo(String uri) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		urimappingVo uriInfo = sqlSession.selectOne("urimapping.uriInfo",uri);
		sqlSession.close();
		return uriInfo;
	}
	
	public urimappingVo classnameInfo(String classname) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		urimappingVo classnameInfo = sqlSession.selectOne("urimapping.classnameInfo",classname);
		sqlSession.close();
		return classnameInfo;
	}
	*/


	@Override
	public List<urimappingVo> urimappingList(){
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<urimappingVo> urimappingList = sqlSession.selectList("urimapping.urimappingList");
		sqlSession.close();
		return urimappingList;
		
		
	}




	


}
