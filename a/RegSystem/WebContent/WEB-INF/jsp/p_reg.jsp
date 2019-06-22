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
<title>Registered</title>
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
			<h2><strong>Registered</strong></h2>
			<p>Join<br/>Enjoy convenient service</p>
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
		  <form action="${pageContext.request.contextPath}/preg" method="post" class="form form-horizontal" id="form-member-add" onsubmit="return checkForm()">
		<div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Username</label>
        <div class="formControls col-xs-8">
          <input id="username" name="userName" type="text" placeholder="username" class="input-text size-L">use a combination of "Numbers, case letters" 
        <br><font id="user" color="red" size="2px"></font>
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Password</label>
        <div class="formControls col-xs-8">
          <input id="password1" name="" type="password" placeholder="password" class="input-text size-L">
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
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Name：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="pname" name="pname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Sex：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="sex" type="radio" value="man" id="sex-1" checked >
					<label for="sex-1">Man</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="sex" value="woman">
					<label for="sex-2">Woman</label>
				</div>
				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>ID Card：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="idNumber" name="idNumber">
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Bir：</label>
			<div class="formControls col-xs-8 col-sm-9">
			
			<input type="text" id="bir" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="birthday" name="birthday" class="input-text Wdate" style="width:120px;">
			<font size="3px" >example：1999-09-19</font>
			<span ><font id="birspan" color="red" size="3px"></font></span>
			</div>		
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Tel：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="tel" name="tel">
				<br/>
				<input class="btn btn-success " type="button" value="Get verification code" id="onclickmsg" onclick="settime(this);gettel();">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>verification code：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text size-s" value="" placeholder="" id="msg" name="msg">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">email：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="@" name="email" id="email">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">附件：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file-2" class="input-file">
				</span> </div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">Place：</label>
			<div class="formControls col-xs-8 col-sm-9"><!--  <span class="select-box"> -->
				<input type="text" class="input-text" placeholder="" name="pdesc" id="pdesc">
				<!-- </span> --> </div>
		</div> 
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所在城市：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="city">
					<option value="" selected>请选择城市</option>
					<option value="1">北京</option>
					<option value="2">上海</option>
					<option value="3">广州</option>
				</select>
				</span> </div>
		</div> -->
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div> -->
		<div class="row cl">
      	 <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>verification code</label>
        <div class="formControls col-xs-8 ">
          <input id="code" class="input-text size-L" type="text" placeholder="验证码" name="checkCode"  onclick="if(this.value=='验证码:'){this.value='';}" value="" style="width:150px;">
          <img src="${pageContext.request.contextPath}/codeServlet" id="newcode"> <a id="kanbuq" href="javascript:;" >Switch</a> <font color="red" size="4px" >${message}</font></div>
     
      </div>
      
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;submit&nbsp;&nbsp;">
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

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">


//倒计时  
var countdown=120;
function gettel() {
	var url = "${pageContext.request.contextPath}/regsend";
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
        val.value="Get the verification code";  
        countdown = 120;  
        return false;  
    } else {  
		val.setAttribute("disabled", true);
		val.value = "To resend(" + countdown + ")";
		countdown--;
	}
    
	setTimeout(function() {
		settime(val);
	}, 1000);
}

function checkForm() {
	if ($("#username").val() == "") {
		alert("用户名不能为空！");
		return false;
	}
	if ($("#password").val() == "") {
		alert("密码不能为空！");
		return false;
	}
	if ($("#pname").val() == "") {
		alert("姓名不能为空！");
		return false;
	}
	if ($("#idNumber").val() == "") {
		alert("身份证号不能为空！");
		return false;
	}
	if ($("#bir").val() == "") {
		alert("生日不能为空！");
		return false;
	}
	if ($("#tel").val() == "") {
		alert("手机号不能为空！");
		return false;
	}
	if ($("#msg").val() == "") {
		alert("手机号验证码不能为空！");
		return false;
	}
	if ($("#code").val() == "") {
		alert("验证码不能为空！");
		return false;
	}
    if (window.confirm("Do you confirm that the information is correct?")) {
     	return true;
    }
    
    return false;
   }
		


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
			$("#pwd").text("inconsistency！");
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
						$("#user").text("User name available");
					} else {
						$("#user").text("The user name is occupied");
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
					$("#userMsg").text("User name available");
				} else {
					$("#userMsg").text("The user name is occupied");
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
/* $("#gotop").click(function(){$('body,html').animate({scrollTop:0},500);})
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F3fe5b2b119b5fc4931e9c73e7071b0c6' type='text/javascript'%3E%3C/script%3E"));
	var bds_config = {"bdTop":203};
	$("#bdshell_js").attr("src","http://share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours()); */
//]]>
</script></body>
</html>