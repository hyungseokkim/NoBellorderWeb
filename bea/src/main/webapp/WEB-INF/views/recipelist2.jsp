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
<title>MENU</title>
<style type='text/css'>

</style>
<script type="text/javascript">
var timer=setTimeout(alertStr, 500);

function alertStr(){
	if(document.test.chmenu.value.length >1){
	alert("값이 있습니다");
	return true;
	}
	if(document.test.chmenu1.value.length >1){
		alert("담겼습니다");
		return true;
	}
	
}
</script>
</head>

<body>

<center>

			<c:forEach var="result" items="${list2}" varStatus="status">	
					<center>
					
		<%-- <form action="identify" name="noticewriteform" id="noticewriteform" method="post" onSubmit="return writeFormCheck()" enctype="form-data">
		 --%><form action="identify" method="post" onSubmit="return identifycheck()" id ="menuform" name="menuform" enctype="form-data">	
		<%-- <form:form modelAttribute="identify" method="get" Action='identify.do' name="identify"> --%>
	

	
	<!-- 	<input type="hidden" name="menu_number" id="menu_number" /> -->
					<div id="left-box" style="margin: 1px 1px 1px 1px;">
						<center>
						
						
						<table border="0" width = "100%" height = "50%" type = "submit" name="submit" value="submit">
<tr>
<td height="100px" width="100px"><input type="image"
									src="./resources${result.menu_photo}" width="100%"
									height="100%"
									style="border-radius: 7px; -moz-border-radius: 7px; -khtml-border-radius: 7px; -webkit-border-radius: 7px;" /></td>
								<td><input type="hidden" id="menu_number" name="menu_number" value="${result.menu_number}" />${result.menu_name}<br>
	<input type="hidden" id="table_number" name="table_number" value="${table_number}" />가격: <s>${result.menu_price}</s><br>
	<input type="hidden" id="check_price" name="check_price" value="${result.discount_price}" /> 할인가 : ${result.discount_price}<br>
	수량 :  <input type="text" name="check_amount" id="check_amount" value="0" size="2"/> <input type="submit" value="담기"></td>
</tr>

</table>
			
						<%-- <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
							
							<tr>
								<td height="10"></td>
							</tr>
							
							<tr>
								<td height="180">
						
						
						<input type="image" src="./resources${result.menu_photo}" width="100%" height="100%" name="submit" value="submit" />
									<img src="./resources${result.menu_photo}" OnClick="identifycheck()" width="100%" height="100%" style="border-radius: 15px 15px 15px 15px;">
									
								</td>
							</tr>
							
							<tr>
							
								<td height ="50">
								<p>
									<font color="black">
									<input type="text" id="menu_number" name="menu_number" value="${result.menu_number}"/>${result.menu_number}
									 <input type="hidden" id="table_number" name="table_number" value="${table_number}"/>
								<input type="hidden" id="menu_name" name="menu_name" value="${result.menu_name}"/> ${result.menu_name}
									</font>
									<font color="black">가격:&nbsp;${result.menu_price}원</font><br>
									할인가: ${result.discount_price}
									<input type="hidden" id="check_price" name="check_price" value="${result.discount_price}"/>
									<br>
									<a href="identify?menu_number=${result.menu_number}">등록</a>
							
									<font color="black">할인가: ${result.discount_price} 원</font><br>
										<font color="black">수량:
										<input type="text" name ="check_amount" id="check_amount" value="0" />
										</font>
							
									
							<!-- 			<input type="submit" value='등록'/> -->
								<!-- </a> -->
						
									
								</p>
								</td>
							
							</tr>
							
						</table> --%>
						</center>
						
					</div>
					</form>
					</center>
					
				
					
			</c:forEach>

    </center>
</body>
</html>