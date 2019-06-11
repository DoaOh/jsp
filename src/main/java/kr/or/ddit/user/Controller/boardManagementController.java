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
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/boardManagement")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class boardManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(boardManagementController.class);
   
	private IBoardService boardService;
	
	
	
	@Override
	public void init() throws ServletException {
		boardService= new BoardService();
		
	}

	
	//사용자 등록 화면 요청 처리 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		
	//사용자 등록 화면으로 이동 
	request.getRequestDispatcher("/user/BoardManagement.jsp").forward(request, response);

	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
		
			int insertCnt = boardService.insertBoard(JSPBoardVo);
			// 정상등록
			if(insertCnt == 1){
				response.sendRedirect(request.getContextPath()+"/boardList");
		}else{
			
			response.sendRedirect(request.getContextPath()+"/login");
		}
}

}