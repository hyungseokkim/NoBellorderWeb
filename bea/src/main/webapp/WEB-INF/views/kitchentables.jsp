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
<!-- <style type='text/css'>

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

#padding-box { 
	width: 47%; 
	height:1px;
	border:0px solid; 
	float: left;

} -->

</style>

</head>

<body style="background-color:#FAF4C0; color:black ">
	<form:form id="identifyform" name="identifyform" method="post">
<input type="hidden" id="test" name="test" value="${order[0].table_number}">
	
					<b style="font-family: sans-serif;color:#4C4C4C">${table_number}번테이블</b><br>
					<center style="font-family: '맑은 고딕', 'Malgun Gothic', Gothic, sans-serif; font-size: 10pt;">
		
		<c:choose>
		<c:when test="${order[0].order_state == 1}">
		</c:when>
		<c:when test="${order[0].order_state == 2}">
		</c:when>
		<c:when test="${order[0].order_state == 3}">
		</c:when>
		<c:otherwise>
		<b style="color:red">주문없음</b>
		</c:otherwise>
	</c:choose>

							

	<b style="font-size:15px">주문날짜:</b>${order[0].order_date}<br>
		<hr>
	<b style="font-size:15px"><table align="center" width="95%" height="100%" border="0" cellpadding="0" cellspacing="0">
						${order[0].order_number}
						<c:forEach var="result" items="${order}" varStatus="status">
							<tr>
							
								<td align="center">${result.menu_name}</td>
								<td align="center">${result.check_amount}</td>
					
							</tr>

						</c:forEach>

					</table>
</b>
				
				</center>

			
	
		

		
	</form:form>

</body>
</html>