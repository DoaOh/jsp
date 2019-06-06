<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<title>게시글 수정</title>
<!--css js-->
<%@include file="/common/basiclib.jsp"%>

<script>

$(document).ready(function(){
	
        	$("#boardModifyBtn").on("click",function(){
        		
        		$("#frm").submit();
        	});
  
 });
 
</script>


</head>
<body>


	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
		<!--left-->
		<%@include file="/common/left.jsp"%>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
			<div class="col-sm-8 blog-main">
			
			
					
			<h2 class="sub-header">게시판 수정</h2>
			
				
			<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/boardModify" method="post" enctype="multipart/form-data">
			
				<input type="hidden" id="boardid" name="boardid" value="${board.boardid}"/>		
				
			
			
			
				
				<div class="form-group">
				
						<label for="userNm" class="col-sm-2 control-label"> 게시판제목</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="boardid" name="boardid" placeholder="제목"  value="${board.boardid}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">사용여부</label>
						
							<select  name="selsect" id="selsect" >
									
									<option value="11"> 		<c:choose>
									<c:when test="${board.boarduse_yn==0}">
										<span>사용중</span>
									</c:when>
									<c:otherwise>
									<span>사용안함</span>
									</c:otherwise>
									
								</c:choose>
									</option>
									<option value="22"> 		<c:choose>
									<c:when test="${board.boarduse_yn==0}">
										<span>사용안함</span>
									</c:when>
									<c:otherwise>
									<span>사용중</span>
									</c:otherwise>
								</c:choose>
									</option>
									</select>
								
				</div>
				
				
	
	
	
	
				
										<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="boardModifyBtn"type="button" class="btn btn-default">게시글수정완료</button>
								</div>
							</div>
				
				</form>



					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
