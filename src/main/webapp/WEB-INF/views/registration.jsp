<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" ></c:url>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style2.css"></c:url>">
</head>
<body bgcolor="#8080ff">
<form:form action="registered" method="post" modelAttribute="user">
<%-- Name:<form:input path="name" placeholder="enter username"/><br><br><br>
Password:<form:password path="password"  placeholder="enter password"/><br><br><br> --%>

		<div class="login_form_btm">
			<h1><marquee  scrolldelay="100" width="100%"><font color="purple">REGISTRATION FORM</font></marquee></h1>
			<input type="text" name="name" placeholder="Entername"> <input
				type="password" name="password" placeholder="Enterpassword">
						<input type="text" name="email" placeholder="Enteremail">
<input type="submit" value="submit"><input type="reset"  value="reset">
</div>
</form:form>
<!--  <footer>
      <p>© Copyright 2021 java class. All Rights Reserved.</p>
    </footer> -->
</body>
</html>