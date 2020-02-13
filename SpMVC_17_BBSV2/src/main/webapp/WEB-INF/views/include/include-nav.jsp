<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary static-top">
	<div class="container">
		<a class="navbar-brand" href="#">BBS Project</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="${rootPath}/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="${rootPath}/about">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Services</a></li>
				<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">login</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">input member nickname</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">member info</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">logout</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>

<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content text-center shadow p-3 mb-5 bg-white rounded">

			<p>
			<h1>
				<a href="#">BSS project</a>
			</h1>
			</p>

			<form action="#">
				<div class="form-group">
					<input type="text" class="form-control" autocomplete="off" placeholder="ID" id="Id">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" autocomplete="off" placeholder="Password" id="Password">
				</div>
				<p>
					<small><a href="${rootPath}/join" class="text-info">계정이 없다면 지금 가입하세요.</a></small>
				</p>
				<p>
					<small><a href="#" class="text-danger">혹시 비밀번호를 잃어버리셨나요?</a></small>
				</p>
				<div class="row">
					<button class="m-auto btn btn-primary">Login</button>
				</div>

			</form>

		</div>
	</div>
</div>