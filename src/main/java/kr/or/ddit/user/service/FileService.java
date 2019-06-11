package kr.or.ddit.user.service;

import java.util.List;

import javax.servlet.ServletException;

import kr.or.ddit.user.dao.FileDao;
import kr.or.ddit.user.dao.IFileDao;
import kr.or.ddit.user.model.JSPFileVo;


public class FileService implements IFileService{
	
    IFileDao dao = new FileDao();

	
	@Override
	public JSPFileVo getFile(String postid) {
		return dao.getFile(postid);
		
	}
	
	@Override
	public JSPFileVo FileDown(String fileid) {
		return dao.FileDown(fileid);
		
	}

	@Override
	public List<JSPFileVo> FileList(String postid) {
		return dao.FileList(postid);
	}
	

	@Override
	public int insertFile(JSPFileVo JSPFileVo) {
		return dao.insertFile(JSPFileVo);
	}
	
	public int insertFile2(JSPFileVo JSPFileVo) {
		return dao.insertFile2(JSPFileVo);
	}


	@Override
	public int updateFile(JSPFileVo JSPFileVo) {
		return dao.updateFile(JSPFileVo);
	}
	
	@Override
	public int deleteFile(String fileid) {
		return dao.deleteFile(fileid);
	}


	

	

}
