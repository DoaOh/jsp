package kr.or.ddit.user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.PostService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/post")
public class postController extends HttpServlet {
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(postController.class);
	
	
	private static final long serialVersionUID = 1L;
	
	
	private IPostService postService;
       
	
	
	@Override
	public void init() throws ServletException {
		postService= new PostService();
	}

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String postid = request.getParameter("postId");
		logger.debug("postid {}" , postid);
		
	 JSPPostVo postVo = postService.getPost(postid);
		
		//조회 결과를 request 객체에 속성으로 저장 
		request.setAttribute("post",postVo );
	
		
		request.getRequestDispatcher("/user/post.jsp").forward(request, response);
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
