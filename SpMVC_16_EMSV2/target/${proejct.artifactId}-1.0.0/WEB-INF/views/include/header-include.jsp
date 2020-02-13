<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<script>
	$(function() {

		$("ul li").click(function() {

			if ($(this).text() == "로그인") {
				$("div.login-modal").css("display", "block")
				return false
			}

			if ($(this).text() == "EMS") {
				let text = $(this).data("menu-name")
			}

			let href = $(this).attr("data-menu")
			document.location.href = "${rootPath}/" + href
		})

	})
</script>

<article class="jumbotron bg-secondary">
	<h1 class="text-light">EMS</h1>
</article>

<nav class="navbar navbar-expand-sm bg-secondary text-light">
	<ul class="navbar-nav">
		<li class="nav-item" data-menu="ems/list" data-menu-name="홈으로"><a class="nav-link" href="#">EMS</a></li>
		<li class="nav-item" data-menu="ems/free"><a class="nav-link" href="#">자유게시판</a></li>
		<li class="nav-item" data-menu="ems/notice"><a class="nav-link" href="#">공지사항</a></li>

		<c:if test="${empty MEMBER}">
			<li class="nav-item" data-menu="member/login"><a class="nav-link" href="#">로그인</a></li>
			<li class="nav-item" data-menu="member/join"><a class="nav-link" href="#">회원가입</a></li>
		</c:if>

		<c:if test="${!empty MEMBER}">
			<li class="nav-item" data-menu="member/logout"><a class="nav-link" href="#">로그아웃</a></li>
			<li class="nav-item" data-menu="member/logout"><a class="nav-link" href="#">${MEMBER.nickname}(${MEMBER.email})</a></li>
		</c:if>
	</ul>
</nav>




