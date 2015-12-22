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
<title>EVENT</title>
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

#left-box { 
	width: 47%; 
	height:250px;
	border:1px solid;
	border-color: gray; 
	float: left;
	border-radius: 15px 15px 15px 15px;

}

#padding-box { 
	width: 47%; 
	height:1px;
	border:0px solid; 
	float: left;

}

</style>
<script type="text/javascript">
	function lifedetail(lifeNo) {
		document.lifeVo.lifeNo.value = lifeNo;
		document.lifeVo.action = 'lifedetailform.do';
		document.lifeVo.submit();
	}
</script>
</head>

<body>
<br><br>

	<form:form id="event" name="event" method="post">
	
	
		<input type="hidden" name="menu_number" id="menu_number" />

		
			<c:forEach var="result" items="${eventlist}" varStatus="status">	
					<center>
					<div id="left-box" style="margin: 1px 1px 1px 1px;">
						<center>
						<table width="95%" height="240" border="0" cellpadding="0" cellspacing="0">
							
							<tr>
								<td height="10"></td>
							</tr>
							
							<tr>
								<td height="180" >
									<o>
									<img src="./resources/event/${result.benefit_number}.PNG" width="100%" height="100%" style="border-radius: 15px 15px 15px 15px;">
									</o>
								</td>
							</tr>
							
							<tr>
							
								<td height ="50">
								<p>
								
									<font color="black" size="3.5"><b>${result.benefit_name}</b></font>
									<br>
								
									<font color="black" >혜택내용:&nbsp;${result.benefit_content}</font>
								
								</p>
								</td>
							</tr>
							
							
						</table>
						</center>
					
					</div>
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
			
			</a>

		
	</form:form>

</body>
</html>