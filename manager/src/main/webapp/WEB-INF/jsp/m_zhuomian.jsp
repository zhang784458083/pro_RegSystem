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
<style>
body {
    font-size: 12px;
    line-height: 24px;
    text-algin: center;  
}
* {
    margin: 0px;
    padding: 0px;  
}
ul {
    list-style: none;
}
a img {
    border: none; 
}
a {
    color: #333;
    text-decoration: none;
}
a:hover {
    color: #ff0000;
}
#mooc {
    width: 519px;
    border: 5px solid #ababab;
    -moz-border-radius: 15px; 
    -webkit-border-radius: 15px; 
    border-radius: 15px;
    box-shadow: 2px 2px 10px #ababab;
    margin: 50px auto 0;
    text-align: left;  
}   
#moocTitle {
    height: 62px;
    overflow: hidden;
    font-size: 26px;
    line-height: 62px;
    padding-left: 30px;
    background-image: -moz-linear-gradient(top, #f05e6f, #c9394a); /* Firefox */
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #f05e6f), color-stop(1, #c9394a)); /* Saf4+, Chrome */
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#8fa1ff', endColorstr='#f05e6f', GradientType='0'); /* IE*/
    border: 1px solid ##f05e6f;
    -moz-border-radius: 8px 8px 0 0;
    -webkit-border-radius: 8px 8px 0 0;
    border-radius: 8px 8px 0 0;
    color: #fff;
    position: relative;
}
#moocTitle a {
    position: absolute;
    right: 10px;
    bottom: 10px;
    display: inline;
    color: #fff;
    font-size: 12px;
    line-height: 24px;
}
#moocBot {
    width: 599px;
    height: 10px;
    overflow: hidden; 
}
#moocBox {
    height: 144px;
    width: 435px;
    margin-left: 25px;
    margin-top: 10px;
    overflow: hidden;
}
#mooc ul li {
    height: 24px;
}
#mooc ul li a {
    width: 180px;
    float: left;
    display: block;
    overflow: hidden;
    text-indent: 15px;
    height: 24px;
}
#mooc ul li span {
    float: right;
    color: #999;
}
</style>
<title>我的桌面</title>
</head>
<body>
<div class="page-container">
	<p class="f-20 text-success" >欢迎使用会员营销管理系统 <span class="f-14" ></span></p>
	<!-- <p>登录次数：18 </p> -->
	<font  size="4px" >本次登录IP：${ip}  &nbsp;当前系统时间：<span id="show"></span></font><br>
		
        
		<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">终端服务信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th width="30%">服务器计算机名</th>
				<td><span id="lbServerName">${computerName}</span></td>
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
				<td>CPU 类型 </td>
				<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
			</tr>
			
		</tbody>
	</table>
		
</div>
&nbsp;&nbsp;<span ><font color="red" size="5px" ><i class="Hui-iconfont">&#xe62f;</i>&nbsp;&nbsp;请您保管好自己个人密码，不操作时请及时退出系统！</font></span>
	
<footer class="footer mt-20">
	<div class="container">
		 <!-- <p>
			备案编号：京ICP备17006459号<br>
			Copyright © 2018 - 2019 All rights reserved</p> -->
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
            data: [1, 2, 3, 4, 3, 4, 3]
        },{
            name: '眼科',
            data: [4, 1, 3, 3, 3, 6,8]
        },{
            name: '儿科',
            data: [1, 2, 2, 3, 4, 4, 5]
        },{
            name: '骨科',
            data: [0, 2, 3, 4,3, 5, 6]
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
            data: [3, 4, 5, 8, 11, 15, 17]
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
<script type="text/javascript">
	var area = document.getElementById('moocBox');
	var iliHeight = 24;//单行滚动的高度
	var speed = 50;//滚动的速度
	area.scrollTop = 0;
	area.innerHTML += area.innerHTML;//克隆一份一样的内容
	var timer = null;
	function startMove() {
		area.scrollTop++;
		if (area.scrollTop % iliHeight == 0) {
			clearInterval(timer);
			setTimeout("startMove()", 1000);
		} else {
			if (area.scrollTop >= area.scrollHeight / 2) {
				area.scrollTop = 0;
			}
			setTimeout("startMove()", 50);
		}
	}
	startMove();
</script>

</html>