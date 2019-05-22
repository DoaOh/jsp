<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	out.write("pageContext  "+pageContext.getOut().equals(out)+"<br>"+"<br>");
	
	out.write("getPage  "+pageContext.getPage().equals(page)+"<br>"+"<br>");
	
	out.write("getRequest "+pageContext.getRequest().equals(request)+"<br>"+"<br>");
	
	out.write("getSession  "+pageContext.getSession().equals(session)+"<br>"+"<br>");
	
	out.write("getServletContext  "+pageContext.getServletContext().equals(application)+"<br>"+"<br>");
	
	out.write("getResponse "+pageContext.getResponse().equals(response)+"<br>"+"<br>");
	

	

	%>

</body>
</html>