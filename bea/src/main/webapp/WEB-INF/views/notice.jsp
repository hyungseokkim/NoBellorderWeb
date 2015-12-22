<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>무제 문서</title>
<style type="text/css">
#form1 {
	text-align: right;
}
</style>
</head>

<body>
공지사항
<form id="form1" name="form1" method="post" action="">
<table width="491" height="59" border="1">
  <tr>
    <td width="50" height="24">번호</td>
    <td width="309">글 제목</td>
    <td width="110">날짜</td>
  </tr>
  <tr>
    <td height="27">1</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<br/>
  <input type="submit" name="button" id="button" value="글쓰기" />
</form>
</body>
</html>
