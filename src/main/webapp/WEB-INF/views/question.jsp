<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
</head>

<body  background="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg" bgcolor="#8080ff">

	<form:form action="question"  modelAttribute="question">

		<label for="upload_title"><font color="red"><b>Title</b></font></label>
		<form:input path="upload_title" placeHolder="Enter title"></form:input>
		<br>
			<label for="upload_title"><font color="blue"><b>Upload Question</b></font></label>
			<br>
		<form:textarea path="upload_question" placeHolder="Enter question" rows="8"></form:textarea>
			<br>
		<input type="submit" value="submit">
		<input type="reset" value="reset">
	</form:form>
</body>
</html>