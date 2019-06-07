<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<style>

.BoardTr:hover{
cursor:pointer;
}
</style>



<title>전체 게시판 목록</title>

<!--css js-->
<%@include file="/common/basiclib.jsp" %>




</head>

<body>

<!--header-->
<%@include file="/common/header.jsp" %>


	<div class="container-fluid">
		<div class="row">

			
			<!--left-->
<%@include file="/common/left.jsp" %>
			
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 목록 </h2>
						
						<form id="frm" action="${pageContext.request.contextPath}/boardModify" method ="get">
						<input type="hidden" id="boardid" name="boardid">
						</form>
						
						
						
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시판 코드</th>
									<th>게시판 이름</th>
									<th>사용 여부</th>
									<th> // </th>
									
								</tr>
								
							
							<c:forEach items="${boardAllList}" var="board" >
							
							<tr  class="boardTr" data-userid="${board.boardid}">
							<td class="boardid">${board.boardid}</td>
									<td>${board.boardname}</td>
									<td><c:choose>
									<c:when test="${board.boarduse_yn==0}">
										<span>사용중</span>
									</c:when>
									
									<c:otherwise>
									<span>사용안함</span>
									</c:otherwise>
								</c:choose>
									</td>
						
								<td><a id="boardGOGO" href="${pageContext.request.contextPath}/boardModify?boardid=${board.boardid}" class="btn btn-default pull-right">수정</a></td>
								</tr>
								
								</c:forEach>
							
							</table>
							
						</div>
						
				
						<a  href="${pageContext.request.contextPath}/boardManagement" class="btn btn-default pull-right">새 게시판 등록</a>

					
					</div>
				</div>




			</div>
		</div>
	</div>
</body>
</html>
