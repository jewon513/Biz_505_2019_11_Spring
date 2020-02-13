<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<script>
	
	$(function(){
	
		$("li a").click(function(){
			let href = $(this).attr("data-menu")
			document.location.href = "${rootPath}/" + href
		})
		
	})
	
	
</script>

<article class="jumbotron bg-secondary">
	<h1 class="text-light">
		EMS
	</h1>
</article>

<nav class="navbar navbar-expand-sm bg-secondary text-light">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="#" data-menu="bbs/list">EMS</a></li>
		<li class="nav-item"><a class="nav-link" href="#" data-menu="bbs/free">자유게시판</a></li>
		<li class="nav-item"><a class="nav-link" href="#" data-menu="bbs/notice">공지사항</a></li>
		<li class="nav-item"><a class="nav-link" href="#" data-menu="bbs/login">로그인</a></li>
		<li class="nav-item"><a class="nav-link" href="#" data-menu="bbs/join">회원가입</a></li>
	</ul>
</nav>