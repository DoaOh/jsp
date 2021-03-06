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
	
        	$("#userModifyBtn").on("click",function(){
        		
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
			
			
					
			<h2 class="sub-header">게시판 정보 수정</h2>  
			
				
			<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/postModify" method="post">
			<input type="hidden" id="postId" name="postId" value="${post.postid}"/>		
				<input type="hidden" id="boardid" name="boardid" value="${post.boardid}"/>		
				<input type="hidden" id="useid" name="userid" value="${USER_INFO.userId}"/>		
				
			
			
			
				
				<div class="form-group">
				
						<label for="userNm" class="col-sm-2 control-label"> 게시글제목</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="posttitle" name="posttitle" placeholder="제목"  value="${post.posttitle}">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">내용</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="postcontent" name="postcontent" placeholder="내용" value="${post.postcontent}">
						</div>
				</div>
				
				
	
				
				
										<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="userModifyBtn"type="button" class="btn btn-default">게시글수정</button>
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
