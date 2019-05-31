package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class gugujstl extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(gugujstl.class);
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		resp.setContentType("text/html charset-utf-8");
		
	

	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		int a = Integer.parseInt(request.getParameter("para1"));
		int b =Integer.parseInt(request.getParameter("para2"));
		
		   
		
        request.getSession().setAttribute("par1",a);
        request.getSession().setAttribute("par2",b);
		

		request.getRequestDispatcher("/jsp/timesTableJSTL.jsp").forward(request, response);



		
		
	}

	

}
