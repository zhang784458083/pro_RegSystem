<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<meta name="viewport" content="width=1024" />
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<title>Login to center</title>
<meta name="keywords" content="" />
<meta name="description" content="" />      
<link rel="stylesheet" href="client/css/style.css" type="text/css" media="all" />
<!--[if lt IE 9]><script type="text/javascript" src="../js/html5.js" ></script><![endif]-->
</head>
<body>

<jsp:include page="p_header.jsp"></jsp:include>
<section id="single">
	<!-- 查找子栏目  -->
	<div class="cat_title">
		<div class="wrapper">
			<h2><strong>Login</strong></h2>
			<p>Center<br/>About</p>
		</div>
	</div> 
	<!-- <div class="category">
		<div class="wrapper">
			<h1>关于</h1>
            
            <ul class="catbtn">
            
			</ul>
		</div>
	</div> -->
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
		  <form class="form form-horizontal" action="${pageContext.request.contextPath}/plogin" method="post">
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Username</label>
        <div class="formControls col-xs-8">
          <input id="username" name="username" type="text" placeholder="用户名" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Password</label>
        <div class="formControls col-xs-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
      	  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Verification code</label>
        <div class="formControls col-xs-8 ">
          <input id="code" class="input-text size-L" type="text" placeholder="验证码" name="checkCode"  onclick="if(this.value=='Verification code:'){this.value='';}" value="" style="width:150px;">
          <img src="${pageContext.request.contextPath}/codeServlet" id="newcode"> <a id="kanbuq" href="javascript:;" >Switch</a> </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="autoLogin" value="1" > Automatic login
          </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <label for="online">
             <input type="checkbox" name="rememberme" value="1" ${not empty cookie.remembermeCookie ? "checked='checked'" : " "}> Remember the username
          </label>
        </div>
        <span id="span" style="margin-left: 265px;" ><font color="red" size="4px" >${message}</font></span>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input  id="submit" name="" onclick="" type="submit" class="btn btn-success radius size-L" value="&nbsp;Submit&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <!-- <!-- <input  id="toreg" name="" type="button" class="btn btn-success radius size-L" value="&nbsp;Regist&nbsp;" onclick="pindex"><br> --> 
          <!-- <button id="reg" class="btn btn-success radius size-L" onclick="window.location.href='/preg'">&nbsp;Regist&nbsp;</button> -->
          <input   name="" onclick="window.location.href='pregUI'" class="btn btn-success radius size-L" type="button" class="btn btn-success radius size-L" value="&nbsp;Regist&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       	  <input  name="" onclick="" type="button" class="btn btn-success radius size-L" value="&nbsp;Retrieve password&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
      </div>
    </form>
    
    
   <!--  </div> -->
		<!-- <p class="t4">
		



		</p> -->
<!-- <div class="t4Content">
<ul>
<li>我们致力于为顾客提供网站建设系统、网站管理系统、网站维护系统。</li>
<li>我们专注于企业网站设计制作，为企业提供全程网络解决方案。</li>
</ul>
</div> -->
<!-- <p class="t4">[GOMEEN,中文世界最专业的会议活动平台]</p>
<div class="t4Content">
<ul>
<li>共鸣网致力于在专业化层面为大众提供一个便捷有效的活动、会议网络平台。通过会议发布、会议选址、与会人员统计、专家稿件审查、审稿回馈、酒店预订、旅游线路规划等一体化服务，简化办会事宜，明晰会议进程，让你轻松办会，轻松共鸣。</li>
<li>网址：<a href="javascript:if(confirm('http://www.mycodes.net/'))window.location='http://www.mycodes.net/'"  target="_blank">http://www.mycodes.net/</a></li>
</ul>
</div> -->
        </div>
		<div id="case_footer"></div>
	</article>
</section>
<jsp:include page="p_foot.jsp"></jsp:include>
<script type="text/javascript" src="client/js/jquery.1.8.2.min.js" ></script>
<script type="text/javascript" src="client/js/jquery.plugin.min.js" ></script>
<!--[if IE 6]>client
<script type="text/javascript" src="../js/killie6.js" ></script>
<![endif]-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">
//<![CDATA[
	//Nav Start
	//生成验证码
 		$(function(){
 			$("#kanbuq").click(function(){
 				document.getElementById("newcode").src = 'codeServlet?ts='+new Date().getTime();
 			}) 
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