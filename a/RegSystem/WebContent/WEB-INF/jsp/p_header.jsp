<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=1024" />
<meta name="baidu-site-verification" content="3ztG4oI0ku" />
<title>My Web</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="client/css/style.css"  type="text/css" media="all" />
<!--[if lt IE 9]><script type="text/javascript" src="js/html5.js"></script><![endif]-->
</head>
<header>
	<div id="navbg"></div>
	<div class="wrapper">
		<h1 class="logo">
			<!-- <a href="pindex"  title="">
				<img src="client/images/logo.png" width="213" height="36" alt="" />
			</a> -->
			<font size="6" color="white">Regist platform</font>
		</h1>
		<nav>
			<ul>
				<li class="home"><a href="pindex" >Home<span>homepage</span></a></li>
				<c:if test="${not empty patient }">
					<li class="about"><a href="orderUI" title="Platform services">Booking<span>
we do</span></a></li>
				</c:if>
				<c:if test="${empty patient }">
					<li class="about"><a href="ploginUI" title="Platform services ">Booking<span>we do </span></a></li>
				</c:if>
				<li class="cases"><a href="sysabout" title="Booking information">Information<span>How do</span></a></li>
				<li class="service"><a href="news" title="News">Announce<span>Information </span></a></li>
				
				<c:if test="${not empty patient }">
				<li class="client"><a href="pcenter"  title="Personal center">${patient.pname}<span>My accoun</span></a></li>
				<li class="client"><a href="plogout"  title="Log out">Logout<span>Log back</span></a></li>
				</c:if>
				<c:if test="${empty patient }">
				<li class="client"><a href="ploginUI"  title="Personal center">Center<span>registered</span></a></li>
				<!-- <li class="client"><a href=""  title="退出系统">退出<span>重新登录</span></a></li> -->
				</c:if>
			</ul>
		</nav>
        	</div>
</header>
<script type="text/javascript" src="client/js/jquery.1.8.2.min.js"></script>
<script type="text/javascript" src="client/js/jquery.plugin.min.js"></script>
<script type="text/javascript">
//<![CDATA[
	//Nav Start
	$("header>div>nav>ul>li>a").hover(function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"6px",opacity:"0.7"},{duration:"normal", easing: "easeOutElastic"});
	},function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"10px",opacity:"1"},{duration:"normal", easing: "easeOutElastic"});
	});
	<!--- 首页 ---->
	$('.ad_img,#banner_ctr,#client').pngFix();
	$(window).scroll(function(){
		$(this).scrollTop()>80?$("#navbg").stop(false,true).animate({opacity:"1"},"normal"):$("#navbg").stop(false,true).animate({opacity:"0.8"},"normal");
	});
	//Banner Start
	var curIndex=0;
	var time=800;
	var slideTime=5000;
	var adTxt=$("#banner_img>li>div>.ad_txt");
	var adImg=$("#banner_img>li>div>.ad_img");
	var int=setInterval("autoSlide()",slideTime);

	$("#banner_ctr>ul>li[class!='first-item'][class!='last-item']").click(function(){
		show($(this).index("#banner_ctr>ul>li[class!='first-item'][class!='last-item']"));
		window.clearInterval(int);
		int=setInterval("autoSlide()",slideTime);
	});
	
	function autoSlide(){
		curIndex+1>=$("#banner_img>li").size()?curIndex=-1:false;
		show(curIndex+1);
	}
	function show(index){
		$.easing.def="easeOutQuad";
		$("#drag_ctr,#drag_arrow").stop(false,true).animate({left:index*115+20},300);
		$("#banner_img>li").eq(curIndex).stop(false,true).fadeOut(time);
		adTxt.eq(curIndex).stop(false,true).animate({top:"340px"},time);
		adImg.eq(curIndex).stop(false,true).animate({right:"120px"},time);
		setTimeout(function(){
			$("#banner_img>li").eq(index).stop(false,true).fadeIn(time);
			adTxt.eq(index).children("p").css({paddingTop:"50px",paddingBottom:"50px"}).stop(false,true).animate({paddingTop:"0",paddingBottom:"0"},time);
			adTxt.eq(index).css({top:"0",opacity:"0"}).stop(false,true).animate({top:"170px",opacity:"1"},time);
			adImg.eq(index).css({right:"-50px",opacity:"0"}).stop(false,true).animate({right:"10px",opacity:"1"},time);
		},200)
		curIndex=index;
	}
	//Banner End
	//Cases Start
	if($.support.transition){
		$("#cases>ul>li").hover(function(){
			$("img",this).stop(false,true).transition({
				perspective: '300px',
				rotateY: '180deg',
				opacity: '0'
			});
			$("p",this).css({display:'block',opacity:'0',rotateY: '-180deg'}).stop(false,true).transition({
				perspective: '300px',
				rotateY: '0deg',
				opacity: '1'
			});
		},function(){
			$("img",this).show().stop(false,true).transition({
				perspective: '300px',
				rotateY: '0deg',
				opacity: '1'
			});
			$("p",this).stop(false,true).transition({
				perspective: '300px',
				rotateY: '180deg',
				opacity: '0'
			});
		});
	}else{
		$("#cases>ul>li").hover(function(){
			$("img",this).stop(false,true).slideUp("fast");
			$("p",this).stop(false,true).slideDown("fast");
		},function(){
			$("img",this).stop(false,true).slideDown("fast");
			$("p",this).stop(false,true).slideUp("fast");
		});
	}
	$("#cases>ul>li>img").lazyload({effect:"fadeIn",failurelimit:10});
						$("#gotop").click(function(){$('body,html').animate({scrollTop:0},500);})
	
//]]>
</script>
</body>
</html>