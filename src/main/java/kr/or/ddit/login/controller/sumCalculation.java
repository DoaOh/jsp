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
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(sumCalculation.class);
	
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("값값값값 {}",  request.getParameter("start"));
		logger.debug("값값값값"+request.getParameter("end"));

		
		
		int a = Integer.parseInt(request.getParameter("start"));
		int b =Integer.parseInt(request.getParameter("end"));
		
		int z = 0;

		if(a>b){logger.debug("start가 end보다 크다");}
		
		for (int i = a; i <= b; i++) {
			
			z+=i;
		}
		
	
		
		
		
		/*request.getParameter("start");
		request.getParameter("end");
*/
		request.getSession().setAttribute("sumsum",z);
		

		request.getRequestDispatcher("/Context_path/jsp/sumResult.jsp").forward(request, response);



		
		
	}

}