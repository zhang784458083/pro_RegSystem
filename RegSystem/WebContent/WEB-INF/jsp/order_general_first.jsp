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
<title>开始挂号</title>
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
			<h2><strong>开始挂号</strong></h2>
			<p><br/>开启便捷服务</p>
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
	<form action="${pageContext.request.contextPath}/officelist" method="post" class="form form-horizontal" id="form-member-add"><br><p></p>
		
		
<div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">选择医院</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="hospital" name="hospital" class="select"
						style="width: 300px;background-color: gray" disabled="disabled">
							<!-- <option value="0">请选择</option> -->
							<option value="1">第一人民医院</option>
					</select>
					</span>
				</div>
      </div>
		
		<div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">选择科室</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="office" name="office" class="select"
						style="width: 300px;">
							<option value="-1">请选择</option>
							<option value="1">眼科</option>
							<option value="2">骨科</option>
							<option value="3">儿科</option>
					</select>
					</span>&nbsp;&nbsp;<span ><font id="span" color="red" size="3px"></font></span>
				</div>
      </div>
      <div class="row cl" style="margin-left: 200px">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;检索科室排班表&nbsp;&nbsp;" id="submit" onclick="return check()">
			</div>
			
	 </div> 
	
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

function check(){
	var office=document.getElementById("office").value;
	if(office=="-1"){
		$("#span").text("请选择科室！");
		return false;
	}
};

</script> 
<script type="text/javascript">
//<![CDATA[
	
		//Nav End
$("#gotop").click(function(){$('body,html').animate({scrollTop:0},500);})
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F3fe5b2b119b5fc4931e9c73e7071b0c6' type='text/javascript'%3E%3C/script%3E"));
	var bds_config = {"bdTop":203};
	$("#bdshell_js").attr("src","http://share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours());
//]]>
</script></body>
</html>