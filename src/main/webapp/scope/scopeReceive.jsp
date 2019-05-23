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
//로지만처리함
//4가지 파라미터를 받아서 4가지 영역에 속성으로 넣어준다
//속성저장  scope 객체 setAttribute (속성명 속성 객체 );
//scope객체   page  request session application


pageContext.setAttribute("pageAttribute",request.getParameter("pageParam"));
request.setAttribute("requestAttribute",request.getParameter("requestParam"));
session.setAttribute("sessionAttribute",request.getParameter("sessionParam"));
application.setAttribute("applicationAttribute",request.getParameter("applicationParam"));


request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);




%>

</body>
</html>