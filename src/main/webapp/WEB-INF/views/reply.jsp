<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body  background="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg" bgcolor="#8080ff">
	<form:form action="replySave" modelAttribute="reply">
		<br>
Question Title:${title}<br>
About:${about}<br>
Posted by: ${uploader}
<form:hidden path="question_id" value="${qid}" />
Reply: <form:textarea path="reply_ans"></form:textarea>
		<input type="submit" value="reply">
	<!-- 	<input type="submit" value="showreply"> -->
</form:form>
</body>
</html>