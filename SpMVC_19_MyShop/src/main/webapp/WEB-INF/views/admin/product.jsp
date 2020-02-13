<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>

<section class="row justify-content-center">
	<article class="col-7 pro-input bg-light">
		<form>
		
			<div class="form-inline form-group">
				<select class="form-control">
					<option>공산품</option>
					<option>농산물</option>
					<option>수산물</option>
				</select>
				<select class="form-control">
					<option>대덕물산</option>
					<option>삼성농산</option>
					<option>목포수산</option>
				</select>
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="상품코드">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="상품이름">
			</div>
			<div class="form-inline form-group">
				<input class="form-control col-6" placeholder="매입단가">
				<input class="form-control col-6" placeholder="판매단가">
			</div>
			<div class="form-group">
				<textarea rows="" cols="" class="form-control" placeholder="상세정보"></textarea>
			</div>
		</form>
	</article>
	<article class="col-3 pro-list bg-primary">
		
	</article>
	
</section>