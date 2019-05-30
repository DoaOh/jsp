package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/user")
public class userController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(userController.class);
	private static final long serialVersionUID = 1L;
	
	private IuserService userService;
       
	
	
	@Override
	public void init() throws ServletException {
		userService =new UserService();
	}

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//request 객체로 부터 사용자 아이디 파라미터 획득
		
		String userId = request.getParameter("userId");
		
		
		//사용자 아이디로 사용자 정보를 조회 
		UserVo userIddb = userService.getUser(userId);
		
		/*
		 String id =userIddb.getUserId();
		 String name =userIddb.getName();
		 String alias =userIddb.getAlias();
		 String addr =userIddb.getAddr1();
		 String addr2 =userIddb.getAddr2();
		 String zibcd =userIddb.getZipcd();
		 Date bir =userIddb.getBirth();*/
			
		
		//조회 결과를 request 객체에 속서응로 저장 

		request.setAttribute("userinfo",userIddb );
		
		
		//화면을 담당하는  /user/user.jsp
		
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
