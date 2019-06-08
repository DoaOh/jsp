package kr.or.ddit.user.Controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.PostService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/postForm")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class postFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(postFormController.class);
   
	private IPostService postService;
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		postService= new PostService();
		
	}

	
	//사용자 등록 화면 요청 처리 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String boardid= request.getParameter("boardid");
		logger.debug("boardid {} ",boardid);
		request.setAttribute("boardid", boardid);
	
	//사용자 등록 화면으로 이동 
	request.getRequestDispatcher("/user/postForm.jsp").forward(request, response);

	}


	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	//request.getRequestDispatcher("/user/postForm.jsp").forward(request, response);

	request.setCharacterEncoding("utf-8");

	HttpSession session =request.getSession();
	String userid=(String) request.getSession().getAttribute("USERID");
	
	String posttitle= request.getParameter("posttitle");
	String postcontent= request.getParameter("postcontent");
	String boardid= request.getParameter("boardid");
	String postid = "";
	String postid2 =request.getParameter("postid");

	logger.debug("userid {} ",userid);
	logger.debug("posttitle {} ",posttitle);
	logger.debug("postcontent {} ",postcontent);
	logger.debug("boardid {} ",boardid);
	logger.debug("postid2 {} ",postid2);
	
	
	
	JSPPostVo JSPPostVo=null;
	JSPPostVo = new JSPPostVo(postid, userid,  posttitle, postcontent, postid2,  boardid);
	
	// 게시판이 존재  --> 정상입력가능
		if(boardid != null){
			
			
	/*		Part profile = request.getPart("profile");
			
			// 사용자가 파일을 업로드 한 경우
			if(profile.getSize() > 0){
				// 실제파일명
				String contentDisposition = profile.getHeader("content-disposition");
				String filename = PartUtil.getFileName(contentDisposition);
				String ext = PartUtil.getExt(filename);
				ext = ext.equals("") ? "" : "." + ext;
				
				String uploadPath = PartUtil.getUploadPath();
				File uploadFolder = new File(uploadPath);
				if (uploadFolder.exists()) {

					// 파일 디스크에 쓰기
					String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
					userVo.setPath(filePath);
					userVo.setFilename(filename);
					profile.write(filePath);
					profile.delete();
				}
				
			}
			
			
			*/
			int insertCnt = postService.insertPost2(JSPPostVo);
			if(insertCnt == 1){
				response.sendRedirect(request.getContextPath()+"/content?boardid="+boardid);
				//response.sendRedirect(request.getContextPath()+"/login");
			
			}
		}
		// 게시판이 없다면 
		else{
			response.sendRedirect(request.getContextPath()+"/login");
		}
}

}