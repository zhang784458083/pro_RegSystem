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

		<!--banner开始-->

		<div class="banner_erji">

        	<img src="${pageContext.request.contextPath}/images/hs.jpg" width="1000" height="187" alt="" title="">

        </div>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>话说山西</h1>

                	<ul class="ul_left">

                    

                    

        <li><h3><a href="introduce">山西简介</a></h3>

</li>

        

        <li><h3><a href="Culture">山西文化</a></h3>

</li>

        

        <li><h3><a href="historic">山西历史</a></h3>
		
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

            	<div class="bread"><a href="index">首页</a> > 旅游风景详情</div>

                

            	<div class="con_news">

                	<p class="p_tit2">

                    	<span>${p.title}</span>

                        发布人:${p.auther}　　发布时间：${p.date}

                  </p>

                	<div class="con">

               		   <p>

	<p>

		&nbsp;&nbsp;&nbsp;&nbsp;${p.content}


	</p>

	<p>

		<br />

	</p>

                    </div>

              </div>

              

               

               

            </div>

        </div>

		<!--content结束--> 

</div>

<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>