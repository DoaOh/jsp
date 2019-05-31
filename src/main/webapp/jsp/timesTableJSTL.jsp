<%@page import="java.awt.print.Printable"%>
<%@page import="org.slf4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>





<% 


 
	int a = Integer.parseInt(request.getParameter("param1"));
	int b =Integer.parseInt(request.getParameter("param2"));
	
	
 

request.setAttribute("par1",a);
request.setAttribute("par2",b);


%>

	<c:set var="aaa" value="${par1}"></c:set>
	<c:out value="${aaa}" escapeXml="true"></c:out>

	<c:set var="aaa" value="${par2}"></c:set>
	<c:out value="${aaa}" escapeXml="true"></c:out>



<c:out value="구구단"></c:out>



<table border='1'>




<c:forEach  begin="1" end="${empty par1 ? 9 : par1}" var="i">
	<tr>
		<c:forEach begin="2" end="${par2}" var="j">		
		
			<td>${i} * ${j} =${i*j}</td>
		</c:forEach>
	</tr>
</c:forEach>


</table>

</body>
</html>