<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> ���㵵�� </title>
</head>
<body class="is-preload">
	<%
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>

	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
			<!-- Menu -->
			<nav id="menu">
				<header class="major">
					<h2>Menu</h2>
				</header>
				<ul>
				<% if(userID == null) { %>
					<li><a href="/user/login"> �α��� </a></li>
				<% } else { %>
					<li><a href="/logout"> �α׾ƿ� </a></li>
				<% } %>
					<li>
						<span class="opener"> �Ĵ� ���� </span>
						<ul>
							<li><a href="#"> �Ĵ� �߰� </a></li>
							<li><a href="#"> �Ĵ� ����Ʈ </a></li>
							<li><a href="#"> �� ������ </a></li>
						</ul>
					</li>
					<li>
						<span class="opener"> ���� ���� </span>
						<ul>
							<li><a href="#"> ���� �߰� </a></li>
							<li><a href="#"> ���� ����Ʈ </a></li>
						</ul>
					</li>
					<li><a href="#"> ���� �м� </a></li>
					<li><a href="#"> ���� ��ȭ </a></li>
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