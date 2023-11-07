<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<div class="main whojoin">
	<h1>해당 항목을 선택하세요</h1>
	<div class="join div">
		<a href="/futsal/join?div=1">사업자 가입</a> <a href="/futsal/join?div=2">일반
			사용자 가입</a>
	</div>
</div>