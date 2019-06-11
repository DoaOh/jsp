
<%@page import="kr.or.ddit.paging.model.BPageVo"%>
<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>전체포스트</title>

<!--css js-->
<%@include file="/common/basiclib.jsp"%>


<style>
.userTr:hover{
cursor:pointer;
}


</style>

<script>


$(document).ready(function(){
	
	//사용자 테그 이벤트 등록
	$(".postTr").on("click",function(){
		 var postId = $(this).find(".postId").text();
		 $("#postId").val(postId);
		 $("#frm").submit();
	});
	
	
		$("#post").on("click", function() {
			$("#frm2").submit();
		})
		
	
	
});
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
						<h2 class="sub-header">${boardname}</h2>
						
						
						<form id="frm" action="${pageContext.request.contextPath}/post" method ="get">
						<input type="hidden" id="postId" name="postId">
						</form>
						
						<form id="frm2" action="${pageContext.request.contextPath}/postForm" method ="get">
						<input type="hidden" id="boardid" name="boardid" value = "${boardid}" >
						</form>
						
						
						
						<div class="table-responsive">
							<table  class="table table-striped">
								<tr>
									<th>게시글번호</th>
									<th col style="width:50%;">제목</th>
									<!-- <th>내용</th> -->
									<th>글쓴이</th>
									<th>작성일</th>
								</tr>


								<c:forEach items="${boardPostList}" var="post">
								
								   <c:choose>
										<c:when test="${post.postuse_yn==0}">	
			
												<tr class="postTr" data-userid="${post.postid}">
											    <td class="postId">${post.postid}</td>
											    <td>
												<c:choose>
												<c:when test="${post.lv==2}">
												&nbsp;&nbsp;&nbsp;&nbsp;+ ${post.posttitle} 
												</c:when>
												<c:when test="${post.lv==3}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;++ ${post.posttitle} 
												</c:when>
												<c:when test="${post.lv==4}">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+++ ${post.posttitle} 
												</c:when>
												<c:otherwise>
												${post.posttitle}
												</c:otherwise>
										        </c:choose>
													
												</td>
											<%-- 	<td>${post.postcontent}</td> --%>
												<td>${post.userid}</td>
												<td>${post.postred_dtstr}</td>
												</tr>
										</c:when>
										<c:otherwise>	
												<tr><td></td><td>[삭제된게시물입니다]</td><td></td><td></td><td></td></tr>
										</c:otherwise>
									 </c:choose>
								</c:forEach>
								
							</table>

						</div>
						<button id = "post" type = "submit" class="btn btn-default pull-right">게시글 작성</button>
				<%-- <a id ="post"  href="${pageContext.request.contextPath}/postForm"  class="btn btn-default pull-right">게시글 쓰기</a> --%>
							<div class="text-center">
							<ul class="pagination">


								<%
									BPageVo BpageVo = (BPageVo) request.getAttribute("BPageVo");
									int paginationSize = (Integer) request.getAttribute("paginationSize");
								%>


								<c:choose>
									<c:when test="${BPageVo.getPage()==1}">
										<li class="disabled"><span>띠용«</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/content?boardid=${BPageVo.boardid}&page=${BPageVo.page-1}&pageSize=${BPageVo.pageSize}">띠용«</a>
										</li>
									</c:otherwise>
								</c:choose>


								<c:forEach begin="1" end="${paginationSize}" var="i">
									<c:choose>
										<c:when test="${BPageVo.page==i}">
											<li class="active"><span>${i}</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${pageContext.request.contextPath}/content?boardid=${BPageVo.boardid}&page=${i}&pageSize=${BPageVo.pageSize}">
													${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${BPageVo.getPage() >=paginationSize}">
										<li class="disabled"><span>»때용</span></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${pageContext.request.contextPath}/content?boardid=${BPageVo.boardid}&page=${BPageVo.page+1}&pageSize=${BPageVo.pageSize}">»때용</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
