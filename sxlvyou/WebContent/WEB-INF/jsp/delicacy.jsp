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

        	<img src="${pageContext.request.contextPath}/images/ms.png" width="1000" height="187" alt="" title="">        </div>

		<!--banner end--> 

		

		<!--content-->

		<div class="content clearfix">

        	<div class="leftbar">

            	<div class="leftnav">

                	<h1>魅力山西</h1>

                	<ul class="ul_left">

                    

                    

       <li><h3><a href="beautiful">旅游风景</a></h3>

</li>
		 <li><h3><a href="tourism">旅游景点</a></h3>

</li>
		<li><h3><a href="delicacy">山西美食</a></h3>

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

            	<div class="bread"><a href="index">首页</a> >山西美食</div>

            	<ul class="ul_zj clearfix">
 				<c:forEach items="${list}" var="l">
					<li>
                    <a href="${pageContext.request.contextPath}/sxmsintro?id=${l.id}" ><img src="${pageContext.request.contextPath}/images/${l.img}" width="220" height="140" ></a><span><a href="${pageContext.request.contextPath}/sxmsintro?id=${l.id}">${l.title}</a></span>

                  </li>
					
				</c:forEach>


                </ul>

                <div class="paging"></div>

            </div>

        </div>

		<!--content end--> 

</div>

<!--footer开始-->

<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>