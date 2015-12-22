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
<title>IDENTIFY</title>
<style type='text/css'>

a:link		{font-family:"";color:black;text-decoration:none;}
a:visited	{font-family:"";color:black;text-decoration:none;}
a:hover		{font-family:"";color:black;text-decoration:none;}
html, body { width:100%; height:100%;  margin:0px; padding:0px; 
	font-family: sans-serif, tahoma, gulim;}

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

table{
	width: 100%;
	border-style: inherit;
	vertical-align: top;
}

th{	height: 35px;
	background-color: #4C4C4C;
	padding: 2px 2px 2px 2px;
	color:white;
	border-top:1px solid #e9e9e9;
	border-bottom:1px solid #e9e9e9;
	}
td{	height: 35px;
	color:black;
	background-color: #F6F6F6;
	border-top:1px solid white;
	border-bottom:1px solid white;
	text-align:center;
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

<body>
<h3>테이블번호:${table_number}</h3><br>
	<form:form id="identifyform" name="identifyform" method="post">
<input type="hidden" id="test" name="test" value="${order[0].table_number}">
						<center>
			<div id="left-box" style="margin: 1px 1px 1px 1px;">
				<center>
					<input type="hidden" id="order" name="order" />
					<table align="center" width="95%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>주문번호</th>
							<th>메뉴이름</th>
							<th>수량</th>
							<th>단가</th>
							<th>가격</th>
						</tr>
				
						<c:forEach var="result" items="${order}" varStatus="status">
							<tr>
								<td><input type="hidden" id="table" name="table" value="${result.order_number}" />${result.order_number}</td>
								<td>${result.menu_name}</td>
								<td>${result.check_amount}</td>
								<td>${result.check_price}</td>
								<td>${result.check_discount}</td>
							</tr>

						</c:forEach>

					</table><b>
					총가격:${order[0].order_grossvalue}<br>
					주문상태:
		<c:choose>
		<c:when test="${order[0].order_state == 1}">
		<b>주문완료</b>
		</c:when>
		<c:when test="${order[0].order_state == 2}">
		<b>조리중</b>
		</c:when>
		<c:when test="${order[0].order_state == 3}">
		<b>조리완료</b>
		</c:when>
		<c:otherwise>
		<b>주문없음</b>
		</c:otherwise>
	</c:choose><br>
					주문날짜:${order[0].order_date}<br></b>

<input type="text" id="test" name="test" value="${check_date}">	
				
				</center>

			</div>
		

	<a href="orderstate?table_number=${table_number}&order_state=${order[0].order_state}&order_number=${order[0].order_number}"><주문승인></a>		
<!-- 	<input type="button" id="permit" name="permit" value="주문승인"> -->
		</center>
	</form:form>

</body>
</html>