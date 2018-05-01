<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>山西旅游后台管理系统</title>
<link href="style/main2.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body{
	background-color:#013d7c;
}
#navigation {
	width:199px;
	font-family:Arial;
}
#navigation ul {
	list-style-type:none;				/* 示目 */
	margin:0px;
	padding:0px;
}
#navigation ul li {
	border-bottom:0;	/* 禄 */
}
#navigation ul li a{
	display:block;						/* 示 */
	height:33px; line-height:33px;
	padding-left:50px;
	text-decoration:none;		/* 叩拇趾 */
	border-bottom:2px solid #2690e4;			/* 也影 */
}
#navigation ul li  a:link, #navigation ul li a:visited{
	background:#5dc6fd url(img/icon1.jpg) 25px 10px no-repeat;
	color:#FFFFFF;
	font-size:14px;
	font-weight:bold;
}
#navigation ul li a:hover{		/* 昃?*/
	background-color:#5dc6fd;			/* 谋浔成?*/
	color:#ffff00;						/* 谋色 */
}

/* 硬说CSS式 */
#navigation ul li ul{
	list-style-type:none;
	margin:0px;
	padding:0px 0px 0px 0px;
}
#navigation ul li ul li{
	border-top:0;
}
#navigation ul li ul li a{
	display:block;
	height:30px; line-height:30px; 
	padding-left:74px;
	text-decoration:none;
	border-bottom:1px solid #6ddef3;
}
#navigation ul li ul li a:link, #navigation ul li ul li a:visited{
	background:#38ace9 url(img/icon2.jpg) 52px 10px no-repeat;
	color:#FFFFFF;
	font-size:12px;
	font-weight:bold;
}
#navigation ul li ul li a:hover{
	background-color:#38ace9;
	color:#ffff00;
}
-->
</style>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("li").find("ul").prev().click(function(){
		$(this).next().toggle(500);	//鸾サ
	});
	$("li:has(ul)").find("ul").hide();
});
</script>
</head>
<body>
	<div id="left">
		<div class="main">
			<div class="tit">网站菜单管理</div>
			<div id="navigation">
				<ul id="listUL">
					<li><a href="#">内容管理</a>
						<ul>
						<li><a target="rightframe" href="conlist">查询内容</a></li>
							<li><a target="rightframe" href="addUI">添加内容</a></li>
							
							
						</ul>
					</li>
					<li><a href="#">留言管理</a>
						<ul>
							
							<li><a target="rightframe" href="lyUI">留言查看</a></li>
							
						</ul>
					</li>
					<!-- <li><a href="#">同里景点</a>
						<ul>
							<li><a target="rightframe" href="index2_right.html">添加景点</a></li>
							<li><a target="rightframe" href="index4_right1.html">查询景点</a></li>
							<li><a target="rightframe" href="index3_right.html">修改景点</a></li>
						</ul>
					</li>
					<li><a href="#">同里饭店</a>
						<ul>
							<li><a target="rightframe" href="index2_right.html">添加饭店</a></li>
							<li><a target="rightframe" href="index4_right1.html">查询饭店</a></li>
							<li><a target="rightframe" href="index3_right.html">修改饭店信息</a></li>
						</ul>
					</li> -->
					<!-- <li><a href="#">退出系统</a>
						<ul>
							<li><a href="index">退出系统</a></li>
						</ul>
					</li>  -->
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
