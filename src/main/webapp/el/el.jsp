<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


userId : ${userId}<br>

requestScope:${requestScope.userId}<br>
sessionScope:${sessionScope.userId}<br>


<%//session.removeAttribute("userId");%>

<h2>el로 파라미터 접근 </h2>
param : ${ param.userId}<br>

</body>
</html>