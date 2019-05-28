package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginController
 */
/**
 * LoginController.java 로그인 처리 컨트롤러
 * 
 * @author PC02
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정자 수정내용
 * ------ ------------------------
 * PC02 최초 생성
 *
 * </pre>
 */
// web.xml.servlet-mapping java annotaion

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.debug("loginController doGet()");
		
		for(Cookie cookie : request.getCookies()){
			
			logger.debug("cookie : {}, {}",cookie.getName(),cookie.getValue());
		}
		// login 화면을 처리해줄 누국가에게 위임

		// 단순 login 화면을 html로 응답을 생성해주는 작업이 필요
		// login/login.jsp 위임 서버상에 별도의 상대변경을 가하ㅡㄴ 요청이 아니기 때문에 dispatch방식으로 위임
		
		
		
		//session에 사용자 정보가 있을경우 main화면으로 이동 
		
		
		//사용자 정보가 있을경우 기존로직사용
		
		
		//HttpSession session = request.getSession();
		
		UserVo SESSION_USER =(UserVo)request.getSession().getAttribute("USER_INFO");
		
		
		
		if(SESSION_USER!=null){
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}else{
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			
		}

	

	}

	// 로그인 요청을 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.debug("rememberme : {}",request.getParameter("rememberme"));
		
		
		
		
		logger.debug("parameter userId :()", request.getParameter("userId"));
		logger.debug("parameter password :()", request.getParameter("password"));

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		// 일치
		if (userId.equals("brown") && password.equals("brown1234")) {
			
			
			
			int cookieMaxAge=0;
			
			if(request.getParameter("rememberme")!=null){
				
				cookieMaxAge=60*60*24*30;
				
				Cookie userIdCookie = new Cookie("userid",userId);
				userIdCookie.setMaxAge(cookieMaxAge);
				
				Cookie rememberMeCookie = new Cookie("rememberme","true");
				rememberMeCookie.setMaxAge(cookieMaxAge);
				
				response.addCookie(userIdCookie);
				response.addCookie(rememberMeCookie);
			}
			//session에 사용자 정보를 넣어준다 사용빈도가 높기 때문에

			HttpSession session= request.getSession();
			session.setAttribute("USER_INFO", new UserVo("브라운","brown","곰"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);

			// 불일치
		} else {
			// forword 사용불가능
			// dispatch 방시으로 위임이 불가 GERT POST

			response.sendRedirect(request.getContextPath() + "/login");
		}

		// 사용자 파라미터
		// db에서 해당사용자의 정보조회(service dao)
		// 해당사용자의 정보를 ㅏㅣㄹ용하여 사용자가 보낸 파라미터가 일치하는지 검사

		// user brown passs brown1234 값일떄 통과 그의외값은 불일치임

	}

}
