<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	response.setHeader("content-Disposition","attachment; filename=line.xls");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		
		<tr>
			<td>샐리</td>
			<td>SALLy</td>
		</tr>
		
		<tr>
			<td>브라운</td>
			<td>brown</td>
		</tr>
		
		<tr>
			<td>샐제임스</td>
			<td>james</td>
		</tr>


	</table>


</body>
</html>