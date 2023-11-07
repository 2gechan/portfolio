<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<form action="" method="POST" class="user updateForm">

	<div class="id">
		<label>아이디</label><input type="text" placeholder="id" name="u_id"
			value="${DTO.u_id}" readonly />
		<div class="error id"></div>
	</div>
	<div class="pwd1">
		<label>비밀번호</label><input type="password" placeholder="password"
			name="u_password" value="${DTO.u_password}" />
		<div class="error pwd1"></div>
	</div>
	<div class="div">
		<label>구분</label><input type="text" placeholder="구분" name="u_div"
			value="${DTO.u_div}" readonly />
		<div class="error div"></div>
	</div>
	<div class="name">
		<label>이름</label><input type="text" placeholder="이름" name="u_name"
			value="${DTO.u_name}" />
		<div class="error name"></div>
	</div>
	<div class="tel">
		<label>전화번호</label><input type="text" placeholder="전화번호" name="u_tel"
			value="${DTO.u_tel}" />
		<div class="error tel"></div>
	</div>
	<c:if test="${DTO.u_div == '일반사용자'}">
		<div>
			<label>소속팀 - 선택사항</label><input type="text" placeholder="소속팀 - 선택사항"
				name="u_team" value="${DTO.u_team}" />
		</div>
	</c:if>
	<div class="update button">
		<button class="update backBtn" type="button">뒤로가기</button>
		<button class="updateBtn" type="button">정보수정</button>
	</div>
</form>
