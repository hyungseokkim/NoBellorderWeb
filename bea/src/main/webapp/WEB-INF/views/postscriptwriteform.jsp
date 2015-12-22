
<!doctype html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" /><!--모바일페이지크기조절메타태그--> 
<title>새 글 쓰기</title>
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

.wrapper input.writeBt  {display:inline-block;width:60px;height:24px;border:0;background:#333;color:#fff;font-size:0.9em;font-weight:bold;vertical-align:top}


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
		if(document.postscriptwriteform.postsrcipt_content.value == null || document.postscriptwriteform.postsrcipt_content.value == ""){
			alert("한줄평을 입력해 주세요!");
			document.postscriptwriteform.notice_title.focus();
			return false;
		}
		
		if(document.postscriptwriteform.postscript_grade.value == null){
			alert("평점을 선택해 주세요!");
			document.postscriptwriteform.notice_content.focus();
			return false;
		}		
		document.postscriptwriteform.submit();
	
	}
</script>
</head>

<body>
<div class="wrapper">	
	<h3>한줄평 작성</h3>

	<form name="postscriptwriteform" id="postscriptwriteform" method="post" onSubmit="return writeFormCheck()" enctype="form-data">	
	<table class="boardWrite">	
		<tr>
			<th width="27"><label for="subject">한줄평 : </label></th>
			<td width="243">
				<input type="text" id="postscript_content" name="postscript_content" class="boardSubject"/>
				<input type="text" id="shop_number" name="shop_number" value="${shop_number}" />
				<input type="text" id="member_phone" name="member_phone" value="${member_phone}" />
			
				
		</tr>
        <th width="27"><label for="subject">평점</label></th>
        <td>
			  <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="postscript_grade" id="postscript_grade" value="1"> 
			  1
               <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="postscript_grade" id="postscript_grade" value="2">
              2
              <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="postscript_grade" id="postscript_grade" checked="checked" value="3">
              3
              <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="postscript_grade" id="postscript_grade" value="4">
              4
              <input style="margin: 3px 0.5ex; padding: initial; background-color: initial; border: initial;" type="radio" name="postscript_grade" id="postscript_grade" value="5">
              5
               </td>		
	</table>
	<br />
	<input type="reset" value="재작성" class="writeBt"/>
	<input type="submit" value="확인" class="writeBt"/>	
	</form>
</div>
</body>
</html>