<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello, world
<%-- --%>

<%-- <% %> 자바코드를 작성하는 영역 --%>
<%Date date= new Date();%>

<%-- <%= %> 표현식 객체를 표현 --%>
현재시간 <%=date %> 입니다


</body>
</html>