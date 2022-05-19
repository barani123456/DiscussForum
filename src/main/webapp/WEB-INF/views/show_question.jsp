<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body  background="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg" bgcolor="#8080ff">
<c:forEach begin="1" end="${pages}" var="page">
<a href="show_all_question?pno=${page }">${page} &nbsp;&nbsp;&nbsp;&nbsp;</a>
</c:forEach>
<c:forEach var="que_list" items="${all_que}">
<li>
<b>
Title:${que_list.que.upload_title}<br>
About:${que_list.que.upload_question}<br>
Posted on :${que_list.que.upload_date} by ${que_list.name}
<c:if test="${ sessionScope.user ne null }">
<a href="reply?qno=${que_list.que.question_id }">Reply</a>
<a href="showReply?qno=${que_list.que.question_id }">Show Reply</a>
</c:if>
</b>
</c:forEach>

</body>
</html>