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
<title>The online registration</title>
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
			<h2>Please fill in carefully</h2>
			 <p><br/><br/><font size="3px">Your exclusive reservation order</font></p> 
		</div>
	</div> 
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <div id="loginform" class="loginBox"> -->
	<form action="${pageContext.request.contextPath}/porder" method="post" class="form form-horizontal" id="form-member-add" onsubmit="return checkForm()">
		<div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>The department you choose</label>
        <div class="formControls col-xs-8">
          <span><font color="black" size="4px">${officeVal}</font></span>
        	<input type="hidden" id="officeVal" value="${officeVal}"/>
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Your appointment time</label>
        <div class="formControls col-xs-8">
          <span><font color=black size="4px">${startTime}</font><font color="black" size="4px">-- </font><font color="black" size="4px">${endTime}</font></span>
        	<input type="hidden" id="startTime" value="${startTime}"/>
        	<input type="hidden" id="endTime" value="${endTime}"/>
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Your doctor</label>
        <div class="formControls col-xs-8">
          <span><font color="gray" size="4px">The system assigns it to you</font></span>
        	
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" >*</span>Description of your illness</label>
        <div class="formControls col-xs-8">
          <input type="text" class="input-text" value="" placeholder="" id="desc" name="desc">
          <span ><font id="tishi" color="red" size="3px"></font></span>
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Registration fee</label>
        <div class="formControls col-xs-8">
          <span><font color=blue size="4px" id="cost">3</font><font color=blue size="4px">YUAN</font></span>
         
        </div>
     	
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red" ></span>Payment method</label>
        <div class="formControls col-xs-8">
          <span><select  class="select"
						style="width: 300px;background-color: gray" disabled="disabled">
							<!-- <option value="0">请选择</option> -->
							<option value="1">The account balance</option>
					</select></span>
         <span ><font color="red" size="3px">&nbsp;Please make sure the balance is sufficient!</font></span>
        </div>
     	
      </div>
		
		<div class="row cl">
      	 <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Verification code</label>
        <div class="formControls col-xs-8 ">
          <input id="code" class="input-text size-L" type="text" placeholder="Verification code" name="checkCode"  onclick="if(this.value=='Verification code:'){this.value='';}" value="" style="width:150px;">
          <img src="${pageContext.request.contextPath}/codeServlet" id="newcode"> <a id="kanbuq" href="javascript:;" >switch</a> <br><font color="red" size="4px" >${message}</font></div>
     
      </div>
      
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;Submit&nbsp;&nbsp;" >
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
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
function checkForm() {
	
    if (window.confirm("No cancellation is allowed after the reservation. Are you sure about submitting it?")) {
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
	
	//校验病情描述的内容
	$("#desc").blur(function(){
		var d=$("#desc").val();
		if(d==""){
			$("#tishi").text("Description of illness cannot be empty!");
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