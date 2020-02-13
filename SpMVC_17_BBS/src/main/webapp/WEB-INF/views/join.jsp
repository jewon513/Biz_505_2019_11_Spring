<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/views/include/include-title.jsp" %>

<style type="text/css">

.login-div {
	width: 540px;
	margin-top: 100px;
}

@media ( max-width : 575.98px) {
	.login-div {
		width: 100%;
	}
}
</style>

</head>
<body>

	<!-- Navigation -->
	<%@include file="/WEB-INF/views/include/include-nav.jsp"%>

	<div class="container">

		<div class="ml-auto mr-auto login-div text-center shadow p-3 mb-5 bg-white rounded">
			<p><h1><a href="#">회원가입</a></h1></p>
			<form action="#">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="ID" id="Id" autocomplete="off">
				</div>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="Email" id="Email" autocomplete="off" >
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password" id="Password" autocomplete="off">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Repeat Password" id="rePassword" autocomplete="off">
				</div>
				<div class="row">
					<button class="m-auto btn btn-primary">Join</button>
				</div>

			</form>
		</div>

	</div>

</body>
</html>