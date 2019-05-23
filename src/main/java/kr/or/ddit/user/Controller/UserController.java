package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;


@WebServlet("/userList")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IuserService userService;
       
    

	@Override
	public void init() throws ServletException {
		userService=new UserService();
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//user객체를 userList.jsp에서 참고할수 있도록 request에 넣어준다

		request.setAttribute("userList", userService.userList());
		
		//userList객체룰 이용하여 사용자 화면생성
		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
