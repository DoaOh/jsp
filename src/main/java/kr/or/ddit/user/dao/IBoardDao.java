package kr.or.ddit.user.dao;

import java.util.List;
import kr.or.ddit.user.model.JSPBoardVo;


public interface IBoardDao {
	

List<JSPBoardVo> boardList();

List<JSPBoardVo> boardALLList();
	
 
 int boardCnt();

 
 JSPBoardVo getBoard(String boardid);


int updateBoard(JSPBoardVo jspBoardVo);


int deleteBoard(String boardid);


int insertBoard(JSPBoardVo jspBoardVo);	
 
}
