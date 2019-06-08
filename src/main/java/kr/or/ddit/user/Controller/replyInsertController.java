package kr.or.ddit.user.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.JSPReplyVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.IReplyService;
import kr.or.ddit.user.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/replyinsert")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class replyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(replyInsertController.class);
   
	private IReplyService replyService;
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		replyService= new ReplyService();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");

	HttpSession session =request.getSession();
	String userid=(String) request.getSession().getAttribute("USERID");
	
	
	String postid= request.getParameter("postid");
	String reply= request.getParameter("reply");



	
	logger.debug("userid코멘틐꺼 {} ",userid);
	logger.debug("postid코멘틐꺼 {} ",postid);
	logger.debug("reply코멘틐꺼 {} ",reply);
	
	
	
	 JSPReplyVo JSPReplyVo=null;
	 JSPReplyVo = new JSPReplyVo( postid, reply, userid);
	
	
	
		if(postid != null){
			
			int insertCnt = replyService.insertReply(JSPReplyVo);
		
			if(insertCnt == 1){
				response.sendRedirect(request.getContextPath()+"/post?postId="+postid);
			}
		}
	
		else{
			response.sendRedirect(request.getContextPath()+"/postServlet");
		}
}

}