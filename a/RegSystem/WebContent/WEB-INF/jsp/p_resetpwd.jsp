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
<title>Reset your password</title>
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
			<h2><strong>Reset your password</strong></h2>
			<!-- <p>个人中心<br/>关于我的一切</p> -->
		</div>
	</div> 
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
		  <form class="form form-horizontal" action="${pageContext.request.contextPath}/resetpwd" method="post" onsubmit="return checkForm()">
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Username</label>
        <div class="formControls col-xs-8">
          <input id="username" name="username" type="text" placeholder="用户名" class="input-text size-L" value="${username}" disabled="disabled">
        	 
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Old Password</label>
        <div class="formControls col-xs-8">
          <input id="old1" name="old" type="password" placeholder="密码" class="input-text size-L">
        	<font id="old" color="red" size="2px"></font>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>New Password</label>
        <div class="formControls col-xs-8">
          <input id="password1" name="" type="password" placeholder="密码" class="input-text size-L">
        	<font id="pwd1" color="red" size="2px"></font>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Sure Password</label>
        <div class="formControls col-xs-8">
          <input id="password" name="pwd" type="password" placeholder="密码" class="input-text size-L">
        	<font id="pwd" color="red" size="2px"></font>
        </div>
      </div>
      <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Tel：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" value="${tel}" placeholder="" id="tel" name="tel" disabled="disabled">
				<br/>
				<input class="btn btn-success " type="button" value="Get the verification code" id="onclickmsg" onclick="settime(this);gettel();">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Verification code：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text size-s" value="" placeholder="" id="msg" name="msg">
			</div>
		</div>
		<font color="red" size="3px" style="margin-left: 250px">${error}</font>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input  id="submit" name="" onclick="" type="submit" class="btn btn-success radius size-L" value="&nbsp;Reset password&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <!-- <input   name="" onclick="window.location.href='pregUI'" class="btn btn-success radius size-L" type="button" class="btn btn-success radius size-L" value="&nbsp;Regist&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
       	  <!-- <input  name="" onclick="" type="button" class="btn btn-success radius size-L" value="&nbsp;找回密码&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
        </div>
      </div>
    </form>
    
  

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
//倒计时  
var countdown=120;
function gettel() {
	var url = "${pageContext.request.contextPath}/gettel";
	var tel = $("#tel").val();
	var data = {
		//"method" : "gettel",
		"tel" : tel
	};
	$.post(url, data, function(data) {
		
	})
}
function settime(val) { 
	if($("#tel").val() == "" || isNaN($("#tel").val()) || $("#tel").val().length != 11 ){  
		alert("请填写正确的手机号！");  
        return false;  
    }
    if (countdown == 0) {  
        val.removeAttribute("disabled");  
        val.value="Verification code";  
        countdown = 120;  
        return false;  
    } else {  
		val.setAttribute("disabled", true);
		val.value = "重新发送(" + countdown + ")";
		countdown--;
	}
    
	setTimeout(function() {
		settime(val);
	}, 1000);
}

function checkForm() {
	if ($("#old1").val() == "") {
		alert("原密码不能为空！");
		return false;
	}
	if ($("#password").val() == "") {
		alert("新密码不能为空！");
		return false;
	}
	
	if ($("#tel").val() == "") {
		alert("不存在的用户名，导致手机号为空！请正确填写用户名！");
		return false;
	}
	if ($("#msg").val() == "") {
		alert("手机号验证码不能为空！");
		return false;
	}
	
    if (window.confirm("请再次确认提交信息？")) {
     	return true;
    }
    
    return false;
   }

//<![CDATA[
	//Nav Start
	//生成验证码
 		$(function(){
 			$("#kanbuq").click(function(){
 				document.getElementById("newcode").src = 'codeServlet?ts='+new Date().getTime();
 			}) 
 		});
 		//校验密码
 		
 		$("#password1").blur(function(){
 			var b1=$("#password1").val();
 			var patrn= /^[0-9a-zA-Z]+$/;
 			if(patrn.test(b1)!=true){
 				$("#pwd1").text("不能含有特殊字符！");
 			}
 			
 		});
 		$("#password1").focus(function(){
 		
 			$("#pwd1").text("");
 		});
 		$("#old1").focus(function(){
 	 		
 			$("#old").text("");
 		});
 		
 		$("#password").blur(function(){
 			var b1=$("#password1").val();
 			var b2=$("#password").val();		
 			if (b1 != b2){
 				$("#pwd").text("前后不一致！");
 			}
 		});
 		$("#password").focus(function(){
 			
 			$("#pwd").text("");
 		});
 		//自动获取手机号
 		//校验用户名
	$("#username").blur(function(){
		var username=$("#username").val();
		var url = "checkusername";
		
		var patrn= /^[0-9a-zA-Z]+$/;
		if(username==""){
			$("#user").text("用户名不能为空！");
		}else if(patrn.test(username) != true){
			$("#user").text("用户名格式有误！");
		}else{
			var data = {
					
					"username" : username
				};
				$.get(url, data, function(data) {
					if (data == 1) {
						$("#user").text("用户名不存在！");
						$("#tel").val("");
						
					} else {
						
						$("#user").text("用户名正确！");
						$("#tel").val(data);
						
					}
				})
		}
		
		
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