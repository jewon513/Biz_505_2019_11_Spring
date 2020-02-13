<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY EMS</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${rootPath}/resources/css/main.css">

<script type="text/javascript">
	$(function() {

		$(".email-list").click(
				function() {

					document.location.href = "${rootPath}/ems/view?ems_seq="
							+ $(this).data("seq")

				})

	})
</script>

<style type="text/css">
div.login-modal {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4);
	display: none;
}

div.login-modal form {
	position: relative;
	top: 200px;
	margin: 10px auto;
}
</style>

</head>
<body>

	<section class="container-fluid">

		<%@ include file="/WEB-INF/views/include/header-include.jsp"%>

		<article class="jewon-main-article">
			<c:choose>
				<c:when test="${BODY=='WRITE'}">
					<%@ include file="/WEB-INF/views/body/ems/write.jsp"%>
				</c:when>
				<c:when test="${BODY=='VIEW'}">
					<%@ include file="/WEB-INF/views/body/ems/view.jsp"%>
				</c:when>
				<c:otherwise>
					<%@ include file="/WEB-INF/views/body/ems/list.jsp"%>
				</c:otherwise>
			</c:choose>


		</article>

		<%@ include file="/WEB-INF/views/include/footer-include.jsp"%>


	</section>

	<div class="login-modal">
		<%@ include file="/WEB-INF/views/login.jsp"%>
	</div>

</body>
</html>