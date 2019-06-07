package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.dao.IReplyDao;
import kr.or.ddit.user.dao.ReplyDao;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.JSPReplyVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.IReplyService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.PostService;
import kr.or.ddit.user.service.ReplyService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/post")
public class postController extends HttpServlet {
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(postController.class);
	
	
	private static final long serialVersionUID = 1L;
	
	
	private IPostService postService;
	private IReplyService replyService;
       
	
	
	@Override
	public void init() throws ServletException {
		postService= new PostService();
		replyService = new ReplyService();
	}

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String postid = request.getParameter("postId");
		logger.debug("postid {}" , postid);
		JSPPostVo postVo = postService.getPost(postid);
		List<JSPReplyVo> replyVo = replyService.replyList(postid);
		
		//조회 결과를 request 객체에 속성으로 저장 
		request.setAttribute("post",postVo );
		request.setAttribute("reply",replyVo );
		
		request.getRequestDispatcher("/user/post.jsp").forward(request, response);
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
