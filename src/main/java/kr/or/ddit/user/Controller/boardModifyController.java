package kr.or.ddit.user.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.JSPBoardVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/boardModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class boardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(boardModifyController.class);
	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		boardService=new BoardService();
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		 String boardid = request.getParameter("boardid");
		 
		 logger.debug("modify boardid {}",boardid);

		 JSPBoardVo JSPBoardVo = boardService.getBoard(boardid);

		 request.setAttribute("BOARD",JSPBoardVo);
	
		request.getRequestDispatcher("/user/BoardModify.jsp").forward(request,
				response);

	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		
		HttpSession session =request.getSession();
		String userid=(String) request.getSession().getAttribute("USERID");
		logger.debug(userid);
		
		String boardname= request.getParameter("boardname");
		String boarduse_yn = request.getParameter("boarduse_yn");
		String boardid = "";
		logger.debug("boardname {} ",boardname);
		logger.debug("boarduse_yn {} ",boarduse_yn);
		
		JSPBoardVo JSPBoardVo=null;
		JSPBoardVo = new JSPBoardVo(boardid, boardname,boarduse_yn, userid);
		
			int updateCnt = boardService.updateBoard(JSPBoardVo);
			
			logger.debug("updateCnt{}",updateCnt);

			//정상등록
			if(updateCnt == 1){
				response.sendRedirect(request.getContextPath()+"/boardList");
			}else{
				request.setAttribute("msg", "실패.");
				
			}

		

	}
}
