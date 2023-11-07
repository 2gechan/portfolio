<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<div class="main mypage">
	<div>
		<label>아이디</label> <span>${USER.u_id}</span>
	</div>
	<div>
		<label>패스워드</label> <span>${USER.u_password}</span>
	</div>
	<div>
		<label>이름</label> <span>${USER.u_name}</span>
	</div>
	<div>
		<label>전화번호</label> <span>${USER.u_tel}</span>
	</div>
	<c:if test="${DIV == 'USER'}">
		<div>
			<label>소속 팀</label> <span>${USER.u_team}</span>
		</div>
	</c:if>
	<c:if test="${DIV == 'CEO'}">
		<h1>사업자 번호, 구장이름 보여주기</h1>
	</c:if>
	<div class="mypage button">
		<c:if test="${DIV == 'CEO'}">
			<button type="button" class="reg button" data-id="${USER.u_id}">구장 등록(수정)</button>
		</c:if>
		<button type="button" class="update button" data-id="${USER.u_id}">회원정보 수정</button>
		<button type="button" class="delete button" data-id="${USER.u_id}">회원탈퇴</button>
	</div>
</div>

