<%@page import="kr.or.ddit.paging.model.PageVo"%>
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

<title>사용자 등록</title>
<!--css js-->
<%@include file="/common/basiclib.jsp"%>

<script>

$(document).ready(function(){
	
	$("#boardRegBtn").on("click",function(){
    $("#frm").submit();
        		   		
});

 });
 


</script>



<style>


</style>
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
			
			
					
			<h2 class="sub-header">게시판 등록</h2>
			
				<form id="frm" class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/boardManagement" method="post"
				enctype="multipart/form-data">
				
			
			
			
			<div class="form-group">
			
						<label for="userId" class="col-sm-2 control-label">게시판 제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="boardname" name="boardname"
								placeholder="제목" value="${param.boardname}">
							
						</div>
					</div>
				
				

				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">게시판 사용설정 </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="boarduse_yn" name="boarduse_yn" placeholder="게시판 사용설정" value="${param.boarduse_yn}">
						</div>
				</div>
				
				
				
				
				
				<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button  id="boardRegBtn"  type="button" class="btn btn-default pull-right">게시판 등록완료</button>
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
