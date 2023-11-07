<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 홈페이지</title>
<link rel="stylesheet" href="${rootPath}/resources/css/ceopage.css" />
<script type="text/javascript" src="${rootPath}/resources/js/ceopage.js"></script>
<script type="text/javascript">
	var rootPath = "${rootPath}"
</script>
</head>
<body>
	<div class="container">
		<header>
			<c:if test="${MAINFIELD != null}">
				<h1>${MAINFIELD.f_name}</h1>
			</c:if>
			<c:if test="${MAINFIELD == null}">
				<h1>등록된 구장이 없습니다.</h1>
			</c:if>
		</header>
		<div class="subtitle">
			<span class="ceoname">${CEO.u_name}</span>
			<!-- <span class="todaymoeny">오늘
				매출</span> -->
		</div>
		<div class="main-wrapper">
			<c:if test="${empty CEOBODY}">

				<div class="admin field">
					<div class="dashboard title">
						<span class="field-admin">구장관리</span>

					</div>
					<div class="field imageBox">
						<c:if test="${not empty MAINFIELD}">
							<img alt="" src="${rootPath}/files/${MAINFIELD.f_main_image}"
								width="200px" height="200px">
							<div>${MAINFIELD.f_name}</div>
						</c:if>
					</div>

				</div>
				<!-- <div class="admin review">
					<div class="dashboard title">
						<span class="review-admin">후기 관리</span>
					</div>
				</div> -->
				<div class="admin reservation">
					<div class="dashboard title">
						<span class="reservation-admin">예약 현황</span>
					</div>
					<c:if test="${not empty RESERVLIST}"></c:if>
					<div class="reservationlist">
						<c:forEach items="${RESERVLIST}" var="RESERV"
							varStatus="loopStatus">
							<span>${RESERV.r_uteam}<button type="button"
									data-id="${RESERV.r_seq}">경기종료</button>
							</span>
							<c:if test="${!loopStatus.last}">
								<span>VS</span>
							</c:if>

						</c:forEach>
					</div>

				</div>
			</c:if>
			<c:if test="${CEOBODY == 'REG'}">
				<%@ include file="/WEB-INF/views/jsp/futsal/field-registration.jsp"%>
			</c:if>
		</div>
	</div>
</body>
</html>
