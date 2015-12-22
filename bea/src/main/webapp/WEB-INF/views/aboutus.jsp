<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" /><!--모바일페이지크기조절메타태그--> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shop.shop_name}소개</title>
</head>

<body>
<center>
<h1>${shop.shop_name}소개</h1>
<br>
<img src="./resources/images/${shop.shop_logo}" width="100%" /><br />
<%
request.setCharacterEncoding("utf-8");

%>
<div align="center" width="100%">
<br>

<h3>${shop.shop_introduction}</h3>
</div>

</center>

</body>
</html>
