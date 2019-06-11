package kr.or.ddit.user.Controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import kr.or.ddit.user.model.JSPFileVo;
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.FileService;
import kr.or.ddit.user.service.IFileService;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;
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
	private IFileService fileService;
	
	@Override
	public void init() throws ServletException {
		postService= new PostService();
		fileService =new FileService();
		
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
	String group_seq ="";

	logger.debug("userid {} ",userid);
	logger.debug("posttitle {} ",posttitle);
	logger.debug("postcontent {} ",postcontent);
	logger.debug("boardid {} ",boardid);
	logger.debug("postid2 {} ",postid2);
	
	
	
	JSPPostVo JSPPostVo=null;
	JSPPostVo = new JSPPostVo(postid, userid,  posttitle, postcontent, postid2,  boardid ,group_seq);

	
	// 게시판이 존재  --> 정상입력가능
		if(boardid != null){
			int insertCnt = postService.insertPost2(JSPPostVo);
			//if(insertCnt == 1){}
		}
		else{ response.sendRedirect(request.getContextPath()+"/login");	}
		
		
				Part profile = request.getPart("profile");
				logger.debug("profile{}", profile);
				// 사용자가 파일을 업로드 한 경우
				if(profile.getSize() > 0){
					// 실제파일명
					String contentDisposition = profile.getHeader("content-disposition");
					String filename = PartUtil.getFileName(contentDisposition);
					String ext = PartUtil.getExt(filename);
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					if (uploadFolder.exists()) {
						// 파일 디스크에 쓰기
						JSPFileVo JSPFileVo = new JSPFileVo();
						String filepath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
						JSPFileVo.setFilepath(filepath);
						JSPFileVo.setFilename(filename);
						JSPFileVo = new JSPFileVo(postid,filepath,filename);
						int insertCnt=fileService.insertFile(JSPFileVo);
						profile.write(filepath);
						profile.delete();
					}
				}
				
				if(request.getPart("profile0")!=null){	
				Part profile0 = request.getPart("profile0");
				logger.debug("profile{}", profile);
				// 사용자가 파일을 업로드 한 경우
				if(profile.getSize() > 0){
					// 실제파일명
					String contentDisposition = profile.getHeader("content-disposition");
					String filename = PartUtil.getFileName(contentDisposition);
					String ext = PartUtil.getExt(filename);
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					if (uploadFolder.exists()) {
						// 파일 디스크에 쓰기
						JSPFileVo JSPFileVo = new JSPFileVo();
						String filepath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
						JSPFileVo.setFilepath(filepath);
						JSPFileVo.setFilename(filename);
						JSPFileVo = new JSPFileVo(postid,filepath,filename);
						int insertCnt=fileService.insertFile(JSPFileVo);
						profile0.write(filepath);
						profile0.delete();
					}
				}
				
	}
				
				if(request.getPart("profile1")!=null){
				Part profile1 = request.getPart("profile1");
				logger.debug("profile1{}", profile1);
				// 사용자가 파일을 업로드 한 경우
				if(profile1.getSize() > 0){
					// 실제파일명
					String contentDisposition = profile1.getHeader("content-disposition");
					String filename = PartUtil.getFileName(contentDisposition);
					String ext = PartUtil.getExt(filename);
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					if (uploadFolder.exists()) {
						// 파일 디스크에 쓰기
						JSPFileVo JSPFileVo = new JSPFileVo();
						String filepath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
						JSPFileVo.setFilepath(filepath);
						JSPFileVo.setFilename(filename);
						JSPFileVo = new JSPFileVo(postid,filepath,filename);
						int insertCnt=fileService.insertFile(JSPFileVo);
						profile1.write(filepath);
						profile1.delete();
					}
				}
	}
				
				
				if(request.getPart("profile2")!=null){	
				Part profile2 = request.getPart("profile2");
				logger.debug("profile{}", profile2);
				// 사용자가 파일을 업로드 한 경우
				if(profile2.getSize() > 0){
					// 실제파일명
					String contentDisposition = profile2.getHeader("content-disposition");
					String filename = PartUtil.getFileName(contentDisposition);
					String ext = PartUtil.getExt(filename);
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					if (uploadFolder.exists()) {
						// 파일 디스크에 쓰기
						JSPFileVo JSPFileVo = new JSPFileVo();
						String filepath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
						JSPFileVo.setFilepath(filepath);
						JSPFileVo.setFilename(filename);
						JSPFileVo = new JSPFileVo(postid,filepath,filename);
						int insertCnt=fileService.insertFile(JSPFileVo);
						profile2.write(filepath);
						profile2.delete();
					}
				}
	}
				
				if(request.getPart("profile3")!=null){
				
				Part profile3 = request.getPart("profile3");
				logger.debug("profile{}", profile3);
				// 사용자가 파일을 업로드 한 경우
				if(profile3.getSize() > 0){
					// 실제파일명
					String contentDisposition = profile3.getHeader("content-disposition");
					String filename = PartUtil.getFileName(contentDisposition);
					String ext = PartUtil.getExt(filename);
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					if (uploadFolder.exists()) {
						// 파일 디스크에 쓰기
						JSPFileVo JSPFileVo = new JSPFileVo();
						String filepath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
						JSPFileVo.setFilepath(filepath);
						JSPFileVo.setFilename(filename);
						JSPFileVo = new JSPFileVo(postid,filepath,filename);
						int insertCnt=fileService.insertFile(JSPFileVo);
						profile3.write(filepath);
						profile3.delete();
					}
				}
			}
	
			
			
			response.sendRedirect(request.getContextPath()+"/content?boardid="+boardid);

		
		
		
		

		
		
		
}

}