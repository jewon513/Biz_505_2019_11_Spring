<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<script type="text/javascript">

	$(function(){
		
		$(".btn-primary").click(function(){
			
			document.location.href = "${rootPath}/ems/update?ems_seq="  + $(this).attr("data-seq")
			
		})
		
		$(".btn-danger").click(function(){
			
			let ems_seq = $(this).attr("data-seq");

			$.ajax({
			
				url : "${rootPath}/ems/delete",
				data : {ems_seq : ems_seq},
				type : "POST",
				success : function(result){
					if(result =="OK"){
						alert("삭제 완료")
						document.location.href = "${rootPath}/"
					}else{
						alert("삭제 실패")
					}
				},
				error : function(){
					alert("삭제 실패, 서버 통신 오류")
				}
				
			})
			
			
		})
		
		$(".btn-secondary").click(function(){
			
			document.location.href = "${rootPath}/"
			
		})
		
	})

</script>

<div class="jewon-form-border">
	<table class="table text-center">
		<tr>
			<th class="bg-secondary text-light" width="20%">보내는 사람</th>
			<td>${emailVO.from_name}</td>
			<th class="bg-secondary text-light" width="20%">보내는 Email</th>
			<td>${emailVO.from_email}</td>
		</tr>
		<tr>
			<th class="bg-secondary text-light">받는 사람</th>
			<td>${emailVO.to_name}</td>
			<th class="bg-secondary text-light">받는 Email</th>
			<td>${emailVO.to_email}</td>
		</tr>
		<tr>
			<th class="bg-secondary text-light">작성 일자</th>
			<td>${emailVO.send_date}</td>
			<th class="bg-secondary text-light">작성 시각</th>
			<td>${emailVO.send_time}</td>
		</tr>
		<tr>
			<th class="bg-secondary text-light" colspan="1">제목</th>
			<td colspan="3">${emailVO.subject}</td>
		</tr>
		<tr>
			<th colspan="1" class="bg-secondary text-light align-middle">내용</th>
			<td colspan="3" class="align-middle text-left ">${emailVO.content}</td>
		</tr>
	</table>
	<div class="d-flex">
		<button class="btn btn-primary ml-auto" data-seq="${emailVO.ems_seq}" type="button">수정</button>
		<button class="btn btn-danger" data-seq="${emailVO.ems_seq}">삭제</button>
		<button class="btn btn-secondary">리스트로 이동</button>
	</div>
</div>
