
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.wrapper input.writeBt  {display:inline-block;width:60px;height:24px;border:0;background:#333;color:#fff;font-size:0.9em;font-weight:bold;vertical-align:top}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>글 보기: ${notice.notice_title}</title>


<script type="text/javascript">
	function errCodeCheck(){
		var errCode = <%=request.getParameter("errCode")%>;
		if(errCode != null || errCode != ""){
			switch (errCode) {
			case 1:
				alert("잘못된 접근 경로입니다!");
				break;
			}
		}		
	}
	
	
	function moveAction(where){
		switch (where) {
		case 1:
			if(confirm("글을 삭제하시겠습니까?")){
				location.href ="noticedelete.do?shop_number=${notice.shop_number}&notice_number=${notice.notice_number}";
			}
			break;

		case 2:
			if(confirm("글을 수정하시겠습니까?")){
				location.href = "noticemodify.do?notice_number=${notice.notice_number}";
			}
			break;
			
		case 3:
			location.href = "noticelist.do?shop_number=${notice.shop_number}";			
			break;
			
		}
	}
</script>
</head>
<body onload="errCodeCheck()">
<c:choose>
		<c:when test="${empty managermode}">

		</c:when>
		<c:otherwise>
	<jsp:include page="managertop.jsp" flush="true"></jsp:include>
		</c:otherwise>
	</c:choose>	
<br><br>
<div class="wrapper">	
	<table class="boardView">
		<tr>
			<td colspan="4"><h3>${notice.notice_title}</h3></td>
		</tr>
		<tr>
			<th>가게번호</th>
			<th>작성일</th>
		</tr>
		<tr>
			<td>${notice.shop_number}</td>
			<td>${notice.notice_date}</td>
		</tr>
		<tr>
			<th colspan="4">내용</th>
		</tr>

		<tr>
			<td colspan="4" align="left"><p>${notice.notice_content}</p><br /><br /></td>
		</tr>		
	</table>
	<br />
		<c:choose>
		<c:when test="${m_shopnumber == notice.shop_number}">
			<input type="button" value="삭제" class="writeBt" onclick="moveAction(1)" />
			<input type="button" value="수정" class="writeBt" onclick="moveAction(2)" />
			<input type="button" value="목록" class="writeBt" onclick="moveAction(3)" />
		</c:when>
		<c:otherwise>
			<input type="button" value="목록" class="writeBt" onclick="moveAction(3)" />
		</c:otherwise>
	</c:choose>	
</div>

</body>
</html>