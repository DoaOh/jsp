package kr.or.ddit.user.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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


@WebServlet("/postfile")
public class postfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(postfileController.class);
	
  private IFileService fileService;
       

  @Override
	public void init() throws ServletException {
		fileService =new FileService();
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("dogET");
	
		
		//사용자 아이디를 파라미터로 부터 확인 
		String postid = request.getParameter("postid");
		logger.debug("postid{}",postid);

		
	
       /*// 사용자 정보를 조회 
		List<JSPFileVo> filevo = fileService.FileList(postid);*/
		
		JSPFileVo jspfileVo = fileService.getFile(postid);
		logger.debug("filevo{}",jspfileVo);
		
		//path정보로 file을 읽어온다 
		ServletOutputStream sos=  response.getOutputStream();
		String filePath=null;
		FileInputStream fis = null;
		
		
		//사용자가 업로드한 파일이 존재할경우
		if(jspfileVo.getFilepath()!=null){
			filePath=jspfileVo.getFilepath();
		}
		//사용자가 업로드한 파일이 존재하지 않을경우
		else{
			filePath=getServletContext().getRealPath("image/noimg.PNG");
		}
		
		logger.debug("filevofilePathfilePathfilePath{}",filePath);
		File file = new File(filePath);
		fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		
		
		while( fis.read(buffer ,0 ,512) !=-1){
			sos.write(buffer);
		}
		
		
		fis.close();
		sos.close();
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
