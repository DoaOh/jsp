package kr.or.ddit.user.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.user.service.FileService;
import kr.or.ddit.user.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/fileDelete")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class fileDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(fileDeleteController.class);
	
	private IFileService fileService;
	

	@Override
	public void init() throws ServletException {
		fileService = new FileService();
	}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		
     		logger.debug( " doget"  );
		 String fileid = request.getParameter("fileid");
		 String postId = request.getParameter("postid");
		 
		 logger.debug("왜안되는걸까{}",fileid); 
		 
		 int deleteCnt = fileService.deleteFile(fileid);
			
		logger.debug("deleteCnt{}",deleteCnt);

		
		
		
			//정상등록
			if(deleteCnt == 1){
				
				
			response.sendRedirect(request.getContextPath()+"/postModify?postId="+postId);
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
