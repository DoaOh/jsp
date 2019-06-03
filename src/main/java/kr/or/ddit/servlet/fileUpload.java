package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.apache.catalina.ha.backend.CollectedInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class fileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(fileUpload.class);
  
	
	//파일업로드는 post방식만 가능하다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//userId  profile 파라미터를 확인
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");
		
	
	
		logger.debug("userId{}  ",userId);
		logger.debug("profile{}  ",profile);
		
		
		Part part = request.getPart("profile");
		logger.debug("part.getSize {} " ,part.getSize());
		
		
		//파일이 존재할때만 파일을 정해진 위치에 기록한다
		
		if(part.getSize()>0){

			/*	part.getName()
				part.getContentType()*/
			
			logger.debug("getName  {}  ",	part.getName());
			logger.debug("getContentType  {}  ",	part.getContentType());
		
			
		/*	Collection<String> headerNames = part.getHeaderNames();
			for(String header : headerNames){
				logger.debug("{}: {} ", header, part.getHeaders(header));
			}*/
			
			String contentDisposition= part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);
			 ext = ext.equals("")? "":"."+ext;
			
			 
			 //년도에 해당하는 폴더가 있는지 년도안에 월에해당하는 폴더가 있는지
			 
			 Date dt= new Date(); 
			 SimpleDateFormat yyyymmsdf = new SimpleDateFormat("yyyy");
			
			 String yyyyMM = yyyymmsdf.format(dt);
			
			 String yyyy = yyyyMM.substring(0,4);
			String mm = yyyyMM.substring(4,6);
				
			 
			 File yyyyFolder = new File("d:\\upload\\2019");
			 if(!yyyyFolder.exists()){
				 
				 yyyyFolder.mkdir();
			 }
			 
			 File mmFolder = new  File("d:\\upload\\2019||06");
			 if(!mmFolder.exists()){
				 
				 mmFolder.mkdir();
				 
			 }
			 
			
			 String uploadPath= "d:\\upload\\"+yyyy+"\\"+mm;
			 File uploadFolder = new File(uploadPath);
			 if(uploadFolder.exists()){
				 
				 
				 //파일디스크에 쓰기
				 part.write(uploadPath+"\\"+UUID.randomUUID().toString()+ext);
				 part.delete();
				 
			 }
			
		}
		
		
	}

}
