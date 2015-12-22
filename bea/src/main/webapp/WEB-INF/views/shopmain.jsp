<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" /><!--모바일페이지크기조절메타태그--> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shop.shop_name}</title>
</head>

<body>
<img src="./resources/images/${shop.shop_logo}" width="100%" /><br />
<%
request.setCharacterEncoding("utf-8");

%>
<center>
<table>
<tr>
<td>
<b><font face="맑은고딕" size="+1">
</td>
</tr>
<tr>
<td>
${stars}

<div align="center" width="100%">

</div>
<a href='./aboutus?shop_number=${shop.shop_number}'><img src="./resources/images/aboutus.png" width="50%" /></a><a href='./menu?shop_number=${shop.shop_number}'><img src="./resources/images/menu.png" width="50%"  /></a><br />
<a href='./postscriptlist?shop_number=${shop.shop_number}'><img src="./resources/images/hugi.png" width="50%" /></a><a href='./noticelist?shop_number=${shop.shop_number}'><img src="./resources/images/notice.png" width="50%"/></a><br />
<img src="./resources/images/sulmyung.png" width="100%" height="30%" />
</center>

</body>
</html>
