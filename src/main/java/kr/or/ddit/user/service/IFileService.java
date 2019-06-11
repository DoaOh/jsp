package kr.or.ddit.user.service;

import java.util.List;

import javax.servlet.ServletException;

import kr.or.ddit.user.model.JSPFileVo;

public interface IFileService {
	
	 public JSPFileVo getFile(String postid);
	 public JSPFileVo FileDown(String fileid);
	 List<JSPFileVo> FileList(String postid);
	 int insertFile(JSPFileVo JSPFileVo);	
	 int insertFile2(JSPFileVo JSPFileVo);	
	 int updateFile(JSPFileVo JSPFileVo);
	 int deleteFile(String fileid);




}
