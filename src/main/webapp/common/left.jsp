<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 
<script>
$(document).ready(function(){
	//사용자 테그 이벤트 등록
	$(".boardld").on("click",function(){
		 var boardid = $(this).find(".boardid").text();
		 $(".boardld").val(boardid);
		 $("#frm").submit();
	});
});

</script>
    
    
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
	
	<li class="active"><a href="${pageContext.request.contextPath}/login">Main<span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${pageContext.request.contextPath}/boardList">게시판관리</a></li>
	<li class="active"><a href="${pageContext.request.contextPath}/postServlet">전체포스트</a></li>
		

<c:forEach items="${BoardList}" var="board">
<li class="boardld active"><a href="${pageContext.request.contextPath}/content?boardid=${board.boardid}">${board.boardname}</a></li>
</c:forEach>


					
		
		
		
	</ul>
</div>
    