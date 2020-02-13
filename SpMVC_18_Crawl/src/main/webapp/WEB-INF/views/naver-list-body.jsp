<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div class="col-xl-2 col-md-3 col-sm-12">
	
	<div class="card">
		
		<div class="card-header">
			${NAVER.m_title}
		</div>
		<div class="card-body">
			<img alt="${NAVER.m_title}의 사진" src="${NAVER.m_imgURL}" width="100%"/>
		</div>
		<div class="card-footer">
			<a href="${NAVER.m_detailURL}">자세히 보기</a>
		</div>
	
	</div>

</div>