
<!doctype html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" /><!--모바일페이지크기조절메타태그--> 
<title>새 글 쓰기</title>
<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	function writeFormCheck() {
		if($("#title").val() == null || $("#title").val() == ""){
			alert("제목을 입력해 주세요!");
			$("#title").focus();
			return false;
		}
		
		if($("#content").val() == null || $("#content").val() == ""){
			alert("내용을 입력해 주세요!");
			$("#content").focus();
			return false;
		}		
		return true;
	}
</script>
</head>

<body>
<div class="wrapper">	
	<h3>주문 데이터 넣기</h3>
	<form action="identifywriteform" method="post" onSubmit="return writeFormCheck()" enctype="multipart/form-data">	
	<table class="boardWrite">	
		<tr>
			<th width="27"><label for="subject">제목</label></th>
			<td width="243">
				<input type="text" id="check_number" name="check_number" class="boardSubject"/>
				<input type="hidden" id="table_number" name="table_number" value="${menu_number}" />
			
			
		</tr>
     
    
		<tr>
			<th><label for="content">내용</label></th>
			<td colspan="2"><textarea id="menu_number" name="menu_number" class="boardContent"></textarea></td>			
		</tr>
		<tr>
			<th><label for="file">파일</label></th>
			<td colspan="2"><input type="file" id="file" name="file" /><span class="date">&nbsp;&nbsp;*&nbsp;임의로 파일명이 변경될 수 있습니다.</span></td>			
		</tr>				
	</table>
	<br />
	<input type="reset" value="재작성" class="writeBt"/>
	<input type="submit" value="확인" class="writeBt"/>	
	</form>
</div>
</body>
</html>