<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<form method="POST" enctype="multipart/form-data">
	<h1>구장 등록</h1>
	<div>
		<label>구장 이름</label><input name="f_name" />
	</div>
	<div>
		<label>구장 전화번호</label><input name="f_tel" />
	</div>
	<div>
		<label>대표이미지</label> <input placeholder="" name="f_image"
			type="file" accept="image/*" />
	</div>
	<div>
		<label>이미지들</label> <input placeholder="" name="f_images" type="file"
			multiple="multiple" accept="image/*" />
	</div>
	<div>
		<button>등록하기</button>
	</div>
</form>