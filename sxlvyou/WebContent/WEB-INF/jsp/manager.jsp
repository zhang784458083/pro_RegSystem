<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>山西旅游后台管理系统</title>
<link href="style/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
</head>
<body>
	<div id="wrap">
		<!--header-->
		<div id="header"><img src="img/logo.jpg" alt="山西旅游后台管理系统" /></div>
		<!--//header-->
		<!--contents-->
		 <form  action="${pageContext.request.contextPath}/manaindex" method="Post" onsubmit="return sub()">
		<div id="contents">
			<div class="main">
				<dl class="box1">
					<dt>登陆账号：</dt>
					<dd><input type="text" class="input1" id="username"/></dd>
				</dl>
				<dl class="box1">
					<dt>登陆密码：</dt>
					<dd><input type="password" class="input1" id="password"/></dd>
					<dd class="dd2"><!-- <a href="#this">忘记密码？</a> --></dd>
				</dl>
				
				<div class="box2"><input type="submit" value="登陆Login" class="input3" /></div>
			</div>
		</div>
		</form>
		<!--//contents-->
		<!--footer-->
		<div id="footer">Copyright2018 company.All Rights Reserved. 版权所有：美丽山西</div>
		<!--//footer-->
	</div>
</body>
<script type="text/javascript">
function sub() {
	if ($("#username").val()!= "admin") {
		alert("账号不存在！");
		return false;
	}
	if ($("#password").val()!= "admin") {
		alert("密码不正确！");
		return false;
	}
	if($("#password").val()== "admin" && $("#username").val()== "admin"){
		return true;
	}
}	
</script>
</html>