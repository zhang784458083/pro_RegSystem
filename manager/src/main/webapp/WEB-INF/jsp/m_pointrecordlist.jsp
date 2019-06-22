<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>积分记录</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>营销记录管理 <span class="c-gray en">&gt;</span> 积分记录<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<form class="form form-horizontal" action="${pageContext.request.contextPath}/m_pointrecordlist" method="post">
	 <div class="text-c"> 
		时间：<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" name="datemax" id="datemin"class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" name="datemin" id="datemax"class="input-text Wdate" style="width:120px;">
		
		姓名：<input type="text" class="input-text" style="width:250px" placeholder="输入姓名" id="" name="name" value="">
		电话：<input type="text" class="input-text" style="width:250px" placeholder="输入电话" id="" name="tele" value="">
		
		
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜记录</button>
		<a title="导出" href="javascript:;" onclick="member_export(this,'1')"class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe640;</i>导出Excel</a> 
	</div>
	 </form>
	 <div class="cl pd-5 bg-1 bk-gray mt-20">  <!-- <span class="l"> <a href="javascript:;" onclick="member_add('添加顾客信息','adduserui','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加顾客信息</a></span>  --></div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="20">时间</th>
				<th width="20">类型</th>
				<th width="20">顾客</th>
				<th width="20">电话</th>
				<th width="20">原有积分(分)</th>
				<th width="20">变动积分(分)</th>
				<th width="20">现有积分(分)</th>
				<th width="40">明细</th>
				<th width="20">操作员</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n" >
				<tr class="text-c">
				<td>${n.service_time }</td>
				<td>${n.record_name }</td>
				<td>${n.user_name}</td>
				<td>${n.user_tele }</td>
				<td>${n.user_old }</td>
				<td>${n.user_num }</td>
				<td>${n.user_new }</td>
				<td>${n.content }</td>
				<td>${n.manager }</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 0, "asc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  //{"orderable":false,"aTargets":[8,9]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	var d={id:id};
	layer.confirm('确认删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'deleteuser',
			dataType: 'json',
			data:d,
			success: function(data){
				
			},
			error:function(data) {
				//$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none"  href="javascript:;" title="已浇水"><i class="Hui-iconfont">&#xe6b2;</i></a>');
				//$(obj).parents("tr").find(".td-manage").html('<a style="text-decoration:none"  href="javascript:;" title="已浇水"><i class="Hui-iconfont">已浇水</i></a>');
				
				$(obj).parents("tr").remove();
				layer.msg('已删除！',{icon:6,time:3000});
			},
		});		
	});
}
/*用户-导出*/
function member_export(obj,id){
	var d={id:id};
	layer.confirm('确认导出吗？',function(index){
		$.ajax({
			type: 'POST',
			url: 'downPR',
			dataType: 'json',
			data:d,
			success: function(data){
				
			},
			error:function(data) {
				//$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none"  href="javascript:;" title="已浇水"><i class="Hui-iconfont">&#xe6b2;</i></a>');
				//$(obj).parents("tr").find(".td-manage").html('<a style="text-decoration:none"  href="javascript:;" title="已浇水"><i class="Hui-iconfont">已浇水</i></a>');
				//$(obj).parents("tr").remove();
				layer.msg('已导出到D盘！',{icon:6,time:3000});
			},
		});		
	});
}
</script> 
</body>
</html>