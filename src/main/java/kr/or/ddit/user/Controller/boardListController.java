package kr.or.ddit.user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;



@WebServlet("/boardList")
public class boardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService boardService;
       
    

	@Override
	public void init() throws ServletException {
		boardService=new BoardService();
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setAttribute("boardAllList", boardService.boardALLList());
		//boardList이용하여 사용자 화면만들어주기
		request.getRequestDispatcher("/user/BoardList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
