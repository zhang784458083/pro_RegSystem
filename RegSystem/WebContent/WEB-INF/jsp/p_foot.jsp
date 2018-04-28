<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<meta name="viewport" content="width=1024" />
<title>最新通知</title>
<meta name="keywords" content="" />
<meta name="description" content="" />      
<link rel="stylesheet" href="client/css/style.css" type="text/css" media="all" />
<!--[if lt IE 9]><script type="text/javascript" src="../js/html5.js" ></script><![endif]-->
</head>
<body>


<footer>
		<div id="footerlink">
			<nav class="wrapper">
				<!-- <a href="../index.htm" >首页</a>
				<a href="../about/index.htm" >关于</a>
				<a href="../service/index.htm" >服务</a>
				<a href="../case/index.htm" >案例</a>
				<a href="../fangan/index.htm" >方案</a>
				<a href="../contact/index.htm" >联系</a>
				<a href="index.htm">新闻</a> -->
				<a id="gotop" href="javascript:void(0)">top</a>
			</nav> 
		</div>
	<div id="footerinfo">
		<div class="wrapper">
			<h2>
				联系我们<strong>Contact</strong>
			</h2>
			<p>
				<a target="_blank"
					href="http://wpa.qq.com/msgrd?v=3&uin=1152777695&site=qq&menu=yes "><img
					border="0"
					src="${pageContext.request.contextPath}/online/01_online.gif"
					 title="点击这里给我发消息" />
				</a><br /> 
				<font size="3px">电话：182 3510 6368</font><br />
				<font size="3px">电子邮件：zhang784458083@126.com</font><br /> 
				<font size="3px">公司地址：山西省晋中市榆次区大学街</font><br />
				<font size="3px">备案编号：晋ICP备17006459号</font><br /> 
				<font size="3px">Copyright © 2017 - 2018 All rights reserved</font>
				<a onclick="window.location.href='m_index'" >M</a>
			</p>
			<img src="${pageContext.request.contextPath}/online/02.jpg" id="homemap" width="411" height="170"
				/>
		</div>
	</div>

	</footer>
<script type="text/javascript" src="client/js/jquery.1.8.2.min.js" ></script>
<script type="text/javascript" src="client/js/jquery.plugin.min.js" ></script>
<!--[if IE 6]>client
<script type="text/javascript" src="../js/killie6.js" ></script>
<![endif]-->

<script type="text/javascript">
//<![CDATA[
	//Nav Start
	$("header>div>nav>ul>li>a").hover(function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"6px",opacity:"0.7"},{duration:"normal", easing: "easeOutElastic"});
	},function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"10px",opacity:"1"},{duration:"normal", easing: "easeOutElastic"});
	});

		//Nav End
$("#gotop").click(function(){$('body,html').animate({scrollTop:0},500);})
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F3fe5b2b119b5fc4931e9c73e7071b0c6' type='text/javascript'%3E%3C/script%3E"));
	var bds_config = {"bdTop":203};
	$("#bdshell_js").attr("src","http://share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours());
//]]>
</script></body>
</html>