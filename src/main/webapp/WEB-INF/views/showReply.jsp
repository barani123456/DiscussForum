<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowReply</title>
</head>
<body>
<c:forEach var="reply_list" items="${replies}">

<b>
Replyid:${reply_list.reply_id}<br>
ReplyDate:${reply_list.reply_date}<br>
ReplyAnswer:${reply_list.reply_ans}<br>
Questionid:${reply_list.question_id}<br>
 Posted on forum_user_id:${reply_list.forum_user_id}<br>

<%-- <c:if test="${ sessionScope.user ne null }">
<a href="reply?qno=${que_list.que.question_id }">Reply</a>
<a href="showreply?qno=${que_list.que.question_id }">Show Reply</a>
</c:if> --%>
</b>
</c:forEach>
</body>
</html>