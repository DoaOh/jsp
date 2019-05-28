package kr.or.ddit.user.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.ILprodService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.LprodService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class userPaginfListController
 */
@WebServlet("/LprodPagingList")
public class LprodPagingListController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingListController.class);
	
	private ILprodService lprodService;
	
	
	private static final long serialVersionUID = 1L; 
	
	
	
	
    
	@Override
	public void init() throws ServletException {
		
		lprodService=new LprodService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//user객체를 userList.jsp에서 참고할수 있도록 request에 넣어준다

		 //PageVo pageVo= new PageVo();
		
		String pagee =request.getParameter("page");
		String pageSizee =request.getParameter("pageSize");
		
		 logger.debug("pagee{}",pagee);
		 logger.debug("pageSizee{}",pageSizee);
		
		 
	     /* if (pagee==""||pageSizee==""){
	    	  pagee = "1"; 
	    	  pageSizee = "10";
		}*/
		
	
		int page = pagee==null?1:Integer.parseInt(pagee);
			int pageSize = pageSizee==null?5:Integer.parseInt(pageSizee);
		
	
	/*	  int page = Integer.parseInt(pagee);
	      int pageSize = Integer.parseInt(pageSizee);
	      */
	      
		 /* int page = Integer.parseInt(request.getParameter("page"));
	      int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	      
	      if (page==0||pageSize==0){
	    	  page = 1; 
	    	  pageSize = 10;
		}*/
		
	      
	      PageVo pageVo= new PageVo(page,pageSize);
	      
	      Map<String, Object> resultMap =lprodService.lprodPagingList(pageVo);
		  List<LprodVo> lprodList= (List<LprodVo>) resultMap.get("lprodList");
		  int paginationSize = (Integer)resultMap.get("paginationSize");
		 
			
		request.setAttribute("lprodPagingList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
				
				//userList객체룰 이용하여 사용자 화면생성
		request.getRequestDispatcher("/user/lprodPageList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
