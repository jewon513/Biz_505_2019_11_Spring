<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.js"></script>
<script src="${rootPath}/resources/js/summernote-ko-KR.js"></script>

<script type="text/javascript">
	$(function() {

		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
				[ 'fontsize', [ 'fontsize' ] ],
				[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
				[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
				[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
				[ 'insert', [ 'link', 'hr', 'picture' ] ],
				[ 'view', [ 'fullscreen', 'codeview' ] ]

		]

		$("#content").summernote({
			lang : 'ko-KR',
			placeholder : '본문을 입력하세요',
			width : '90%',
			toolbar : toolbar,
			height : '200px',
		})

	})
</script>

<style>
	label{
		width: 20%;
		font-weight: bold;
	}
	
	input{
		margin: 10px 0;
	}
	
	.note-editor{
		margin: 10px auto;
	}
	
	.jewon-form-border h2{
		font-weight: bold;
	}
	
</style>

<form:form modelAttribute="emailVO" class="form-inline">

	<div class="jewon-form-border">
		<h2 class="text-center">이메일 작성</h2>
		<hr>
		<div class="form-group">
			<label for="from_email">보내는 Email</label>
			<form:input path="from_email" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="to_email">받는 Email</label>
			<form:input path="to_email" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="send_date">작성일자</label>
			<form:input path="send_date" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="send_time">작성시각</label>
			<form:input path="send_time" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="from_name">작성자</label>
			<form:input path="from_name" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="to_name">받는사람</label>
			<form:input path="to_name" class="form-control col-sm-9" />
		</div>
		<div class="form-group">
			<label for="subject">제목</label>
			<form:input path="subject" class="form-control col-sm-9" />
		</div>
		<form:textarea path="content"/>
		<hr>
		<div class="d-flex">
			<button class="btn btn-secondary ml-auto">메일 보내기</button>
		</div>
	</div>
</form:form>


