
<!doctype html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" /><!--모바일페이지크기조절메타태그--> 
<title>공지 수정</title>

<style type='text/css'>
body {
	background-color: white;
	font-family: sans-serif, tahoma, gulim;
	font-size: 10pt;
}

div.navBar {
	width: 100%;
	margin-top: 20px;
}

div.navBar ul {
	list-style: none;	
}

div.navBar li {
	float: left;
	list-style-position: inside;
	padding-left: 20px;
	padding-right: 20px;
}

div.wrapper {
	width: 60%;
	margin: 0 auto;
	text-align: center;
}

.wrapper form fieldset {
	margin: 0 auto;
	height: 20px;
	margin-left: 60%;
	padding: 10px 10px 10px 10px;
	border-style: inherit;
}

.wrapper input.writeBt {
	height: 35px;
	width: 100px;
}

.wrapper input.boardSubject{
	width: 85%;
	height: 20px;
	margin-right: 5%;
}

.wrapper textarea.boardContent{
	width: 85%;
	height: 300px;
	margin-right: 5%;
}


table.boardTable {
	width: 100%;
	border-style: inherit;
	vertical-align: top;
}

.boardTable th{
	height: 35px;
	background-color: #e5ecef;
	padding: 2px 2px 2px 2px;
}
.boardTable td{
	height: 30px;
	background-color: white;
	border-bottom: 1px solid #d1dee2;
	padding: 2px 10px 2px 10px;
}



.boardTable td.idx{
	width: 7%;
}

.boardTable td.subject{
	width: 45%;
}

.boardTable td.writer{
	width: 10%;
}

.boardTable td.comment{
	width: 7%;
}

.boardTable td.hitcount{
	width: 7%;
}

.boardTable td.recommendcount{
	width: 7%;
}

.boardTable td.writeDate{
	width: 17%;
}


table.boardWrite{
	width: 100%;
	border-style: inherit;
	vertical-align: top;
	background-color: white;	
}

table.boardWrite th{
	width: 15%;
	height: 35px;
	background-color: #f5f6fa;
	padding: 2px 2px 2px 2px;
	border-top:1px solid #e9e9e9;
	border-bottom:1px solid #e9e9e9;
}

table.boardWrite td{
	width: 85%;
	height: 35px;
	padding: 2px 2px 2px 2px;
	border-top:1px solid #e9e9e9;
	border-bottom:1px solid #e9e9e9;
}




table.boardView {
	width: 100%;
	border-style: inherit;
	vertical-align: top;	
}
.boardView th{
	height: 25px;
	background-color: #e5ecef;
	padding: 5px 5px 5px 5px;
}
.boardView td{
	height: 20px;
	background-color: white;
	padding: 5px 10px 5px 10px;
}


table.commentView {
	width: 100%;
	border-style: none;
}
.commentView th{
	height: 25px;
	background-color: #f5f6fa;
	padding: 5px 5px 5px 5px;

}
.commentView td.writer{
	width: 20%;
	background-color: white;
	padding: 5px 10px 5px 10px;
}
.commentView td.content{
	width: 80%;
	background-color: white;
	padding: 5px 10px 5px 10px;
}
textarea.commentForm{
	width: 80%;
	height: 50px;
}
input.commentBt{
	margin-left: 2%;
	width: 15%;
}

span.date {
	font-size: 8pt;
	color: #666666;
}


A:link    { color: black; text-decoration:none; }
A:visited { color: black; text-decoration:none; }
A:active  { color: black; text-decoration:none; }
A:hover   { color: #666666; text-decoration:none; }

A.page:link    { font-size: 11pt; color: black; text-decoration:none; }
A.page:visited { font-size: 11pt; color: black; text-decoration:none; }
A.page:active  { font-size: 11pt; color: black; text-decoration:none; }
A.page:hover   { font-size: 11pt; color: #666666; text-decoration:none; }

</style>

<script type="text/javascript">
	function writeFormCheck() {
		if(document.noticemodifyform.notice_title.value == null || document.noticemodifyform.notice_title.value == ""){
			alert("제목을 입력해 주세요!");
			document.noticemodifyform.notice_title.focus();
			return false;
		}
		
		if(document.noticemodifyform.notice_content.value == null || document.noticemodifyform.notice_content.value == ""){
			alert("내용을 입력해 주세요!");
			document.noticemodifyform.notice_content.focus();
			return false;
		}	
		
		alert( "update");
	/* 	document.noticemodifyform.notice_number.value = document.noticemodifyform.notice_number.value; */
		document.noticemodifyform.action = 'nupdate';
		document.noticemodifyform.submit();
		alert("ok?");
		
		}
</script>
</head>

<body>
<div class="wrapper">	
	<h3>공지사항 수정</h3>
	<form id="noticemodifyform" name="noticemodifyform" method="post" onSubmit="return writeFormCheck()" enctype="form-data">
	<!-- 	<form action="modify" name="noticemodifyform" id="noticemodifyform" method="post" onSubmit="return writeFormCheck()" enctype="form-data">	
	 --><table class="boardWrite">	
		<tr>
			<th width="27"><label for="subject">제목</label></th>
			<td width="243">
				<input type="text" id="notice_title" name="notice_title" class="boardSubject" value="${notice.notice_title}"/>
				<input type="text" id="shop_number" name="shop_number" value="${notice.shop_number}" />
				<input type="text" id="notice_number" name="notice_number" value="${notice.notice_number}" />
			
			
		</tr>
        <th width="27"><label for="subject">중요</label></th>
        <td width="243">
			  <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="notice_important" id="notice_important" value="1"> 
			  Yes
               <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="notice_important" id="notice_important" value="0">
               No
               </td>		
		<tr>
			<th><label for="content">내용</label></th>
			<td colspan="2"><textarea id="notice_content" name="notice_content" class="boardContent" >${notice.notice_content}</textarea></td>			
		</tr>
		
	</table>
	<br />
	<input type="reset" value="재작성" class="writeBt"/>
	<input type="submit" value="확인" class="writeBt"/>	
	</form>
</div>
</body>
</html>