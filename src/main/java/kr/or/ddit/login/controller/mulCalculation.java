package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/mulcal")
public class mulCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(mulCalculation.class);
	
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("값값값값 {}",  request.getParameter("para1"));
		logger.debug("값값값값"+request.getParameter("para2"));

		
		
		int a = Integer.parseInt(request.getParameter("para1"));
		int b =Integer.parseInt(request.getParameter("para2"));
		
		
		if(a>b){logger.debug("para1이 para2보다 크다");}
		
		int z = a*b;

		
		
	
		
		
		
		/*request.getParameter("start");
		request.getParameter("end");
*/
		request.getSession().setAttribute("mulmul",z);
		

		request.getRequestDispatcher("/Context_path/jsp/mulResult.jsp").forward(request, response);



		
		
	}

}