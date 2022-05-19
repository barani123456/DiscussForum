<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply Save</title>
</head>
<body  background="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg" bgcolor="#8080ff">
	<form:form action="replySave" modelAttribute="reply">
	<br>
Question is : ${replied.que.upload_question}<br>
Reply title : ${replied.que.upload_title}<br>
Replied: ${replied.rep.reply_ans}
Replied by:${replied.user.name}<br>
<%-- Posted by: ${replied.forum_user_id} --%>
on: ${replied.rep.reply_date}
</form:form>
</body>
</html>