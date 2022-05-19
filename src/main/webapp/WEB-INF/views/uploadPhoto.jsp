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
<body>

<form:form action="uploadFile" method="post" enctype="multipart/form-data">
	Choose File: <input type="file" name="pic">
<input type="file" name="" value="reply">
<input type="submit">
</form:form>
</body>
</html>