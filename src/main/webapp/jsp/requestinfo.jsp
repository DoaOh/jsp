<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 스크립틀릿<% %> 자바로직을 작성하는 공간 --%>
<%-- 표현식 <%= %> 결과물을 출력 --%>

<%

String msg ="test";
 msg +="_append";
 
 //jsp의 내장객체 묵시적 객체 (implict) 이미 선언되었다 때문에 병도의 선언없이 사용가능한 객체의 하나 
 //사용가능한 객체의 하나 
 
%>

 request.getRemoteAddr() :<%=request.getRemoteAddr()%><br>
 request.getLocalAddr() :<%=request.getLocalAddr()%><br>
 request.getContentType() :<%=request.getContentType()%><br>
 request.getContextPath() :<%=request.getContextPath()%><br>
 request.getMethod() :<%=request.getMethod()%><br>
 request.getRequestURI() :<%=request.getRequestURI()%><br>
 request.getProtocol :<%=request.getProtocol()%><br>
 
 <img src="/jsp/image/sally.png">
 

</body>
</html>