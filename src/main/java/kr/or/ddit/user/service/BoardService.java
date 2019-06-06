package kr.or.ddit.user.service;

import java.util.List;
import kr.or.ddit.user.dao.BoardDao;
import kr.or.ddit.user.dao.IBoardDao;
import kr.or.ddit.user.model.JSPBoardVo;


public class BoardService implements IBoardService{
	
	IBoardDao dao = new BoardDao();
	

	//사용자 전체 리스트 조회

	@Override
	public List<JSPBoardVo> boardList() {

		return dao.boardList();
	
	}
	@Override
	public List<JSPBoardVo> boardALLList() {
		
		return dao.boardALLList();
		
	}


	@Override
	public JSPBoardVo getBoard(String boardid) {
	
		return dao.getBoard(boardid);
	}



	@Override
	public int insertBoard(JSPBoardVo jspBoardVo) {
		return dao.insertBoard(jspBoardVo);
	}



	@Override
	public int deleteBoard(String boardid) {
		return dao.deleteBoard(boardid);
	}



	@Override
	public int updateBoard(JSPBoardVo jspBoardVo) {
		return dao.updateBoard(jspBoardVo);
	}





	
	


	
	



	
	


	
	

}
