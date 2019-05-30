package kr.or.ddit.user.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class profileController
 */
@WebServlet("/profile")
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	private IuserService userService;
       
	
	
	@Override
	public void init() throws ServletException {
		userService =new UserService();
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자 아이디를 파라미터로 부터 확인 
String userId = request.getParameter("userId");
		
		
      // 사용자 정보를 조회 
		UserVo userIddb = userService.getUser(userId);
		
		UserVo userVo = userService.getUser(userId);
		
		ServletOutputStream sos=  response.getOutputStream();
		
		
		
		
		File file = new File(userVo.getPath());
	
		FileInputStream fis = new FileInputStream(file);
		
		int len=0;
		
		byte[] buffer = new byte[512];
		
		
		while((len = fis.read(buffer ,0 ,512)) !=-1){
			sos.write(buffer);
		}
		 
		fis.close();
		sos.close();
		
		
		
		
		
	
		//PATH 정보로  file을 읽어 들여서 
		//response 객체에 스트림으로 써준다 
		
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}