package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		resp.setContentType("text/html charset-utf-8");
		
		PrintWriter pw= resp.getWriter();
		
		
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
		
	

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd-hh:mm:ss");
		pw.write(date.format(today));
		
		pw.close();
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	
	}


}
