<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-title.jsp" %>

</head>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/include/include-nav.jsp"%>

<div class="container">
	<p>
		<h2>Board Name</h2>
	</p>

	<hr>

	<section>
		<c:choose>
			<c:when test="${BODY == 'BBS_INPUT'}">
				<%@ include file="/WEB-INF/views/include/bbs_input.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/bbs_list.jsp"%>

				<div class="d-flex justify-content-end div-margin-bottom">
					<a href="${rootPath}/bbs/input"><button class="btn btn-primary">WRITE</button></a>
				</div>
			</c:otherwise>
		</c:choose>
	</section>


</div>

</body>
</html>



