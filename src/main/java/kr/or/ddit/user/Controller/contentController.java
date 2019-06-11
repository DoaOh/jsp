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
import kr.or.ddit.paging.model.BPageVo;
import kr.or.ddit.user.model.JSPBoardVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;



@WebServlet("/content")
public class contentController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(contentController.class);
	
	private IPostService  postService;
	private IBoardService  boardService;
	private static final long serialVersionUID = 1L; 

	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
		boardService = new BoardService();
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String boardid =request.getParameter("boardid");
		JSPBoardVo boardvo =boardService.getBoard(boardid);
		String boardname =boardvo.getBoardname();
		
		
	
		logger.debug("content boardid {}", boardid );
		logger.debug("content boardid {}", boardname );
		
		String pagee =request.getParameter("page");
		String pageSizee =request.getParameter("pageSize");
		int page = pagee==null?1:Integer.parseInt(pagee);
		int pageSize = pageSizee==null?10:Integer.parseInt(pageSizee);
		BPageVo BpageVo= new BPageVo(page,pageSize,boardid);
	    Map<String, Object> resultMap =postService.boardPostPagingList(BpageVo);
		List<JSPPostVo> boardPostList= (List<JSPPostVo>)resultMap.get("boardPostList");
		
		 
		 
		int paginationSize = (Integer)resultMap.get("paginationSize");
		request.setAttribute("boardid", boardid);
		request.setAttribute("boardname", boardname);
		request.setAttribute("boardPostList", boardPostList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("BPageVo", BpageVo);
		
		request.getRequestDispatcher("/user/contentPageList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
