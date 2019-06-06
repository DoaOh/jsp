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
import kr.or.ddit.user.service.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/boardModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class boardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(boardModifyController.class);

	private IPostService postService;
	

	@Override
	public void init() throws ServletException {
		postService= new PostService();
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug( " doget"  );
	
		 String postid = request.getParameter("postId");
		 
		 logger.debug("modify postid {}",postid);

		 JSPPostVo postVo = postService.getPost(postid);

		 request.setAttribute("post",postVo );

		

		request.getRequestDispatcher("/user/boardModify.jsp").forward(request,
				response);

	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		
		String posttitle= request.getParameter("posttitle");
		String postcontent= request.getParameter("postcontent");
		String boardid= request.getParameter("boardid");
		String postid = request.getParameter("postId");
		String postid2 = "80001";
		String userid= request.getParameter("userid");
		
		logger.debug("modify postid {}",postid);
		logger.debug("posttitle {} ",posttitle);
		logger.debug("postcontent {} ",postcontent);
		logger.debug("boardid {} ",boardid);
		logger.debug("userid {} ",userid);
		
		JSPPostVo JSPPostVo=null;
		JSPPostVo = new JSPPostVo(postid, userid, posttitle, postcontent, postid2,  boardid);
		
			int updateCnt = postService.updatePost(JSPPostVo);
			
			logger.debug("updateCnt{}",updateCnt);

			//정상등록
			if(updateCnt == 1){
				response.sendRedirect(request.getContextPath()+"/boardList");
			}else{
				request.setAttribute("msg", "실패.");
				
			}

		

	}
}
