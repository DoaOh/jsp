package kr.or.ddit.user.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.IReplyService;
import kr.or.ddit.user.service.PostService;
import kr.or.ddit.user.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/replyDelete")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class replyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(replyDeleteController.class);
	private IReplyService replyService;
	

	@Override
	public void init() throws ServletException {
		replyService= new ReplyService();
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
     		logger.debug( " doget"  );
		 String replycode = request.getParameter("replycode");
		 String postId = request.getParameter("postid");
		 
		 logger.debug("왜안되는걸까{}",replycode); 
		 
		 int deleteCnt = replyService.deleteReply(replycode);
			
		logger.debug("updateCnt{}",deleteCnt);

		
		
		
			//정상등록
			if(deleteCnt == 1){
				response.sendRedirect(request.getContextPath()+"/post?postId="+postId);
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
				
			}

		 
		 
		
		
	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

	
		

	}
}
