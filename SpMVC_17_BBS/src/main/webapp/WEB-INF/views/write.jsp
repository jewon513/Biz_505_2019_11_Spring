<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/views/include/include-title.jsp" %>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>

</head>

<script type="text/javascript">

	$(function(){
		$('#summernote').summernote({
	        placeholder: '본문을 입력하세요',
	        height: 300
	      });
	})

</script>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/include/include-nav.jsp"%>

	<div class="container">
		<p>
			<h2>WRITE</h2>
		</p>
		<hr>

		<form>
			<div class="form-group">
				<input type="text" class="form-control" id="usr" placeholder="제목을 입력하세요.">
			</div>
			<div class="form-group">
				<textarea rows="10" class="form-control" placeholder="본문을 입력하세요." id="summernote" ></textarea>
			</div>
			<hr>
			<div class="d-flex justify-content-end">
				<a href="${rootPath}/write"><button class="btn btn-primary">등록</button></a>
			</div>
		</form>

	</div>



</body>
</html>