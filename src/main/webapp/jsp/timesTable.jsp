<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- localhost/jsp/jsp/timesTable.jsp -->


<% String param1 = request.getParameter("param1"); %>
<% String param2 = request.getParameter("param2"); %>

<table border='1'>



<% for (int i = 1; i <=Integer.parseInt(param1); i++){%>
<tr>
<%for (int j = 2; j <=Integer.parseInt(param2); j++){ %>
<td>
<%=j+"*"+i +"="+i*j%>
<%} %>
</td>
</tr>
<%}%>
</table>

</body>
</html>