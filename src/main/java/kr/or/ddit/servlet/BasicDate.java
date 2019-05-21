package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicDate extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		resp.setContentType("text/html charset-utf-8");
		
		PrintWriter pw= resp.getWriter();
	
		//localhost/jsp/timesTable?param=6
		
	String param=req.getParameter("param");
	System.out.println("param"+param);
		
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<title>hello,world</title>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<span>hello,world</span>");
		pw.write("<br>");
		pw.write("<br>");
		pw.write("<br>");
		pw.write("</body>");
		pw.write("</html>");
		pw.write("hello,world");
		
		pw.write("  ");
		pw.write("  ");
		pw.write("  ");
		
		pw.close();
	}

}
