﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>社区医院远程挂号管理平台Beta2.0</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<!-- <div class="header"></div> -->
<div class="loginWraper"><br><br><br>
<font size="6px" style="margin-left: 400px;">社区医院远程挂号管理平台Beta2.0</font>
  <div id="loginform" class="loginBox">
  
    <form class="form form-horizontal" action="${pageContext.request.contextPath}/mlogin" method="post">
			
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="username" name="username" type="text" placeholder="用户名" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
      	 <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe637;</i></label>
        <div class="formControls col-xs-8 ">
          <input id="code" class="input-text size-L" type="text" placeholder="验证码" name="checkCode"  onclick="if(this.value=='验证码:'){this.value='';}" value="" style="width:150px;">
          <img src="${pageContext.request.contextPath}/codeServlet" id="newcode"> <a id="kanbuq" href="javascript:;" >看不清，换一张</a> </div>
      </div>
     <%--  <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="autoLogin" value="1" > 自动登录
          </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <label for="online">
             <input type="checkbox" name="rememberme" value="1" ${not empty cookie.remembermeCookie ? "checked='checked'" : " "}> 记住用户名
          </label>
        </div>
      </div> --%>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="submit" name="" onclick="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;"><br>
        </div>
      </div>
    </form>
    <span id="span" style="margin-left: 160px;" ><font color="red" size="4px" >${message}</font></span>
  </div>
</div>
<div class="footer">2017-2018 @Copyright 奋斗的青春最美丽Beta2.0</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>

 
 <script type="text/javascript" >
		//生成验证码
 		$(function(){
 			$("#kanbuq").click(function(){
 				document.getElementById("newcode").src = 'codeServlet?ts='+new Date().getTime();
 			}) 
 		});
 		
 		function validate(){
 			var username = $("#username").val();
 			var password = $("#password").val();
 			var code = $("#code").val();

 			if(username == null || username == ""){
 				document.getElementById("#span").innerHTML='用户密码不能为空...';
 				$("#span").html="用户名不能为空...";
 	        	return;
 				}
 			if(password == null || password == ""){
 				document.getElementById("#span").innerHTML='用户密码不能为空...';
 	        	return;
 				}
 			if(code == null || code== ""){
 				document.getElementById("#span").innerHTML='验证码不能为空...';
 	        	return;
 				}
 			}
 </script>
