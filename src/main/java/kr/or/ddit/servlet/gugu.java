package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class gugu extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		resp.setContentType("text/html charset-utf-8");
		
		PrintWriter pw= resp.getWriter();
		
		//localhost/jsp/timesTable?param=6
		
		String param=req.getParameter("i");
		System.out.println("param"+param);
		String param2=req.getParameter("j");
		System.out.println("param2"+param2);

		pw.write("<html>");
		pw.write("<head>");
		pw.write("<title>hello,world</title>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<table border='1'>");
		
	
		for (int i = 2; i <=Integer.parseInt(param2); i++) {
			pw.write("<tr>");
			for (int j = 2; j <=Integer.parseInt(param); j++) {
				
			pw.write("<td border='1px solid pink'>"+ j+"*"+i +"="+i*j+"</td>");
			}
			pw.write("</tr>");
			}
	
		
		
		pw.write("<table>");
		pw.write("</body>");
		pw.write("</html>");
		pw.write("hello,world");
		
		pw.write("  ");
		pw.write("  ");
		pw.write("  ");
		
		pw.close();
	}

}
