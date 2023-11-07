<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="main login" accept-charset="UTF-8">
	<div class="error login">
		<span class="login check">${ERROR}</span>
	</div>
	<div class="login id">
		<label>아이디</label><input placeholder="ID" name="u_id" />
	</div>
	<div class="login pwd">
		<label>패스워드</label><input placeholder="PASSWORD" type="password" name="u_password" />
	</div>
	<div class="login button">
		<button type="button">로그인</button>
	</div>
</form>