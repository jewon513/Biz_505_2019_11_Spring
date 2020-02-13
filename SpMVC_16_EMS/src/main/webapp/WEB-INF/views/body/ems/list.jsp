<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<style>
tbody tr {
	cursor: pointer;
}

tbody tr:hover {
	color: #e85a71;
}
</style>

<table class="table table-hover text-center">
	<thead>
		<tr>
			<th>NO</th>
			<th>받는Email</th>
			<th>받는사람</th>
			<th>제목</th>
			<th>작성일자</th>
			<th>작성시각</th>
		</tr>
	</thead>

	<tbody>
		<c:choose>
			<c:when test="${empty LIST}">
				<tr>
					<td colspan="6">데이터가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${LIST}" var="vo" varStatus="in">
					<tr class="email-list" data-seq="${vo.emsSeq}">
						<td width="5%">${in.index}</td>
						<td width="15%">${vo.fromEmail}</td>
						<td width="10%">${vo.fromName}</td>
						<td width="50%">${vo.subject}</td>
						<td width="10%">${vo.sendDate}</td>
						<td width="10%">${vo.sendTime}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<div class="d-flex">
	<div class="btn btn-secondary ml-auto" id="btn-email-send" onclick="location.href='${rootPath}/ems/input'">메일보내기</div>
</div>