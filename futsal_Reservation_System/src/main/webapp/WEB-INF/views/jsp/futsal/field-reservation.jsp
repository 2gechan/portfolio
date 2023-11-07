<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<header>
	<h1>구장 예약</h1>
</header>

<div class="field list">

	<c:forEach items="${FIELDS}" var="FIELD">
		<div class="fieldImage">
			<a href="${rootPath}/reservation?field=${FIELD.f_main_image}"> <img
				alt="" src="${rootPath}/files/${FIELD.f_main_image}" width="100px" height="100px">
				<span>${FIELD.f_name}</span>
			</a>
		</div>
	</c:forEach>
</div>