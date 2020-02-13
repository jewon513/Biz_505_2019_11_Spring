<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<style>
@media ( min-width : 576px) {
	.container {
		max-width: 540px;
	}
}

@media ( min-width : 768px) {
	.container {
		max-width: 720px;
	}
}

@media ( min-width : 992px) {
	.container {
		max-width: 960px;
	}
}

@media ( min-width : 1200px) {
	.container {
		max-width: 1140px;
	}
}
</style>

<script>
	$(function() {

		$("tbody tr").click(function() {

			let bbs_id = $(this).attr("data-id")
			document.location.href = "${rootPath}/bbs/view?bbs_id=" + bbs_id

		})

	})
</script>

<table class="table table-sm table-hover">
	<thead>
		<tr class="table-active">
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>작성시각</th>

		</tr>
	</thead>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr>
				<td colspan="5">데이터가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="BBS" items="${LIST}">
				<tbody>
					<tr data-id="${BBS.bbs_id}">
						<th>${BBS.bbs_id}</th>
						<td>${BBS.bbs_subject}</td>
						<td>${BBS.bbs_writer}</td>
						<td>${BBS.bbs_date}</td>
						<td>${BBS.bbs_time}</td>
					</tr>
					<c:if test="${not empty BBS.bbs_replay}">
						<c:forEach var="sub" items="${BBS.bbs_replay}">
							<tr data-id="${sub.bbs_id}">
								<th>${sub.bbs_id}</th>
								<td>${sub.bbs_subject}</td>
								<td>${sub.bbs_writer}</td>
								<td>${sub.bbs_date}</td>
								<td>${sub.bbs_time}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</c:forEach>
		</c:otherwise>
	</c:choose>


</table>