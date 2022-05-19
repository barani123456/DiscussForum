<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserInfo</title>
</head>
<body  background="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg" bgcolor="#8080ff">
${user.id},${user.name} <br>
Email: ${user.email}<br>
role: ${user.role}
<img alt="user photo" src='<c:url value="/resources/css/img/${user.pic}"></c:url>' width="200px" height="100px">
<a href="uploadPhoto">Upload Profile Pic</a>
<a href="download_file?photo=${user.pic}">Download Profile Pic</a>

</body>
</html>