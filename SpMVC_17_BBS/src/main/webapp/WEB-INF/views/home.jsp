<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/WEB-INF/views/include/include-title.jsp" %>

<script type="text/javascript">

	$(function(){
		
		$("tr").click(function(){
			document.location.href = "${rootPath}/view"
		})
		
	})
	
</script>

<style type="text/css">

.form-search-bar{
	width: 280px;
	
}

.div-margin-bottom{
	margin-bottom: 10px;
}

</style>

</head>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/include/include-nav.jsp"%>

	<div class="container">
		<p>
		<h2>Board Name</h2>
		</p>

		<hr>

		<table class="table table-sm table-hover">
			<thead>
				<tr class="table-active">
					<th scope="col">Type</th>
					<th scope="col">Column heading</th>
					<th scope="col">Column heading</th>
					<th scope="col">Column heading</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">Active</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Default</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Primary</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Secondary</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Success</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Danger</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Warning</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Info</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Light</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
			</tbody>
		</table>

		<div class="row justify-content-center div-pagination">
			<ul class="pagination">
				<li class="page-item disabled"><a class="page-link" href="#">&laquo;</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
			</ul>
		</div>
		
		<div class="row justify-content-center div-margin-bottom">
			<form class="form-search-bar">
				<input class="form-control" type="text" placeholder="Search">
			</form>
		</div>
		
		<div class="d-flex justify-content-end div-margin-bottom">
			<a href="${rootPath}/write"><button class="btn btn-primary">WRITE</button></a>
		</div>

	</div>

</body>

</html>