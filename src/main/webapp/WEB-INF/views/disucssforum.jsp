<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisucssForum</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"></c:url>">

</head>
<body >
	<%-- <div><jsp:include page="question.jsp"></jsp:include></div> --%>
  <nav>
<label class="logo">Dforum</label>
<ul>
<li><a href="#">Home</a></li>
<li><a href="#">News</a></li>
<c:if test="${ sessionScope.user ne null }">
<li><a href="question_upload">Question</a></li>
</c:if>
<li><a href="#">Contact</a></li>
<li><a href="#">About</a></li>
</ul>
</nav>
<!--  <footer>
      <p>© Copyright 2021 java class. All Rights Reserved.</p>
    </footer> -->
</body>
</html>