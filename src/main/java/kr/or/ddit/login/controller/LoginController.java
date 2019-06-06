package kr.or.ddit.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.JSPBoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.BoardService;
import kr.or.ddit.user.service.IBoardService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private IuserService userService;

	private IBoardService  boardService;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.debug("loginController doGet()");
		UserVo SESSION_USER =(UserVo)request.getSession().getAttribute("USER_INFO");
		if(SESSION_USER!=null){
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
		
		
			boardService = new BoardService();
		
		userService=new UserService();
	}
	
	// 로그인 요청을 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		
		logger.debug("parameter userId :{}", request.getParameter("userId"));
		logger.debug("parameter password :{}", request.getParameter("password"));

		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		
		 request.setAttribute("userList", userService.userList());
		 logger.debug("userList :{}",  userService.userList());
		
		 UserVo userVo= userService.getUser(userId);
		 String a=userVo.getUserId();
		 String b=userVo.getPass();
		
		 

		logger.debug("userVogetUserId :{}", a);
		logger.debug("userVogetUserpass :{}", b);

		 

		// 일치
		if (userVo !=null && userId.equals(a) && password.equals(b)) {
			
			
			// session에 사용자 정보를 넣어준다 (사용빈도가 높기때문에)
			HttpSession session =request.getSession();
			session.setAttribute("USER_INFO",userVo );
			session.setAttribute("USERID",userId );
			
			
			List<JSPBoardVo> boardList= boardService.boardList();
			//session.setAttribute("BoardList", boardList);
			
			request.getServletContext().setAttribute("BoardList", boardList);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		}else{	
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			

		}
		
		
	}

}
