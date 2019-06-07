<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
    <title>Signin Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>



	<script>
	$(document).ready(function(){
		
		$("#signinBtn").on("click",function(){
		
			$("#frm").submit();
			
		});

	});

	</script>
	
  </head>
  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">userId</label>
        <input type="text" id="userId" class="form-control" name="userId" 
        placeholder="userId"  value="dkskqk00" required >
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password"class="form-control"
         placeholder="Password" value="dkskqk00" required >
        <button id="signinBtn"class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>