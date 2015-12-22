<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>한줄평</title>
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
	background-color: #b0e0e6;
	padding: 2px 2px 2px 2px;
}

table.boardWrite td{
	width: 85%;
	height: 35px;
	padding: 2px 2px 2px 2px;
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
	background-color: #b0e0e6;
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
	function selectedOptionCheck(){
		$("#type > option[value=<%=request.getParameter("type")%>]").attr("selected", "true");
	}
	
	function moveAction(where){
		switch (where) {
		case 1:
			location.href = "postscriptwriteform.do";
			break;
		
		case 2:
			location.href = "postscriptlist.do";
			break;
		}
	}

</script>
</head>

<body>

<br><br>
<center>
<h1>한줄평</h1>
</center>
<table border="0" class="boardTable">
		<thead>
		<tr>
			<th>평점</th>
			<th>한줄평</th>
			<th>작성일</th>	
		</tr>
		</thead>
		<tbody>
		<c:forEach var="postscriptList" items="${postscriptList}">
		<tr class="spciallist">
			<td class="idx" style="background-color:#f5f6fa; border"><strong>${postscriptList.postscript_grade}</strong></td>
			<td align="left" class="subject" style="background-color:#f5f6fa">
				<strong>${postscriptList.postscript_content}</strong>
			</td>
			<td class="writeDate" style="background-color:#f5f6fa"><strong>${postscriptList.postscript_date}</strong></td>		
		</tr>
		</c:forEach>

		</tbody>
	</table>
	<br />
	${pageUrl}
	<br /><br />
	<c:forEach var="manager" items="${manager}">
	<c:choose>
		<c:when test="${user_number == postscript.user_number}">
	<input type="button" value="목록" class="writeBt" onclick="moveAction(2)"/>
	<input type="button" value="쓰기" class="writeBt" onclick="moveAction(1)"/>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>	
		</c:forEach>

</body>
</html>