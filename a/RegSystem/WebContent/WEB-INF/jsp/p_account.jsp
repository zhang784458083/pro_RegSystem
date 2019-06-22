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
<title>My Account</title>
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
			<h2>My Account</h2>
			 <p><br/><br/><font size="3px">View account balance</font></p> 
		</div>
	</div> 
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
	<form action="${pageContext.request.contextPath}/pay" method="post" class="form form-horizontal" id="form-member-add">
		
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Your current available balance：</label>
        <div class="formControls col-xs-8">
          <span><font color=black size="4px">${account}YUAN</font></span>
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Your current available balance：</label>
        <div class="formControls col-xs-8">
          <input type="text" class="input-text" value="" placeholder="" id="p3_Amt" name="p3_Amt" style="width: 50px"><font color=black size="4px">&nbsp;元</font><font color=red size="3px">(note: during the test phase, the recharge amount is divided into units. For example, it only needs to enter 0.01 to recharge 1 yuan.)</font>
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Please select the bank：</label>
        <div class="formControls col-xs-8">
          <span>
          <input type="radio" name="pd_FrpId" value="ABC-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/nongye.gif" >
          	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/zhongguo.gif" >
        	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/jianshe.gif" ><br>
        	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/gongshang.gif" >
			<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/jiaotong.gif" >
          	<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/zhaohang.gif" ><br>
          	<input type="radio" name="pd_FrpId" value="POST-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/youzheng.gif" >
			<input type="radio" name="pd_FrpId" value="CEB-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/guangda.gif" >
          	<input type="radio" name="pd_FrpId" value="CMBC-NET-B2C">&nbsp;<img alt="" src="${pageContext.request.contextPath}/banklogo/minsheng.gif" ><br>
        </span>
        </div>
     	
      </div>
     <div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input type="submit" class="btn btn-success radius size-L"  value="&nbsp;Pay&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
	
	//校验病情描述的内容
	$("#desc").blur(function(){
		var d=$("#desc").val();
		if(d==""){
			$("#tishi").text("病情描述不能为空！");
		}else{
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