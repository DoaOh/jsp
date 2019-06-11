package kr.or.ddit.user.dao;

import java.util.List;
import kr.or.ddit.user.model.JSPFileVo;

public interface IFileDao {
	

 public JSPFileVo getFile(String postid);
 public JSPFileVo FileDown(String fileid);
	
 List<JSPFileVo> FileList(String postid);
 
 int FileCnt();

 int insertFile(JSPFileVo JSPFileVo);	
 int insertFile2(JSPFileVo JSPFileVo);	

 int updateFile(JSPFileVo JSPFileVo);
 
 int deleteFile(String fileid);



}
