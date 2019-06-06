package kr.or.ddit.user.service;

import java.util.List;
import kr.or.ddit.user.model.JSPBoardVo;

public interface IBoardService {
	

List<JSPBoardVo> boardList();
List<JSPBoardVo> boardALLList();

public JSPBoardVo getBoard(String boardid);

int insertBoard(JSPBoardVo jspBoardVo);	

int deleteBoard(String boardid);

int updateBoard(JSPBoardVo jspBoardVo);





}
