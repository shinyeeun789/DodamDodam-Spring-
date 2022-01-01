<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">		<!-- 모바일 반응형을 만들 때 필요 -->
<title> 도담도담 </title>
<link rel="stylesheet" href="../resources/css/main.css">
</head>
<body class="is-preload">
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<a href="/main.do" class="logo"> 도담도담 </a>
					<ul class="icons">
						<li><a href="https://github.com/shinyeeun789" class="icon brands fa-github"><span class="label"> GitHub </span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span class="label"> Mail </span></a></li>
					</ul>
				</header>
				<!-- 검색 -->
				<section>
					<header class="major">
						<h2> Search Food </h2>
					</header>
					<!-- Search -->				
					<section id="search" class="alt">
						<form method="get" action="/food/search.do">
							<input type="text" name="keyword" id="keyword" placeholder="제품명 또는 제조사를 검색해보세요!" />
						</form>
					</section>
					<div class="posts">
						<c:forEach items="${foodList}" var="foodVO">
							<c:if test="${foodVO.manufacturer ne '없음'}">
								<article>
									<a href="/food/foodDetail.do?foodID=${foodVO.foodID}" class="image"><img src="../../resources/picture/${foodVO.image}" alt="" /></a>
									<h3> [ ${foodVO.manufacturer} ] ${foodVO.foodName} </h3>
									<p> ${foodVO.ingredient} </p>
									<ul class="actions">
										<li><a href="/food/foodDetail.do?foodID=${foodVO.foodID}" class="button"> MORE </a></li>
									</ul>
								</article>
							</c:if>
						</c:forEach>
					</div>
				</section>
			</div>
		</div>	
		<!-- Menu -->
		<jsp:include page="../menu.jsp" flush="false"/>		
	</div>
	
	<!-- Scripts -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/browser.min.js"></script>
	<script src="../resources/js/breakpoints.min.js"></script>
	<script src="../resources/js/util.js"></script>
	<script src="../resources/js/main.js"></script>
</body>
</html>