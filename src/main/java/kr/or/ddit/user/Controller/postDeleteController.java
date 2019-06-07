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

@WebServlet("/postDelete")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class postDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(postDeleteController.class);
	private IPostService postService;
	

	@Override
	public void init() throws ServletException {
		postService= new PostService();
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
     		logger.debug( " doget"  );
		 String postid = request.getParameter("postid");
		 logger.debug("왜안되는걸까{}",postid); 
		 
		 int deleteCnt = postService.deletePost(postid);
			
		logger.debug("updateCnt{}",deleteCnt);

			//정상등록
			if(deleteCnt == 1){
				response.sendRedirect(request.getContextPath()+"/postServlet");
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
				
			}

		 
		 
		
		
	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		
/*		logger.debug( " dopost"  );
		
		
		 String postid = request.getParameter("postid");
		 logger.debug("postidpostidpostid{}",postid);
		
		int deleteCnt = postService.deletePost(postid);
			
			logger.debug("updateCnt{}",deleteCnt);

			//정상등록
			if(deleteCnt == 1){
				response.sendRedirect(request.getContextPath()+"/postServlet");
			}else{
				response.sendRedirect(request.getContextPath()+"/login");
				
			}
*/
		

	}
}
