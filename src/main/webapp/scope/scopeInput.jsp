<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 190523 -->


	<h2>테스트</h2>
<form action="${pageContext.request.contextPath}/scope/scopeReceive.jsp" method="post">


	page   <input type="text" name="pageParam" value="pageValue"/><br>
	request<input type="text" name="requestParam" value="requestValue"/><br>
	session<input type="text" name="sessionParam" value="sessionValue"/><br>
	application<input type="text" name="applicationParam" value="applicationValue"/><br>
<button>전송하기</button>

</form>


</body>
</html>