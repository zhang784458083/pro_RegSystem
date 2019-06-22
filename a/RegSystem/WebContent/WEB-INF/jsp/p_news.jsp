<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<meta name="viewport" content="width=1024" />
<title>News</title>
<meta name="keywords" content="" />
<meta name="description" content="" />      
<link rel="stylesheet" href="client/css/style.css" type="text/css" media="all" />
<!--[if lt IE 9]><script type="text/javascript" src="../js/html5.js" ></script><![endif]-->
</head>
<body>

<jsp:include page="p_header.jsp"></jsp:include>
<section id="newslist">
	<div class="cat_title">
		<div class="wrapper">
			<h2><strong>News</strong></h2>
			<p>Official update<br/></p>
			
		</div>
	</div>
	
				<ul class="news wrapper">
				<c:forEach var="l" items="${list}">
					<li>
					<a href="#" ><img src="${pageContext.request.contextPath}/online/timg.jpg" tppabs="http://mc18.eatdou.com/uploads/131102/1-131102210K4H1.jpg" /></a>
					<div class="newslist">
						<a href="#"  style="color: blue">${l.title}</a>
						<span >Time:${l.date} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Author:${l.author}</span>
						<p> &nbsp; &nbsp; &nbsp; &nbsp;${l.content}</p>
					</div>
			</li>
				
				</c:forEach>
                
			<%-- <li>
				<a href="#" tppabs="http://mc18.eatdou.com/news/hynews/9.html"><img src="${pageContext.request.contextPath}/online/timg.jpg" tppabs="http://mc18.eatdou.com/uploads/131101/1-1311012213054G.png" data-original="" alt="百度免费＂发武器＂ 布局移动互联网" /></a>
				<div class="newslist">
					<a href="#" tppabs="http://mc18.eatdou.com/news/hynews/9.html" style="color: blue">百度免费＂发武器＂ 布局移动互联网</a>
					<span>UPTATED:2013/11/01</span>
					<p>中广网北京9月3日消息 据经济之声《天下公司》报道，说起百度，恐怕听众朋友们都不会陌生。这家创办于2001年1月1日的中文互联网搜索公司，经过十余年的发展，已经从最初的不足10人，成长....</p>
				</div>
			</li><li>
				<a href="hynews/8.html" tppabs="http://mc18.eatdou.com/news/hynews/8.html"><img src="${pageContext.request.contextPath}/online/timg.jpg" tppabs="http://mc18.eatdou.com/uploads/131101/1-13110122115U92.png" data-original="" alt="企业网站已经悄悄的转变成了一种网络营销应用" /></a>
				<div class="newslist">
					<a href="#" tppabs="http://mc18.eatdou.com/news/hynews/8.html" style="color: blue">企业网站已经悄悄的转变成了一种网络营销应用</a>
					<span>UPTATED:2013/11/01</span>
					<p>当是你最后一次使用的电话簿找到的产品或服务？如果你有一台电脑，平板电脑或智能手机的技术和访问，甚至有基本的了解，这可能是很难记住，当你拖着那么大，笨重的大部头，并翻阅它，....</p>
				</div>
			</li><li>
				<a href="#" tppabs="http://mc18.eatdou.com/news/gsnews/7.html"><img src="${pageContext.request.contextPath}/online/timg.jpg" tppabs="http://mc18.eatdou.com/uploads/131031/1-1310312352421V.jpg" data-original="" alt="html5+js技术网站应用案例：三盛·都会城网站建设" /></a>
				<div class="newslist">
					<a href="gsnews/7.html" tppabs="http://mc18.eatdou.com/news/gsnews/7.html" style="color: blue">html5+js技术网站应用案例：三盛·都会城网站建设</a>
					<span>UPTATED:2013/11/01</span>
					<p>三盛·都会城作为三盛地产在成都的全资开发项目，入主龙泉经开区，承载三盛地产在成都建立品牌的任务，三盛·都会城总投入近40亿元，前期将投入3亿重金，将该项目打造为龙泉乃至大成东....</p>
				</div>
			</li> --%>
					</ul>
		 <div class="dede_pages">
			<ul class="pagelist">
             <li><span class="pageinfo">Total <strong>1</strong>Page<strong>4</strong></span></li>

			</ul>
		</div>
</section>

<jsp:include page="p_foot.jsp"></jsp:include>

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