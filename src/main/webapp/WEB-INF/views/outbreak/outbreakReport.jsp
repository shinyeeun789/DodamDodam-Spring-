<%@page import="com.inhatc.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">		<!-- 모바일 반응형을 만들 때 필요 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>	<!-- 제이쿼리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>		<!-- Chart.js -->
<link rel="stylesheet" href="../resources/css/tui-grid.css" type="text/css">
<title> 도담도담 </title>

<link rel="stylesheet" href="../resources/css/main.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<script>
	<c:if test="${empty userVO}">
		alert('로그인 후 사용할 수 있습니다.');
		location.href="/user/login.do";
	</c:if>
</script>
<body class="is-preload">
	<script type="text/javascript">
		
		$(document).ready(function() {
			var monthList = [];
			var dataList = [];
			
			$.ajax({
				url  : "/outbreak/outbreakReport.do",
				type : "POST",
				dataType : "JSON",
				data	: {"userID":"${userVO.userID}"},
				success : function(data) {
					for (var i=0; i<data.length; i++) {
						monthList.push(data[i].outbreakMonth);
						dataList.push(data[i].outbreakCount);
					}
					
					new Chart(document.getElementById("outbreakChart"), {
						type: 'line',
						data: {
							labels: monthList,
							datasets: [{
								data			: dataList,
								label			: "월별 증상 발생 횟수",
								backgroundColor : "rgba(255,99,132,0.2)",
								borderColor		: "rgba(255,99,132,1)",
								borderWidth		: 1
							}]
						},
						options: {
							responsive: false,
							scales : {
								yAxes: [{ticks: {beginAtZero : true, stepSize : 1} }],
								xAxes: [{stacked : true}],
							}
						}
					});
				},
				error: function() {
					alert('데이터를 불러오지 못했습니다. 잠시 후 다시 시도해주세요.');
				}
			})  			// End of Ajax
			
			$.ajax({
				url 	 : "/outbreak/getMaxType.do",
				type	 : "POST",
				dataType : "JSON",
				data	 : {"userID":"${userVO.userID}"},
				success  : function(result) {
					
					$('#maxPartInfo').text("지난 6개월 간 증상이 [ " + result.type + " ] 형태로 많이 발생했어요.");
					$('#detailInfo').text(result.maxCount + "번 중 " + result.typeCount + "번이 [ " + result.type + " ] 형태입니다.");
					$('#medicineInfo').text("[ " + result.medicine + " ] 을 " + result.medicineCount + "번 섭취했어요.")
					
				}, error : function() {
					alert('데이터를 불러오지 못했습니다. 잠시 후 다시 시도해주세요.');
				}
			})
		});
	</script>
	
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
				<section>
					<header>
						<h3> OUTBREAK REPORT </h3>
					</header>
					<div class="row gtr-uniform">
						<div class="col-12">
							<div class="chartjs">
								<div class="linechart"><canvas id="outbreakChart" style="height:50vh; width:60vw; margin:auto; display:block"></canvas></div>
							</div>
						</div>
					</div>
				</section>
				
				<hr class="major" />
				
				<div class="col-12">
					<h3 id="maxPartInfo" style="font-family: 'Gothic A1',serif; text-align: center"></h3>
					<p id="detailInfo" style="font-family: 'Gothic A1',serif; text-align: center"></p>
				</div>
				
				<div class="col-12">
					<h3 style="font-family: 'Gothic A1',serif; text-align: center"> 지난 6개월 동안 나의 약 복용 정보 </h3>
					<p id="medicineInfo" style="font-family: 'Gothic A1',serif; text-align: center"></p>
				</div>
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