<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="" method="POST" class="user joinForm">

	<div class="id">
		<label>아이디</label><input type="text" placeholder="id" name="u_id" />
		<div class="error id"></div>
	</div>
	<div class="pwd1">
		<label>비밀번호</label><input type="password" placeholder="password"
			name="u_password" />
		<div class="error pwd1"></div>
	</div>
	<div class="pwd2">
		<label>비밀번호 확인</label><input type="password" placeholder="password 확인"
			name="u_passowrd2" />
		<div class="error pwd2"></div>
	</div>
		<div class="div">
			<label>구분</label><input type="text" placeholder="구분" name="u_div" value="${DTO.u_div}" readonly />
			<div class="error div"></div>
		</div>
	<div class="name">
		<label>이름</label><input type="text" placeholder="이름" name="u_name" />
		<div class="error name"></div>
	</div>
	<div class="tel">
		<label>전화번호</label><input type="text" placeholder="전화번호" name="u_tel" />
		<div class="error tel"></div>
	</div>
	<c:if test="${JOIN == 'USERJOIN'}">
		<div>
			<label>소속팀 - 선택사항</label><input type="text" placeholder="소속팀 - 선택사항"
				name="u_team" />
		</div>
		<div>
			<div>
				<label>성별 - 선택사항</label>
			</div>
			<div class="gender">
				<label for="">남</label> <input type="radio" placeholder="성별"
					name="u_gender" value="남" /> <label for="">여</label><input
					type="radio" placeholder="성별" name="u_gender" value="여" />
			</div>
		</div>
	</c:if>
	<div>
		<button class="joinBtn" type="button">가입하기</button>
	</div>
</form>
