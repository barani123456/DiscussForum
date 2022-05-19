
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" ></c:url>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style2.css"></c:url>">
</head>
<body >
	<form action="loginCheck" method="post">
		<c:if test="${ sessionScope.userlogin eq 'not match'}">
User and password is not matched
</c:if>
	<div class="login_form_btm">
			<h1><marquee  scrolldelay="100" width="100%"><font color="purple">LOGIN FORM</font></marquee></h1>
			<input type="text" name="name" placeholder="Entername"> <input
				type="password" name="password" placeholder="Enterpassword">
			<!-- 	<input type="text" name="email" placeholder="Enteremail"> -->

			Remember Me <input type="checkbox" id="rememberChkBox"
				value="Remember Me"> <input type="submit" value="Login"><input
				type="reset" value="Reset"> <label>Not Registered?<a
				href="registration.jsp">Create an account</a></label>

		</div>
		<!-- Name:<input type="text" name="name" placeholder ="Entername"><br><br><br>

Password:<input type="password" name="password" placeholder ="Enterpassword"><br><br><br>


<input type="submit"><input type="reset">
 -->
	</form>
<!-- 	 <footer>
      <p>© Copyright 2021 java class. All Rights Reserved.</p>
    </footer> -->
</body>
</html>

