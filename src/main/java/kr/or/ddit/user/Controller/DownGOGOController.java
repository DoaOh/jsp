package kr.or.ddit.user.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kr.or.ddit.user.model.JSPFileVo;
import kr.or.ddit.user.service.FileService;
import kr.or.ddit.user.service.IFileService;


@WebServlet("/DownGOGO")
public class DownGOGOController extends HttpServlet {
	

	private IFileService fileService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(DownGOGOController.class);
	

	private static final long serialVersionUID = 1L;
       
 
	
	@Override
	public void init() throws ServletException {
		
		fileService = new FileService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String fileid = request.getParameter("fileid");
		logger.debug("postid {}" , fileid);
		JSPFileVo fileVo = fileService.FileDown(fileid);
		logger.debug("fileVo{}",fileVo);
		
		request.setAttribute("fileVo",fileVo );
		
		String filePath = fileVo.getFilepath();
		String fileName = fileVo.getFilename();
		
	
		// 서버에 올라간 경로를 가져옴
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("filefolder");
		
		System.out.println(" LOG [업로드된 파일 경로] :: " + uploadFilePath);
		System.out.println(" LOG [파일 전체 경로] :: " + filePath);
		
		byte[] b = new byte[4096];
		FileInputStream fileInputStream = new FileInputStream(filePath);
		
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		
        // 파일명 UTF-8로 인코딩(한글일 경우를 대비)
        String sEncoding = new String(fileName.getBytes("UTF-8"));
        response.setHeader("Content-Disposition", "attachment; fileName= " + sEncoding);
        
        // 파일 쓰기 OutputStream
        ServletOutputStream servletOutStream = response.getOutputStream();
        
        int read;
        while((read = fileInputStream.read(b,0,b.length))!= -1){
            servletOutStream.write(b,0,read);            
        }
        
        servletOutStream.flush();
        servletOutStream.close();
        fileInputStream.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
	}

}
