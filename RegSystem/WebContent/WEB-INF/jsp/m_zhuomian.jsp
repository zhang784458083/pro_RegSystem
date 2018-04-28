<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
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
<title>我的桌面</title>
</head>
<body>
<div class="page-container">
	<p class="f-20 text-success" >欢迎使用社区<font size="5">&nbsp;e&nbsp;</font>院挂号监测平台 <span class="f-14" >Beta2.0</span></p>
	<!-- <p>登录次数：18 </p> -->
	<p>本次登录IP：${ip}  &nbsp;当前系统时间：<span id="show"></span></p>
	<div id="member" style="min-width:700px;height:400px"></div><br><br>
	<div id="container" style="min-width:700px;height:400px"></div>
	<!-- <table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th colspan="7" scope="col">信息统计</th>
			</tr>
			<tr class="text-c">
				<th>统计</th>
				<th>资讯库</th>
				<th>图片库</th>
				<th>产品库</th>
				<th>用户</th>
				<th>管理员</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
				<td>总数</td>
				<td>92</td>
				<td>9</td>
				<td>0</td>
				<td>8</td>
				<td>20</td>
			</tr>
			<tr class="text-c">
				<td>今日</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>昨日</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>本周</td>
				<td>2</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
			<tr class="text-c">
				<td>本月</td>
				<td>2</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
				<td>0</td>
			</tr>
		</tbody>
	</table> -->
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">服务器信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th width="30%">服务器计算机名</th>
				<td><span id="lbServerName">${computerName}</span></td>
			</tr>
			
			<tr>
				<td>服务器域名</td>
				<td>www.tysyzcy.top</td>
			</tr>
			<tr>
				<td>服务器端口 </td>
				<td>80</td>
			</tr>
			<tr>
				<td>操作系统版本 </td>
				<td>${caozuo}</td>
			</tr>
			<tr>
				<td>操作系统架构 </td>
				<td>${jiagou}</td>
			</tr>
			<tr>
				<td>操作系统版本 </td>
				<td>${version}</td>
			</tr>
			<tr>
				<td>服务器的语言种类 </td>
				<td>Chinese (People's Republic of China)</td>
			</tr>
			
			<tr>
				<td>CPU 总数 </td>
				<td>4</td>
			</tr>
			<tr>
				<td>CPU 类型 </td>
				<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
			</tr>
			
			
			<tr>
				<td>当前系统用户名 </td>
				<td>SYSTEM</td>
			</tr>
		</tbody>
	</table>
</div>
<footer class="footer mt-20">
	<div class="container">
		<p><br>
			备案编号：晋ICP备17006459号<br>
			Copyright © 2017 - 2018 All rights reserved</p>
	</div>
</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript">
$(function () {
    Highcharts.chart('container', {
        title: {
            text: '最近一周各科室挂号情况',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: ['一月', '二月', '三月', '四月', '五月', '六月','七月']
        },
        yAxis: {
            title: {
                text: '挂号人数 (人)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '人'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '外科',
            data: [17.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2]
        },{
            name: 'Tokyo',
            data: [17.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2]
        },{
            name: 'Tokyo',
            data: [17.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2]
        },{
            name: 'Tokyo',
            data: [17.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2]
        },{
            name: 'Tokyo',
            data: [17.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2]
        }, {
            name: 'New York',
            data: [0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8]
        }, {
            name: 'Berlin',
            data: [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6]
        }, {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0]
        }]
    });
});

$(function () {
    Highcharts.chart('member', {
        title: {
            text: '最近一周会员注册情况',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: ['一月', '二月', '三月', '四月', '五月', '六月','七月']
        },
        yAxis: {
            title: {
                text: '新增会员 (人)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '人'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '新增会员人数',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0]
        }]
    });
});
</script>
 <script language="javascript">
 function run(){
	 var time = new Date();//获取系统当前时间
	 var year = time.getFullYear();
	 var month = time.getMonth()+1;
	 var date= time.getDate();//系统时间月份中的日
	 var day = time.getDay();//系统时间中的星期值
	 var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
	 var week = weeks[day];//显示为星期几
	 var hour = time.getHours();
	 var minutes = time.getMinutes();
	 var seconds = time.getSeconds();
	 console.log(seconds);
	 if(month<10){
	 month = "0"+month; 
	 }
	 if(date<10){
	 date = "0"+date; 
	 }
	 if(hour<10){
	 hour = "0"+hour; 
	 }
	 if(minutes<10){
	 minutes = "0"+minutes; 
	 }
	 if(seconds<10){
	 seconds = "0"+seconds; 
	 }
	 //var newDate = year+"年"+month+"月"+date+"日"+week+hour+":"+minutes+":"+seconds;
	 document.getElementById("show").innerHTML = year+"年"+month+"月"+date+"日"+week+"   "+hour+":"+minutes+":"+seconds;
	 setTimeout('run()',1000);
	 }
	  
	 run();
	 

        </script>
</body>
</html>