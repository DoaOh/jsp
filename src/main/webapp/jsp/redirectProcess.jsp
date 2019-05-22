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
	//sendRedirect 메소드 인자값을 웹브라우저가 수신한 후에 주소줄에 그대로 붙여넣음
	System.out.println("userid Parameter"+request.getParameter("userId"));
	response.sendRedirect(request.getContextPath()+"/jsp/redirectTarget.jsp?userId=brown");
	//jsp/jsp/redirectTarget.jsp
	%>


</body>
</html>