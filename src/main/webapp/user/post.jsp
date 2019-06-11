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
<title>게시글 보기</title>
<%@include file="/common/basiclib.jsp"%>

<script>
	$(document).ready(function() {
		$("#modify").on("click", function() {
			$("#frm").submit();
		})
		
		$("#replyRegBtn").on("click", function() {
			if($('#reply').val().length>5){
				alert("500자 까지만 입력가능합니다 ");
			}else if($('#reply').val().length==0){
				alert("댓글을 입력해주세요");
			}else{
			$("#frmreply").submit();
			}
		})
	})
	
	
	
	
	
	
	
	
</script>


</head>
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


		<br>
		<br>
		<br>
		<br>


						<h2 class="sub-header">${post.posttitle}</h2>  
						<label class="sub-header">작성일 :${post.postred_dtstr}   &nbsp;&nbsp;&nbsp;&nbsp;</label>
     					<label class="sub-header" >작성자 :${post.userid}</label>
     					
     					

						<%-- 
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">작성자</label>
									<div class="col-sm-10"> 
										<label class="control-label">${post.userid}</label>
									</div> 
							</div>
						 --%>



						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/postModify" method="get">
							<input type="hidden" id="postId" name="postId" value="${post.postid}" />
						<%-- 	<input type="hidden" id="postId2" name="postId2" value="${post.postid2}" /> --%>

							<%-- <div class="form-group">
									<label for="userNm" class="col-sm-2 control-label">제목</label>
										<div class="col-sm-10">
											<label class="control-label">${post.posttitle}</label>
										</div>
							</div> --%>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">내용</label>
								<div class="col-sm-10">
									<label class="control-label">${post.postcontent}</label>
								</div>
							</div>
							
						<%-- 	
						<div class="form-group">
								<div class="col-sm-10">
									<img src="${pageContext.request.contextPath}/postfile?postid=${post.postid}"/>
								</div>
						</div> 
							
							--%>
							
							
						<c:forEach items="${fileVo}" var="fileVo">
								
								<tr class="fileTr">
								<a id="DownGOGO" href="${pageContext.request.contextPath}/DownGOGO?fileid=${fileVo.fileid}" class="btn btn-default"> ${fileVo.filename}</a> 
								<td><br></td>
								</tr>
								</c:forEach>
								 
							


							<%-- <div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">작성일</label>
								<div class="col-sm-10">
									<label class="control-label">${post.postred_dtstr}</label>
								</div>
							</div>
						 --%>

						<%-- 	<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">게시판코드</label>
								<div class="col-sm-10">
									<label class="control-label">${post.boardid}</label>
								</div>
							</div>
 --%>
						
						<div class="form-group">
							<div class="col-sm-12">
							<button type="submit" class="btn btn-default pull-right">포스트 수정</button>
							
							<a id="deleteGOGO" onclick="return confirm('정말로 삭제하시겠습니까?')" href="${pageContext.request.contextPath}/postDelete?postid=${post.postid}" class="btn btn-default pull-right">포스트 삭제</a>
							
							<a id="commentGOGO" href="${pageContext.request.contextPath}/postComment?postid=${post.postid}&boardid=${post.boardid}" class="btn btn-default pull-right">답글달기</a>
							</div>
						</div>
						</form>
						
						
					  <!-- 댓글을 작성해 봅시당 -->
					  
						  <form  id="frmreply" action="${pageContext.request.contextPath}/replyinsert" method="post">
							<input type="hidden" id="postid" name="postid" value="${post.postid}"/>	
							
							<table id="replytable" class="table table-striped text-center">
								<tr>
									<th class="text-center">댓글</th>
									<th class="text-center">글쓴이</th>
									<th class="text-center">작성일</th>
									<th class="text-center"></th>
								</tr>


								<c:forEach items="${reply}" var="reply">
								 <c:choose>
										<c:when test="${reply.reply_yn==0}">	
										<tr class="replyTr" data-userid="${reply.reply}">
										<td>${reply.reply}</td>
										<td>${reply.userid}</td>
										<td>${reply.replyred_dtstr}</td>
										<td><a id="replydeleteGOGO"  onclick="return confirm('정말로 삭제하시겠습니까?')" href="${pageContext.request.contextPath}/replyDelete?replycode=${reply.replycode}&postid=${post.postid}" class="btn btn-default pull-right"> 삭제</a></td>
										</tr>
										</c:when>
										<c:otherwise>	
												<tr><td></td><td></td><td>삭제된댓글입니다</td><td></td><td></td></tr>
										</c:otherwise>
									 </c:choose>
								</c:forEach>
								
								
							</table>
							
							
							
							
						<div class="form-group">
							<div class="col-sm-10">
								<input type="text" class="form-control" id="reply" name="reply" placeholder="댓글" value="${param.reply}" maxlength="5">									
						</div>
							<div class="col-sm-2"><button id="replyRegBtn" type="button" class="btn btn-default pull-right">댓글등록</button></div>
						</div>
						
						</form>




					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
