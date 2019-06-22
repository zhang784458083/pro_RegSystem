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
	<form action="" method="post" class="form form-horizontal" id="form-member-add"><br><p></p>
		
		
<div class="row cl" style="margin-left: 150px">
        	<label class="form-label col-xs-4 col-sm-3">Choose a hospital</label>
        <div class="formControls col-xs-8">
					<span>
					<select id="usertype" name="usertype" class="select"
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
						style="width: 300px;"onchange="changeSelect(this.selectedIndex)">
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
	 <p></p>
	 <font size="4"><font id="office1">${oname}</font> <font id="d">${dname}</font>Visiting schedule：</font>
	<p></p>
   	  <div>
   	  
   	  	<table  class="table" border="2" cellspacing="0"  id="table" >
        	<tr height="50px" >
        		<td style="text-align: center"><a title="已经是第一页了！" ><i class="Hui-iconfont" >&#xe69b;</i></a></td>
        		<td style="text-align: center">${d1}<br>${w1}（Tomorrow）</td>
        		<td style="text-align: center">${d2}<br>${w2}</td>
        		<td style="text-align: center">${d3}<br>${w3}</td>
        		<td style="text-align: center">${d4}<br>${w4}</td>
        		<td style="text-align: center">${d5}<br>${w5}</td>
        		<td style="text-align: center">${d6}<br>${w6}</td>
        		<td style="text-align: center">${d7}<br>${w7}</td>
        		<td style="text-align: center"><a title="目前只支持提前7天预约！" ><i class="Hui-iconfont">&nbsp;&nbsp;&#xe69a;&nbsp;&nbsp;</i></a></td>
        	</tr>
        	<tr height="90px">
        		<td style="text-align: center">AM<br>8:00-12:00</td>
        		<c:if test="${a1 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a1 gt 0 && a1 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(1,2,this);">remaining ${a1}<br></a></td>
        		</c:if>
        		<c:if test="${a1 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		
        		<c:if test="${a2 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a2 gt 0 && a2 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(2,2,this);">remaining ${a2}<br></a></td>
        		</c:if>
        		<c:if test="${a2 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${a3 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a3 gt 0 && a3 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(3,2,this);">remaining ${a3}<br></a></td>
        		</c:if>
        		<c:if test="${a3 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${a4 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a4 gt 0 && a4 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(4,2,this);">remaining ${a4}<br></a></td>
        		</c:if>
        		<c:if test="${a4 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${a5 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a5 gt 0 && a5 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(5,2,this);">remaining ${a5}<br></a></td>
        		</c:if>
        		<c:if test="${a5 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${a6 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a6 gt 0 && a6 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(6,2,this);">remaining  ${a6}<br></a></td>
        		</c:if>
        		<c:if test="${a6 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${a7 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${a7 gt 0 && a7 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(7,2,this);">remaining ${a7}<br></a></td>
        		</c:if>
        		<c:if test="${a7 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<td></td>
        	</tr>
        	<tr height="100px">
        		<td style="text-align: center">下午<br>2:00-6:00</td>
        		<c:if test="${p1 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p1 gt 0 && p1 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(1,3,this);">remaining ${p1}<br></a></td>
        		</c:if>
        		<c:if test="${p1 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		
        		<c:if test="${p2 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p2 gt 0 && p2 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(2,3,this);">remaining ${p2}<br></a></td>
        		</c:if>
        		<c:if test="${p2 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${p3 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p3 gt 0 && p3 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(3,3,this);">remaining ${p3}<br></a></td>
        		</c:if>
        		<c:if test="${p3 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${p4 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p4 gt 0 && p4 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(4,3,this);">remaining ${p4}<br></a></td>
        		</c:if>
        		<c:if test="${p4 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${p5 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p5 gt 0 && p5 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(5,3,this);">remaining ${p5}<br></a></td>
        		</c:if>
        		<c:if test="${p5 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${p6 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p6 gt 0 && p6 lt 999}">
        			<td style="text-align: center"><a href="javascript:void(0);" onclick="order_next(6,3,this);">remaining ${p6}<br></a></td>
        		</c:if>
        		<c:if test="${p6 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<c:if test="${p7 ge 999}">
        			<td style="text-align: center">STOP</td>
        		</c:if>
        		<c:if test="${p7 gt 0 && p7 lt 999}">
        			<td style="text-align: center"><a  href="javascript:void(0);" onclick="order_next(7,3,this);">remaining ${p7}<br></a></td>
        		</c:if>
        		<c:if test="${p7 eq 0 }">
        			<td style="text-align: center">Full</td>
        		</c:if>
        		<td></td>
        	</tr>
        	</table>
   	  
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
	if(office=="-1"){
		$("#span").text("请选择科室！");
		return false;
	}
	if(office!="-1"){
		$("#span").text("");
	}
	var office2=document.getElementById("doc").value;
	if(office2=="-1"){
		$("#span1").text("请选择专家姓名！");
		return false;
	}
};
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
});
function order_next(a,b,node){
    //日期
    var valueTd1=document.getElementById ("table").rows [0].cells[a];
    var dates=valueTd1.innerHTML;
    //上午还是下午？
    var valueTd=document .getElementById ("table").rows [b-1].cells[0];
    var period=valueTd.innerHTML ;
    var officeval=document.getElementById("office1").innerHTML;
    var d=document.getElementById("d").innerHTML;
    
	$.ajax({
	    type : "post",
	    url : "${pageContext.request.contextPath}/orderPronext",
	    //contentType : "application/json; charset=utf-8",
	    dataType : "json",
	    data : {dates: dates, period: period,officeval:officeval,d:d},
	    success : function(data) {
	    	window.location.href = "p_pro_orderUI";
	    },
	    error : function(data) {
	    	window.location.href = "p_pro_orderUI";
	    }
	});
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