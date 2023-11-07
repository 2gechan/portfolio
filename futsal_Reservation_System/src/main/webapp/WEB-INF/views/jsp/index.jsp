<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230911-001" var="version" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Every Futsal</title>
<link rel="stylesheet"
	href="${rootPath}/resources/css/index.css?${version}" />
<link rel="stylesheet"
	href="${rootPath}/resources/css/join.css?${version}" />
<link rel="stylesheet"
	href="${rootPath}/resources/css/login.css?${version}" />
<link rel="stylesheet"
	href="${rootPath}/resources/css/mypage.css?${version}" />

<link rel="stylesheet"
	href="${rootPath}/resources/css/reservation.css?${version}" />

<script type="text/javascript">
	var rootPath = "${rootPath}"
</script>
<script type="text/javascript" src="${rootPath}/resources/js/index.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/join.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/login.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/mypage.js"></script>
<script type="text/javascript"
	src="${rootPath}/resources/js/calendar.js"></script>

</head>
<body>
	<header class="main title">
		<button class="onOff">&#61</button>
		<h1>Every Futsal</h1>
	</header>

	<div class="container">
		<div class="left-wrapper" style="display: block">
			<div class="menu">메뉴</div>
			<section>
				<nav class="home">홈</nav>
				<nav class="reservation-page">구장 예약</nav>
				<!-- <nav class="ranking-page">전국 랭킹</nav> -->
				<c:choose>
					<c:when test="${empty LOGINUSER }">
						<nav class="my-page">마이페이지</nav>
						<nav class="login-page">로그인</nav>
					</c:when>
					<c:otherwise>
						<nav class="my-page">${LOGINUSER.u_name}</nav>
						<nav class="logout-page">로그아웃</nav>
					</c:otherwise>
				</c:choose>
				<c:if test="${empty LOGINUSER}">
					<nav class="whojoin-page">회원가입</nav>
				</c:if>
			</section>
		</div>
		<div class="main-wrapper">

			<c:if test="${empty BODY}">
				<%@ include file="/WEB-INF/views/jsp/temp.jsp"%>
			</c:if>
			<c:if test="${BODY == 'WHOJOIN'}">
				<%@ include file="/WEB-INF/views/jsp/user/whojoin.jsp"%>
			</c:if>

			<c:if test="${BODY == 'JOIN'}">
				<%@ include file="/WEB-INF/views/jsp/user/join.jsp"%>
			</c:if>
			<c:if test="${BODY == 'LOGIN'}">
				<%@ include file="/WEB-INF/views/jsp/user/login.jsp"%>
			</c:if>
			<c:if test="${BODY == 'MYPAGE'}">
				<%@ include file="/WEB-INF/views/jsp/user/mypage.jsp"%>
			</c:if>
			<c:if test="${BODY == 'UPDATE'}">
				<%@ include file="/WEB-INF/views/jsp/user/infoupdate.jsp"%>
			</c:if>

			<c:if test="${BODY == 'RESERV'}">
				<%@ include file="/WEB-INF/views/jsp/futsal/field-reservation.jsp"%>
			</c:if>

		</div>
	</div>

	<footer>&copy; github.com/2gechan</footer>
</body>
</html>
