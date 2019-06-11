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
import kr.or.ddit.user.model.JSPPostVo;
import kr.or.ddit.user.service.IPostService;
import kr.or.ddit.user.service.PostService;



@WebServlet("/postServlet")
public class postServletController extends HttpServlet {
	
	
	private IPostService  postService;
	
	private static final long serialVersionUID = 1L; 
	
	
    
	@Override
	public void init() throws ServletException {
		
		postService = new PostService();
			
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pagee =request.getParameter("page");
		String pageSizee =request.getParameter("pageSize");
		
	
	
		int page = pagee==null?1:Integer.parseInt(pagee);
		int pageSize = pageSizee==null?10:Integer.parseInt(pageSizee);
		
	
	      
	     PageVo pageVo= new PageVo(page,pageSize);
	      
	     Map<String, Object> resultMap =postService.postPagingList(pageVo);
		 List<JSPPostVo> postList= (List<JSPPostVo>) resultMap.get("postList");
		 int paginationSize = (Integer)resultMap.get("paginationSize");
		 
			
		request.setAttribute("postPagingList", postList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/user/postPageList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
