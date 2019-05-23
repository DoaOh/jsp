<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>SUM</h2>

<form action="<%=request.getContextPath()%>/sumCalculation" method="post">


<input type="text" name="start">
<input type="text" name="end">

<button>보내기</button>

</form>


</body>
</html>