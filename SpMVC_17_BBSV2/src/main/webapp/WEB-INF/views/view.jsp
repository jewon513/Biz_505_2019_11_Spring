<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/views/include/include-title.jsp"%>


</head>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/include/include-nav.jsp"%>

	<div class="container">
		<p>
		<h2>Board Name</h2>
		</p>
		<hr>
		<h3>${bbsVO.bbs_subject}</h3>
		<p>
			<small>${bbsVO.bbs_date} ${bbsVO.bbs_time} </small> <small class="text-info">${bbsVO.bbs_writer}</small> <small>님 ${bbs_count}</small>
		</p>
		<hr>
		${bbsVO.bbs_content}
		<hr>
		<div class="d-flex justify-content-end">
			<a href="#"><button class="btn btn-primary btn-sm">수정</button></a> 
			<a href="#"><button class="btn btn-danger btn-sm">삭제</button></a> 
			<a href="#"><button class="btn btn-info btn-sm">리스트</button></a>
		</div>

	</div>

	<div class="container">
		<!-- Comments Form -->
		<div class="card my-4">
			<h5 class="card-header">Leave a Comment:</h5>
			<div class="card-body">
				<form:form action="${rootPath}/bbs/replay" modelAttribute="bbsVO" >
					<div class="form-group">
						<form:textarea path="bbs_content" class="form-control" rows="3" placeholder="댓글을 입력하세요."></form:textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>

		<!-- Single Comment -->
		<div class="media mb-4">
			<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<h5 class="mt-0">Commenter Name</h5>
				Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
				<div class="d-flex justify-content-end">
					<a href="#"><button class="btn btn-success btn-sm">대댓글</button></a> <a href="#"><button class="btn btn-primary btn-sm">수정</button></a> <a href="#"><button class="btn btn-danger btn-sm">삭제</button></a>
				</div>
			</div>
		</div>

		<div class="media mb-4">
			<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<h5 class="mt-0">Commenter Name</h5>
				Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
				<div class="d-flex justify-content-end">
					<a href="#"><button class="btn btn-primary btn-sm">수정</button></a> <a href="#"><button class="btn btn-danger btn-sm">삭제</button></a>
				</div>
				<div class="media mt-4">
					<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
						<div class="d-flex justify-content-end">
							<a href="#"><button class="btn btn-primary btn-sm">수정</button></a> <a href="#"><button class="btn btn-danger btn-sm">삭제</button></a>
						</div>
					</div>
				</div>

				<div class="media mt-4">
					<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
						<div class="d-flex justify-content-end">
							<a href="#"><button class="btn btn-primary btn-sm">수정</button></a> <a href="#"><button class="btn btn-danger btn-sm">삭제</button></a>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>

</body>
</html>