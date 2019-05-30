<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:set  로그인 후  테스트 </h2>
	<!-- var : 속성명, value : 값, scope : page(default), request, application -->
<%-- 	<%
		UserVo USER_INFO = (UserVo)session.getAttribute("USER_INFO");
		pageContext.setAttribute("userId", USER_INFO.getAlias());
	%> --%>
	<c:set var="userId" value="${USER_INFO.alias }" scope="request"/>
	userId : ${userId } <br>
	requestScope.userId : ${requestScope.userId } <br>
	
<%-- 	<!-- target 대상 속성, property : 대상 속성의 필드, value : 대입값 -->
	<c:set target="${USER_INFO }" property="alias" value="bear"/> --%>
	USER_INFO.alias : ${USER_INFO.alias } <br>
	
	<h2>c:if *** c:if는 java의 if-else if - else 중에서 if에만 해당 (c:choose 태그가 일반적인 if문)</h2>
	
	
	<%
	request.setAttribute("code", "03");
	
	%>
	
	<c:choose>
	<c:when test="${code=='01'} }"> code is 01</c:when>
	<c:when test="${code=='02'} }"> code is 02</c:when>
	<c:when test="${code=='03'} }"> code is 03</c:when>

	<c:otherwise>code is ${code}</c:otherwise>
	
	</c:choose>
	
	
	<h2></h2>
	
	<%
	
	PageVo pageVo = new PageVo (1,10);
	request.setAttribute("pageVo", pageVo);
	%>
	
	page+32: ${pageVo.page+2} 
	
	
	
	
	
	
	
<%-- 	<c:if test="${USER_INFO.userId =='brown'}">
		userId는 brown 입니다.
	</c:if>
	<c:if test="${USER_INFO.userId =='sally'}">
		userId는 sally 입니다.
	</c:if> --%>
	
	
</body>
</html>