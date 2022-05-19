
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" ></c:url>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/slick.css" ></c:url>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/reset.css"></c:url>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/slider.css"></c:url>">

<body>
	<h2>
		<marquee scrolldelay="100" width="20%">
			<font color="purple">DiscussForum</font>
		</marquee>
	</h2>
<div><jsp:include page="disucssforum.jsp"></jsp:include></div>
		<c:if test="${ sessionScope.user ne null}">Hello  ${sessionScope.user.name}</c:if>
	<div class="middle">
		<!-- 	<a href="login">Login</a> -->
		<!-- 		 <a href="logout">LogOut</a>
		<a href="registration">Registration</a> -->
		<a href="login" class="btn btn--red btn--cubic">LOGIN</a> <a
			href="registration" class="btn btn--blue btn--cubic">REGISTRATION</a>
		<a href="logout" class="btn btn--purple btn--cubic">LOGOUT</a>
		<a href="show_all_question?pno=1">Show_All_Question</a>
	</div>
	<div class="wrapper">

		<ul class="slider">
			<li class="slider-item slider-item01"><img
				src="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo1.jpg"></img>
			</li>
			<li class="slider-item slider-item02"><img
				src="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo2.jpg"></img>
			<li class="slider-item slider-item03"><img
				src="C:/Users/baran/Desktop/Demo_Project/DiscussForum/src/main/webapp/images/photo3.jpg"></img>
			</li>
		</ul>
		<!--/wrapper-->
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script
		src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/6-1-2/js/6-1-2.js"></script>

</body>
</html>

