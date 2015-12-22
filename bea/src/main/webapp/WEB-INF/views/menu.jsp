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



</style>
<script type="text/javascript">

function identifycheck() {
	alert("실행!!");

	document.menuform.submit();
	return true;
}
</script>
</head>

<body>

<br><br>



		
			<c:forEach var="result" items="${menulist}" varStatus="status">	
					<center>
					
		<%-- <form action="identify" name="noticewriteform" id="noticewriteform" method="post" onSubmit="return writeFormCheck()" enctype="form-data">
		 --%><form action="identify" method="post" onSubmit="return identifycheck()" id ="menuform" name="menuform" enctype="form-data">	
		<%-- <form:form modelAttribute="identify" method="get" Action='identify.do' name="identify"> --%>
	

	
	<!-- 	<input type="hidden" name="menu_number" id="menu_number" /> -->
					<div id="left-box" style="margin: 1px 1px 1px 1px;">
						<center>
						<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
							
							<tr>
								<td height="10"></td>
							</tr>
							
							<tr>
								<td height="180">
						
						
						<input type="image" src="./resources${result.menu_photo}" width="100%" height="100%" name="submit" value="submit" />
									<%-- <img src="./resources${result.menu_photo}" OnClick="identifycheck()" width="100%" height="100%" style="border-radius: 15px 15px 15px 15px;">
									 --%>
								</td>
							</tr>
							
							<tr>
							
								<td height ="50">
								<p>
									<font color="black">
									<input type="text" id="menu_number" name="menu_number" value="${result.menu_number}"/>${result.menu_number}
									 <input type="hidden" id="table_number" name="table_number" value="1"/>
								<%-- <input type="hidden" id="menu_name" name="menu_name" value="${result.menu_name}"/> --%> ${result.menu_name}
									</font>
									<font color="black">가격:&nbsp;${result.menu_price}원</font><br>
									할인가: ${result.discount_price}
									<input type="hidden" id="check_price" name="check_price" value="${result.discount_price}"/>
									<br>
									<%-- <a href="identify?menu_number=${result.menu_number}">등록</a> --%>
							
								<%-- 	<font color="black">할인가: ${result.discount_price} 원</font><br> --%>
										<font color="black">수량:
										<input type="text" name ="check_amount" id="check_amount" value="0" />
										</font>
							
									
							<!-- 			<input type="submit" value='등록'/> -->
								<!-- </a> -->
						
									
								</p>
								</td>
							
							</tr>
							
						</table>
						</center>
						
					</div>
					</form>
					</center>
					
					<div id="padding-box">
					</div>
					<div id="padding-box">
					</div>
					
					
			</c:forEach>

			
			<table>
		 		 <tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			
			

		


</body>
</html>