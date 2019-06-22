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
	<form action="${pageContext.request.contextPath}/officelistPro" method="post" class="form form-horizontal" id="form-member-add" ><br><p></p>
		
		
<div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">Choose a hospital</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="hospital" name="hospital" class="select"
						style="width: 300px;background-color: gray" disabled="disabled">
							<!-- <option value="0">请选择</option> -->
							<option value="1">First people's hospital</option>
					</select>
					</span>
				</div>
      </div>
		
		<div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">Choose department</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="office" name="office" class="select"
						style="width: 300px;" onchange="changeSelect(this.selectedIndex)">
							<!-- <option value="-1">请选择</option>
							<option value="1">眼科</option>
							<option value="2">骨科</option>
							<option value="3">儿科</option> -->
					</select>
					</span>&nbsp;&nbsp;<span ><font id="span" color="red" size="3px"></font></span>
				</div>
      </div>
      <div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">Visits experts</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="doc" name="doc" class="select"
						style="width: 300px;">
							<!-- <option value="-1">请选择</option>
							<option value="1">张</option>
							<option value="2">李</option>
							<option value="3">王</option> -->
					</select>
					</span>&nbsp;&nbsp;<span ><font id="span1" color="red" size="3px"></font></span>
				</div>
      </div>
      <div class="row cl" style="margin-left: 200px">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;search&nbsp;&nbsp;" id="submit" onclick="return check()">
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
var arr_province = ["Choose","eye","The orthopaedic","pediatric","Internal medicine"];
var arr_city = [
                ["Choose"],
                ["Zhang","Wang"],
                ['Li'],
                ['Guo'],
                ['Ceshi']
                
            ];
//网页加载完成，初始化菜单
window.onload = init;//传入函数地址
function init(){
    //首先获取对象
    var province = document.getElementById("office");
    var city = document.getElementById("doc");

    //指定省份中<option>标记的个数
    province.length = arr_province.length;

    //循环将数组中的数据写入<option>标记中
    for(var i=0;i<arr_province.length;i++){
        province.options[i].text = arr_province[i];
        province.options[i].value = arr_province[i];
    }

    //修改省份列表的默认选择项
    var index = 0;
    province.selectedIndex = index;

    //指定城市中<option>标记的个数
    city.length = arr_city[index].length;

    //循环将数组中的数据写入<option>标记中
    for (var j = 0; j<arr_city[index].length;j++) {
        city.options[j].text = arr_city[index][j];
        city.options[j].value = arr_city[index][j];
    }

}

function  changeSelect(index){
    //选择对象
    var province = document.getElementById("office");
    var city = document.getElementById("doc");
    //修改省份列表的选择项
    province.selectedIndex = index;

    //指定城市中<option>标记的个数
    city.length = arr_city[index].length;

    //循环将数组中的数据写入<option>标记中
    for (var j = 0; j<arr_city[index].length;j++) {
        city.options[j].text = arr_city[index][j];
        city.options[j].value = arr_city[index][j];
    }
}
function check(){
	var office=document.getElementById("office").value;
	if(office=="请选择"){
		$("#span").text("请选择科室！");
		return false;
	}
	if(office!="请选择"){
		$("#span").text("");
	}
	var office2=document.getElementById("doc").value;
	if(office2=="请选择"){
		$("#span1").text("请选择专家姓名！");
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