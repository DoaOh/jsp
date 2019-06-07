package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.JSPBoardVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;
import kr.or.ddit.user.service.IReplyService;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;



@WebServlet("/left")
public class leftController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(leftController.class);
	
	
	private static final long serialVersionUID = 1L; 
	
	
	private IBoardService  boardService;
	@Override
	public void init() throws ServletException {
		
		boardService = new BoardService();
			
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	  List<JSPBoardVo> boardList= boardService.boardList();
	   
	  logger.debug(" {}",boardList);
	   
	   
	  request.setAttribute("boardList", boardList);
	 // request.getRequestDispatcher("/common/left.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
