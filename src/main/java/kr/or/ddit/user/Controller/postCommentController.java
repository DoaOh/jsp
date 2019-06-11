package kr.or.ddit.user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/postComment")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class postCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(postCommentController.class);
   
	private IPostService postService;
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		postService= new PostService();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String boardid =request.getParameter("boardid");
		String postid =request.getParameter("postid");
		logger.debug("boardid {} ",boardid);
		logger.debug("postid2 {} ",postid);
		
		JSPPostVo postVo = postService.getPost(postid);
	    request.setAttribute("post",postVo );

	request.getRequestDispatcher("/user/postCommentForm.jsp").forward(request, response);

	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");

	HttpSession session =request.getSession();
	String userid=(String) request.getSession().getAttribute("USERID");
	
	
	String posttitle= request.getParameter("posttitle");
	String postcontent= request.getParameter("postcontent");
	String boardid= request.getParameter("boardid");
	String postid2 =request.getParameter("postid");
	
	String postid = "";
	JSPPostVo postVo2 = postService.getPost(request.getParameter("postid"));
	String group_seq= postVo2.getGroup_seq();
	


	logger.debug("userid코멘틐꺼 {} ",session);
	logger.debug("posttitle코멘틐꺼 {} ",posttitle);
	logger.debug("postcontent코멘틐꺼 {} ",postcontent);
	logger.debug("boardid 코멘틐꺼{} ",boardid);
	logger.debug("postid2 코멘틐꺼 {} ",postid2);
	
	
	
	 JSPPostVo JSPPostVo=null;
	JSPPostVo = new JSPPostVo(postid, userid,  posttitle, postcontent, postid2,  boardid,group_seq);
	
	
	
		if(boardid != null){
			
			
			int insertCnt = postService.insertPost(JSPPostVo);

			// 정상등록
			if(insertCnt == 1){
				response.sendRedirect(request.getContextPath()+"/content?boardid="+boardid);
			}
		}
		// 게시판이 없다면 
		else{
			request.setAttribute("msg", "존재하지 않는 게시판.");
			doGet(request,response);
		}
}

}