<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>Table</title>
<style type='text/css'>

a:link		{font-family:"";color:black;text-decoration:none;}
a:visited	{font-family:"";color:black;text-decoration:none;}
a:hover		{font-family:"";color:black;text-decoration:none;}
html, body { width:100%; height:100%;  margin:0px; padding:0px; 
	background-image: url("./resources/image/monun.png");}

#box { width:80%; height:auto; border:0px solid black; border-collapse:collapse; text-align:left;}
#box tr { border:1px solid pink; }
#box td { border:1px solid pink; }

p {

	margin: 0px 0px 0px 0px;
	height: 50px;
	align:left;
	font-size: 14px;
	font-family: "맑은 고딕";
}

o {
	padding: 0px 10px 10px 0px;
	margin: 1px 1px 1px 1px;
	align: center;
	height: 20px;
	font-size: 14px;
	font-family: "맑은 고딕";
}
/* 
#left-box { 
	width: 100%; 
	height:80%;
	border:1px solid;
	border-color: gray; 
	float: left;
	border-radius: 15px 15px 15px 15px;

} */

#padding-box { 
	width: 47%; 
	height:1px;
	border:0px solid; 
	float: left;

}

</style>

<script type="text/javascript">
	function check() {
		document.identify.order.value = document.identify.test.value;
		alert( "되는거니");
		document.identify.action = 'orderlist';
		document.identify.submit();
	}

	function identifydelete(check_number) {
/* 		document.identify.table.value = document.identify.table.value; */
		alert( "delete");
		document.identify.action = 'identifydelete';
		document.identify.submit();
	}
</script>
</head>

<body style="background-color:#FAECC5; color:black">
	<form:form id="identifyform" name="identifyform" method="post">
<input type="hidden" id="test" name="test" value="${order[0].table_number}">
	
					<b style="font-family: sans-serif;color:#4C4C4C">${table_number}번테이블</b><br>
					<center style="font-family: '맑은 고딕', 'Malgun Gothic', Gothic, sans-serif; font-size: 10pt;">
					주문상태:<br>
		<c:choose>
		<c:when test="${order[0].order_state == 1}">
		<b style="color:blue">주문완료</b>
		</c:when>
		<c:when test="${order[0].order_state == 2}">
		<b style="color:#00D8FF">조리중</b>
		</c:when>
		<c:when test="${order[0].order_state == 3}">
		<b style="color:#1DDB16">조리완료/계산전</b>
		</c:when>
		<c:otherwise>
		<b style="color:red">주문없음</b>
		</c:otherwise>
	</c:choose><br>
					주문날짜:<br>${order[0].order_date}<br>
	<hr>
	<b style="font-size:+1">총가격:${order[0].order_grossvalue}원</b><br>
				
				</center>

			
	
		

		
	</form:form>

</body>
</html>