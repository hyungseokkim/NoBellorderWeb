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
<title>ManagerMode</title>
<style type='text/css'>

</style>
<script type="text/javascript">
	function login(){
		alert("로그인페이지");
		location.href="managerlogin.do";
		
		return true;
	}
	
	function logout(){
		alert("로그아웃");
		location.href="logout.do";
		
		return true;
	}

</script>
</head>
<style>
.bodies {
	background-color: white;
	font-family: sans-serif, tahoma, gulim;
	font-size: 10pt;
	float:right
}
li {list-style : none;display: list-item;float:left;margin:0 0 0 10px}
A:link    { color: black; font-family: sans-serif, tahoma, gulim; text-decoration:none; }


</style>
<body>

		<table style="width:100%; height:15%">
		<tr>
		<td align="right">
		<h1 class="bodies">
<c:choose>
		<c:when test="${empty m_shopnumber}">

		<input type="button" id="ol_submit"  value="로그인" class="writeBt" onclick="login()"/>

		</c:when>
		<c:otherwise>
		
		<ul>

		<li>가게번호 ${m_shopnumber}님, 환영합니다.</li>
		<li><a href="counter.do?shop_number=${m_shopnumber}">카운터화면</a></li>
        <li><a href="kitchen.do?shop_number=${m_shopnumber}">주방화면</a></li>
        <li>
        <a href="noticelist.do?shop_number=${m_shopnumber}">공지사항</a>
        </li>
         <li><input type="button" id="ol_submit" value="로그아웃" class="writeBt" onclick="logout()"/>
         </li>

        </ul>


		</c:otherwise>

	</c:choose>	
	</h1>
			</td>    
        </tr>
</table>

<br>

