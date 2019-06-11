package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.user.model.JSPFileVo;

import org.apache.ibatis.session.SqlSession;

public class FileDao implements IFileDao {

	
	
	@Override
	public JSPFileVo getFile(String postid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		JSPFileVo fileVo = sqlSession.selectOne("user.getFile",postid);
		sqlSession.close();
		return fileVo;
	}
	
	@Override
	public JSPFileVo FileDown (String fileid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		JSPFileVo fileVo = sqlSession.selectOne("user.FileDown",fileid);
		sqlSession.close();
		return fileVo;
	}

	

	@Override
	public List<JSPFileVo> FileList(String postid) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<JSPFileVo> FileList= sqlSession.selectList("user.FileList",postid);
		sqlSession.close();
		return FileList;
	}
	


	@Override
	public int FileCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int FileCnt =(Integer)sqlSession.selectOne("user.FileCnt");
		sqlSession.close();
		return FileCnt;
	}


	
	@Override
	public int insertFile (JSPFileVo JSPFileVo) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertFile",JSPFileVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	
	@Override
	public int insertFile2 (JSPFileVo JSPFileVo) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertFile2",JSPFileVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	
	@Override
	public int updateFile (JSPFileVo JSPFileVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int updateCnt=sqlSession.insert("user.updateFile",JSPFileVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deleteFile(String fileid) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deleteFile",fileid);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}



	
	
	
	
	
}
