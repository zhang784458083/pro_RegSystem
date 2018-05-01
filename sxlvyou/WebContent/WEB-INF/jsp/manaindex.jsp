<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>山西旅游后台管理系统</title>
<link href="style/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
</head>
<frameset rows="96,*,40" frameborder="0" framespacing="0">
	<frame src="index2_top.html" scrolling="no" name="topframe" noresize="noresize" />
	<frameset cols="237,*"  frameborder="0" framespacing="0">
		<frame src="managermenu.jsp" scrolling="auto" name="leftframe" noresize="noresize" />
		<frame src="index2_right.html" scrolling="auto" name="rightframe" noresize="noresize" />
	</frameset>
	<frame src="index2_bottom.html" name="bottomframe" scrolling="no" noresize="noresize" />
</frameset><noframes></noframes>
</html>