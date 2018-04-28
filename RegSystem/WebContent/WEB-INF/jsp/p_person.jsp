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
<title>我的资料</title>
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
			<h2>个人资料</h2>
			 <p><br/><br/><font size="3px">修改个人信息</font></p> 
		</div>
	</div> 
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
	<form action="${pageContext.request.contextPath}/update" method="post" class="form form-horizontal" id="form-member-add" onsubmit="return aa()">
		
     <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3">用户名</label>
        <div class="formControls col-xs-8">
          <input type="text" class="input-text" value="${p.userName}" placeholder=""  disabled="disabled" >
        </div>
     	
      </div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">姓名：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" value="${p.pname}" placeholder=""  disabled="disabled" id="pname" name="pname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">性别：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" value="${p.sex}"  disabled="disabled" placeholder="" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">身份证号：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" value="${p.idNumber}"  disabled="disabled" placeholder="" id="idNumber" name="idNumber">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">生日：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" value="${p.birthday}" placeholder=""  disabled="disabled" >
			</div>	
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">邮箱：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text" placeholder="@" name="email" id="email" value="${p.email}">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">通讯地址：</label>
			<div class="formControls col-xs-8 "><!--  <span class="select-box"> -->
				<input type="text" class="input-text" placeholder="" name="pdesc" id="pdesc" value="${p.pdesc}">
				<!-- </span> --> </div>
		</div> 
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text " value="${p.tel}" placeholder="" id="tel" name="tel" >
				<br/>
				<input class="btn btn-success " type="button" value="获取验证码" id="onclickmsg" onclick="settime(this);gettel();">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>短信验证码：</label>
			<div class="formControls col-xs-8 ">
				<input type="text" class="input-text size-s" value="" placeholder="" id="msg" name="msg">
			</div>
		</div>
		<font color="red" size="3px" style="margin-left: 250px">${error}</font>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;修改信息&nbsp;&nbsp;" >
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
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
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
	$.get(url, data, function(data) {
		
	})
}


function settime(val) { 
	if($("#tel").val() == "" || isNaN($("#tel").val()) || $("#tel").val().length != 11 ){  
		alert("请填写正确的手机号！");  
        return false;  
    }
    if (countdown == 0) {  
        val.removeAttribute("disabled");  
        val.value="获取验证码";  
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


	function aa() {
		if ($("#msg").val() == "") {
			alert("验证码不能为空！");
			return false;
		}
		return true;

	}
	

	$(function() {
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});

		$("#form-member-add").validate({
			rules : {
				username : {
					required : true,
					minlength : 2,
					maxlength : 16
				},
				sex : {
					required : true,
				},
				mobile : {
					required : true,
					isMobile : true,
				},
				idNumber : {
					required : true,
					minlength : 18,
					maxlength : 18
				},
				email : {
					//required:true,
					email : true,
				},
				uploadfile : {
					required : true,
				},

			},
			onkeyup : false,
			focusCleanup : true,
			success : "valid",
			submitHandler : function(form) {
				//$(form).ajaxSubmit();
				var index = parent.layer.getFrameIndex(window.name);
				//parent.$('.btn-refresh').click();
				parent.layer.close(index);
			}
		});

		//校验病情描述的内容
		$("#desc").blur(function() {
			var d = $("#desc").val();
			if (d == "") {
				$("#tishi").text("病情描述不能为空！");
			} else {
				$("#tishi").text("");
			}
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