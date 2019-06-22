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
<title>啤酒管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>会员营销管理 <span class="c-gray en">&gt;</span> 啤酒管理<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<form class="form form-horizontal" action="${pageContext.request.contextPath}/m_beerlist" method="post">
	 <div class="text-c"> 
		
		姓名：<input type="text" class="input-text" style="width:250px" placeholder="输入姓名" id="" name="name" value="">
		电话：<input type="text" class="input-text" style="width:250px" placeholder="输入电话" id="" name="tele" value="">
		
		
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜顾客信息</button>
	</div>
	 </form>
	 <div class="cl pd-5 bg-1 bk-gray mt-20">  <!-- <span class="l"> <a href="javascript:;" onclick="member_add('添加顾客信息','adduserui','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加顾客信息</a></span>  --></div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="10">编号</th>
				<th width="20">姓名</th>
				<th width="20">电话</th>
				<th width="20">当前啤酒数量(瓶)</th>
				<th width="10">操作</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n" >
				<tr class="text-c">
				<td>${n.user_id }</td>
				<td>${n.user_name }</td>
				<td>${n.user_tele}</td>
				<td>${n.user_sum }</td>
				<td class="td-manage">
					<a title="充值啤酒" href="javascript:;" onclick="member_edit('充值啤酒','addbeerui?id=${n.user_id}','4','','510')" class="ml-5" style="text-decoration:none">充值</a>
					<a title="消费啤酒" href="javascript:;" onclick="member_edit('消费啤酒','reducebeerui?id=${n.user_id}','4','','510')" class="ml-5" style="text-decoration:none">消费</a>
			    </td>
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

</script> 
</body>
</html>