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
<title>To register</title>
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
			<h2><strong>To register</strong></h2>
			<p><br/>Enable convenient service</p>
		</div>
	</div> 
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
	<form action="${pageContext.request.contextPath}/preg" method="post" class="form form-horizontal" id="form-member-add"><br><p></p>
		<input id="pt" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;Ordinary&nbsp;&nbsp;" style="width:290px;height:300px;font-size: 50px;margin-left: 150px" onclick="javascript:window.location.href='generalUI'">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="zj" class="btn btn-success radius" type="button" value="&nbsp;&nbsp;experts&nbsp;&nbsp;" style="width:290px;height:300px;font-size: 50px"  onclick="javascript:window.location.href='expertUI'">
		
		
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
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">

	


$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			idNumber:{
				required:true,
				minlength:18,
				maxlength:18
			},
			email:{
				//required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
	$("#bir").blur(function(){
		var b=$("#bir").val();
		
		var guize=/^\d{4}\-\d{2}\-\d{2}$/;
		if (guize.test(b) != true){
			$("#birspan").text("日期不合法！");
		}else{
			$("#birspan").text("");
		}
	});
	$("#bir").focus(function(){
		
		$("#birspan").text("");
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
						$("#user").text("用户名可用");
					} else {
						$("#user").text("用户名被占用");
					}
				})
		}
		
		
	});
	
	$("#username").blur(function() {
		var url = "${pageContext.request.contextPath}/";
		var username = $("#username").val();
		if (username == "") {
			$("#userMsg").text("请输入用户名");
		} else {
			var data = {
				"method" : "checksername",
				"username" : username
			};
			$.get(url, data, function(data) {
				if (data == 1) {
					$("#userMsg").text("用户名可用");
				} else {
					$("#userMsg").text("用户名被占用");
				}
			})
		}
	});
	
	
	$("#username").focus(function(){
		
		$("#user").text("");
	});
});
</script> 
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