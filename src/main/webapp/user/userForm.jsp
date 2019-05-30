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

</head>
<style>


.form-horizontal{
position:relative;
top:50px;
     left:19%;
   
}


</style>
<body>

	<!--header-->
	<%@include file="/common/header.jsp"%>


	<div class="container-fluid">
		<div class="row">
		<!--left-->
		<%@include file="/common/left.jsp"%>



					

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
			<div class="col-sm-8 blog-main">
			
			
					
			<h2 class="sub-header">사용자 등록</h2>
			
				<form class="form-horizontal" role="form">
				
				
				
				
					
				<div class="form-group">
				<label for="userProfileName" class="col-sm-2 control-label">프로필 사진</label>
						
						<div class="col-sm-10">
							<input type="file" id="userProfileName" name="userProfileName">
						</div>
				</div>
				
			
			<div class="form-group">
			
						<label for="userId" class="col-sm-2 control-label">아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디">
							
						</div>
					</div>
				
				
				
				<div class="form-group">
				
						<label for="userNm" class="col-sm-2 control-label"> 이름</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="name" placeholder="사용자 이름">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAlias" class="col-sm-2 control-label">별명</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAlias" name="userAlias" placeholder="별명">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userPass" class="col-sm-2 control-label"> 비밀번호</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userPass" name="userPass" placeholder="비밀번호">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAddr1" class="col-sm-2 control-label"> 주소</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAddr1" name="userAddr1" placeholder="주소">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userAddr2" class="col-sm-2 control-label">상세주소</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userAddr2" name="userAddr2" placeholder="상세주소">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userZipcd" class="col-sm-2 control-label"> 우편번호</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userZipcd" name="userZipcd" placeholder="우편번호">
						</div>
				</div>
				
				
				<div class="form-group">
				
						<label for="userBirth" class="col-sm-2 control-label">생일</label>
						
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userBirth" name="userBirth" placeholder="생일">
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
