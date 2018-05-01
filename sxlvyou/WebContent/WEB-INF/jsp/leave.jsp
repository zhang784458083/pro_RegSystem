<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>华夏古文明☆山西好风光</title>
<meta content="华夏古文明☆山西好风光" name="keywords" />

<meta content="华夏古文明☆山西好风光" name="description" />

<link href="css/base.css" rel="stylesheet" type="text/css">

<link href="css/pagename.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" src="js/jquery.SuperSlide.2.1.js"></script>

</head>
<body>
	
<jsp:include page="head.jsp"></jsp:include>

<div class="container"> 		

		<!--banner-->

		<div class="banner_erji">

        	<img src="${pageContext.request.contextPath}/images/banner_erji6.jpg" width="1000" height="187" alt="" title="">        </div>

		<!--banner end--> 

		

		<!--content-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>其他目录</h1>

                	<ul class="ul_left">

                    

                    

        <li>
          <h3><a href="leave">给我留言</a></h3>

</li>

        

        <li>
          <h3><a href="about">团队介绍</a></h3>

</li>

        

        <li>
          <h3><a href="connection">联系我们</a></h3>
		
</li>

        

         	</ul>

                 
              </div>

                <div class="left_lx">

                	<h1>联系方式</h1>

                    <p>地址：山西省晋中市榆次区大学街319号</p>

                      <p>联系人：寇蕴泽</p>

                      <p>电话：152-3426-5985</p>

                      <p>QQ：203369024</p>

                      <p>邮编：030619</p>

                </div>

            </div>

        	<div class="rightbar">

            	<div class="bread"><a href="index">首页</a> >给我留言</div>

                <div class="contact_nei">
               <form  action="${pageContext.request.contextPath}/liuyan" method="Post" onsubmit="return checkForm()">
	<ul>
		<li>
			<label>您的称呼：</label><input id="txtUserName" name="txtUserName" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的电话：</label><input id="txtUserTel" name="txtUserTel" type="text" class="yuyue_in" /> 
		</li>
		<li>
			<label>您的性别：</label><input type="radio" class="yuyue_ra" name="txtUserQQ" value="男" /> <em>男</em> <input name="txtUserQQ" value="女" type="radio" class="yuyue_ra" /> <em>女</em></li>
		<li>
			<label>你的留言：</label><textarea id="txtContent" name="txtContent" cols="" rows="" class="yuyue_te"></textarea> 
		</li>
		<li>
			<label>验证码：</label><input id="txtCode" name="txtCode" type="text" class="yuyue_in" style="width:100px;" /> <img src="${pageContext.request.contextPath}/codeServlet" width="80" height="22" align="absmiddle" id="img"/> <a id="kanbuq">看不清，换一张</a>		</li>
			<font color="red" size="4px" >${message}</font>
		<li>
			<input name="btnSubmit" id="btnSubmit" type="submit" value="提交" class="btn" /> <input name="" type="reset" value="重置" class="btn" /> 
		</li>
	</ul>
</form>
          

                </div>
               
               
               
            </div>
        </div>


		<!--content end--> 

</div>

<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
function checkForm() {
	if ($("#txtUserName").val() == "") {
		alert("您的称呼不能为空！");
		return false;
	}
	if ($("#txtUserTel").val() == "") {
		alert("您的电话不能为空！");
		return false;
	}
	
	if ($("#txtUserQQ").val() == "") {
		alert("您的性别不能为空！");
		return false;
	}
	if ($("#txtContent").val() == "") {
		alert("您的留言不能为空！");
		return false;
	}
	if ($("#txtCode").val() == "") {
		alert("验证码不能为空！");
		return false;
	}
	
    if (window.confirm("请再次确认提交信息？")) {
     	return true;
    }
    
    return false;
   }

$(function(){
		$("#kanbuq").click(function(){
			document.getElementById("img").src = 'codeServlet?ts='+new Date().getTime();
		}) 
	});
	
</script>
</html>