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

<title>사용자 리스트</title>

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
	$(".userTr").on("click",function(){
		console.log("userTr click");
		
		/* 
		userId를 획득하는 방법 
		$(this).find(".userId").text();
		$(this).data
		 */
		 
		 
		 //사용자 아이디를 $userId 값으로 설정해줌 
		 var userId = $(this).find(".userId").text();
		 $("#userId").val(userId);
		 //frm 을 이용하여 submmit

		 $("#frm").submit();
	});
	
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
						<h2 class="sub-header">사용자</h2>
						
						
<!-- 						사용자 상세조회 페이지 -->
						<form id="frm" action="${pageContext.request.contextPath}/user" method ="get">
						
						<input type="hidden" id="userId" name="userId">
						</form>
						
						
						
						<div class="table-responsive">
							<table class="table table-striped">

								<tr>
									<th>사용자 아이디(el)</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>



								<c:forEach items="${userPagingList}" var="user">


									<tr class="userTr" data-userid="${user.userId}">
										<td class="userId">${user.userId}</td>
										<td>${user.name}</td>
										<td>${user.alias}</td>
										<td></td>
									</tr>

								</c:forEach>



							</table>

						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>


						<!-- 		
						전체사용자수 조회 
						
						 -->


						<div class="text-center">
							<ul class="pagination">



								<%
									PageVo pageVo = (PageVo) request.getAttribute("pageVo");
									int paginationSize = (Integer) request
											.getAttribute("paginationSize");
								%>




								<c:choose>
									<c:when test="${pageVo.getPage()==1}">
										<li class="disabled"><span>띠용«</span></li>
									</c:when>
									<c:otherwise>

										<%-- <%if(pageVo.getPage()==1){ %>
								<li class="disabled"><span>«</span> </li>
							<%}else{ %>
							 --%>
										<li>
											<%-- <%=pageVo.getPage()-1%>	 	 --%> <a
											href="${pageContext.request.contextPath}/userPagingList?page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">«</a>
										</li>

									</c:otherwise>
								</c:choose>


								<%-- 
							<%}%>
							  --%>

	<%-- 							<%
									for (int i = 1; i <= paginationSize; i++) {
								%>

								<li <%if (pageVo.getPage() == i) {%> class="active" <%}%>>

									<%
										if (pageVo.getPage() == i) {
									%> <span><%=i%></span> <%
 	} else {
 %> <a
									href="${pageContext.request.contextPath}/userPagingList?page=<%=i%>&pageSize=${pageVo.pageSize}">
										<%=i%></a>
								</li>
								<%
									}
								%>
								<%
									}
								%>
 --%>


								<c:forEach begin="1" end="${paginationSize}" var="i">
									<c:choose>
										<c:when test="${pageVo.page==i}">
                                          <li class="active">
										<span>${i}</span>
                                          </li>
										</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/userPagingList?page=${i}&pageSize=${pageVo.pageSize}">
										${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${pageVo.getPage() >=paginationSize}">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>


							<%-- 	<%if(pageVo.getPage() >=paginationSize){ %>
							<li class="disabled"><span>»</span> </li>
							<%}else{ %> --%>

										<li><a
											href="${pageContext.request.contextPath}/userPagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">»때용</a>
										</li>
										<%-- 	<%}%> --%>
									</c:otherwise>
								</c:choose>
								<c:set var="aaa" value="<font color=red>ㅋㅋㅋ</font>"></c:set>
								<c:out value="${aaa}" escapeXml="true"></c:out>



							</ul>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</body>
</html>
