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


@WebServlet("/userModify")
public class userModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(userModifyController.class);
   
	private IuserService userService;
	
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	
	//사용자 등록 화면 요청 처리 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 객체로 부터 사용자 아이디 파라미터 획득
        String userId = request.getParameter("userId");
		
		UserVo db = userService.getUser(userId);
		
		request.setAttribute("userinfo", db);
		
	
		
		//사용자 등록 화면으로 이동 
	
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	
	
	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		
		request.setCharacterEncoding("utf-8");
		 
		String name= request.getParameter("userNm");
		String userId= request.getParameter("userId");
		String alias= request.getParameter("userAlias");
		String addr1= request.getParameter("userAddr1");
		String addr2 =request.getParameter("userAddr2");
		String zipcd= request.getParameter("userZipcd");
		String pass =request.getParameter("userPass");
		String birth= request.getParameter(
				"userBirth");
		
		
		logger.debug("aa{}", name);
		logger.debug("aa{}", userId);
		logger.debug("aa{}", alias);
		logger.debug("aa{}", addr2);
		logger.debug("aa{}", name);
		logger.debug("aa{}", zipcd);
		logger.debug("aa{}", pass);
		logger.debug("aa{}", birth);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
		
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UserVo dbUser = userService.getUser(userId);
		
		if(dbUser != null){
			int updateCnt = userService.updateUser(userVo);
			
			if(updateCnt == 1){
			response.sendRedirect(request.getContextPath()+"/userPagingList");
			}
			request.setAttribute("msg", "수정완료.");
		}	
	}
}
