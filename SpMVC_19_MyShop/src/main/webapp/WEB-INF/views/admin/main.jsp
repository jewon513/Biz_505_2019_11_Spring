<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/views/include/include-head.jsp"%>

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="${rootPath}/">홈으로</a></li>
			<li class="nav-item"><a class="nav-link" href="${rootPath}/admin/product">상품정보</a></li>
			<li class="nav-item"><a class="nav-link" href="#">품목정보</a></li>
			<li class="nav-item"><a class="nav-link" href="#">거래처정보</a></li>
		</ul>
	</nav>

	<section>
		<c:choose>
			<c:when test="${BODY == 'PRODUCT'}">
				<%@ include file ="/WEB-INF/views/admin/product.jsp" %>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</section>

</body>
</html>