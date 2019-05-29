<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>c:set</h2>

 <!-- var 속성명 value 값 scope page(default) request session application -->
 
 <%
 UserVo USER_INFO =(UserVo)session.getAttribute("USER_INFO");
 pageContext.setAttribute("userId",USER_INFO.getAlias());
 
 %>
 
<c:set var="userId" value="${USER_INFO.alias }" scope="request"></c:set>
userId:${userId}<br>
requestScope ,userId:${requestScope.userId}<br>

<!--  target대상속성 property 대상고성의 필드 value 대입값 -->
<c:set target="${USER_INFO}" property="alias" value="bear"></c:set>
USER_INFO.alias : ${USER_INFO.alias }<br>


<h2></h2>

<c:if test="${user_INFO.userId == 'brown'}">
userId 는 brown입니다 
</c:if>


<c:if test="${user_INFO.userId == 'sally'}">
userId 는 sally입니다 
</c:if>

</body>
</html>