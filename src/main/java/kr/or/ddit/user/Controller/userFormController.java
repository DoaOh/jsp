package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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


@WebServlet("/userForm")
public class userFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(userFormController.class);
   
	private IuserService userService;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		userService = new UserService();
	}

	
	//사용자 등록 화면 요청 처리 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//사용자 등록 화면으로 이동 
	request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);

	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	logger.debug("userForm doPost");
	
	
	
	request.setCharacterEncoding("utf-8");
	
	//사용자가 보낸 파라미터를 통해 UserVo 인스턴스를 만들어서 
	String name= request.getParameter("userNm");
	String userId= request.getParameter("userId");
	String alias= request.getParameter("userAlias");
	String addr1= request.getParameter("userAddr1");
	String addr2 =request.getParameter("userAddr2");
	String zipcd= request.getParameter("userZipcd");
	String pass =request.getParameter("userPass");
	String birth= request.getParameter("userBirth");
	

	

	 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
	 UserVo userVo=null;
	try {
		
		 userVo = new UserVo(name,userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	
	// 사용자가 입력한 아이디가 이미 존재하는 아이디인지 체크 
	UserVo dbUser = userService.getUser(userId);
	
	//존재하지 않은 경우
	if(dbUser==null){
		int insertCnt = userService.insertUser(userVo);
		if(insertCnt==1){
			response.sendRedirect(request.getContextPath()+"/userPagingList");
		}
	}else{
		//존재하는경우 
		//사용자 등록 페이지로 이동 사용자가 입력한 값을 input에 넣어준다 
		// 이미 존재하는 userId입니다  alert로 표시 
		

		//request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		request.setAttribute("msg","이미 존재하는 사용자 입니다 ");
		doGet(request, response);
		
		
	}
	
	//UserService 객체를통해 insertUser(uservo)
	
	//정상적으로 입력이 된경우 
	//사용자 페이징 리스트 1페이지로 이동 

	
	//정상적으로 입력이 되지 않은경우 
	//사용자 등ㄹ고 페이지로 이동 사용가가 입력한 값들을 input
	
	

	}

}
