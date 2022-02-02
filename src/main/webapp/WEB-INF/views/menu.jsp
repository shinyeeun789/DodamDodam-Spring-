<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> ���㵵�� </title>
</head>
<body class="is-preload">
<%
	String userID = null;
	String userName = null;
	String user_type = "";
	if (session.getAttribute("userVO") != null) {
		userID = (String) session.getAttribute("userVO.userID");
		userName = (String) session.getAttribute("userVO.userName");
	}
%>

	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
			
			<!-- Menu -->
			<nav id="menu">
				<c:if test="${empty userVO}">
					<header class="major">
						<h2>Menu</h2>
					</header>
				</c:if>
				<c:if test="${not empty userVO}">
					<header class="major">
						<h2 style="font-family:'Gothic A1', sans-serif;"> <c:out value="${userVO.userName}"/> ��, </h2>
					</header>
				</c:if>
				
				<ul>
					<c:if test="${empty userVO}">
						<li><a href="/user/login.do"> �α��� </a></li>
					</c:if>
					<c:if test="${userVO.user_type eq 'ȸ��'}">
						<li><a href="/user/logout.do"> �α׾ƿ� </a></li>
						<li>
							<span class="opener"> ���������� </span>
							<ul>
								<li><a href="/user/setUserName.do"> �г��� ���� </a></li>
								<li><a href="/user/setAllergyType.do"> �˷��� Ÿ�� ���� </a></li>
							</ul>
						</li>
						<li>
							<span class="opener"> �Ĵ� ���� </span>
							<ul>
								<li><a href="/diet/dietPlus.do"> �Ĵ� �߰� </a></li>
								<li><a href="/diet/dietList.do"> �Ĵ� ����Ʈ </a></li>
							</ul>
						</li>
						<li>
							<span class="opener"> ���� ���� </span>
							<ul>
								<li><a href="/outbreak/outbreakPlus.do"> ���� �߰� </a></li>
								<li><a href="/outbreak/outbreakList.do"> ���� ����Ʈ </a></li>
								<li><a href="/outbreak/medicinePlus.do"> �� ���� ���� �߰� </a></li>
							</ul>
						</li>
						
						<c:if test="${not empty userVO.allergy_type}">
							<li><a href="/allergen/eatableFood.do"> ���� ���� ��ǰ </a>
						</c:if>
						<c:if test="${empty userVO.allergy_type}">
							<li><a href="#"> ���� �м� </a></li>
						</c:if>
						
						<li><a href="/outbreak/outbreakReport.do"> ���� ��ȭ </a></li>				
					</c:if>
					<c:if test="${userVO.user_type eq '������'}">
						<li><a href="/user/logout.do"> �α׾ƿ� </a></li>
						<li><a href="/manage/newFood.do"> ���ο� ��ǰ �Է� </a></li>
						<li><a href="/manage/updateRisk.do"> ��ǰ ���赵 ���� </a></li>
					</c:if>
					<li><a href="/food/search.do"> ��ǰ �˻� </a></li>
					
				</ul>
			</nav>

			<!-- Section -->
			<section>
				<header class="major">
					<h2>Reference</h2>
				</header>
				<p> �����ϴ� ������ �˷��� ������ ��ǰ�� �����翡�� ������ �����̸�, �˷����� ���� ������� ������ �ľ�ó�忡�� ��ǥ�� �ڷ��Դϴ�. ����, �� ������ �����ϴ� ��� ������ ���� �����Դϴ�.</p>
				<ul class="contact">
					<li class="icon solid fa-envelope"> tlsdpdms789@naver.com </li>
					<li class="icon solid fa-home"> https://github.com/shinyeeun789 </li>
				</ul>
			</section>

			<!-- Footer -->
			<footer id="footer">
				<p class="copyright">&copy; Untitled. All rights reserved. Images: <a href="https://www.flaticon.com">Flaticon</a> And <a href="https://www.iconfinder.com">IconFinder</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
			</footer>
		</div>
	</div>
</body>
</html>