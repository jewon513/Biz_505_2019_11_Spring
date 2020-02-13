<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>나의 홈페이지</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


<style type="text/css">
	
	.card-header{
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}

</style>


</head>



<header class="jumbotron text-center">
	<h3>네이버 영화 랭크</h3>
</header>
<body class="container-fluid">

<section class="row">
	
	<c:forEach items="${NAVER_LIST}" var="NAVER">
		<%@ include file="/WEB-INF/views/naver-list-body.jsp" %>
	</c:forEach>
	

</section>

</body>
</html>



