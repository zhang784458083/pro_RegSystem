<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<meta name="viewport" content="width=1024" />
<title>Booking information</title>
<meta name="keywords" content="这里填写关键词" />
<meta name="description" content="这里填写描述" />      
<link rel="stylesheet" href="client/css/style.css" type="text/css" media="all" />
<!--[if lt IE 9]><script type="text/javascript" src="../js/html5.js"></script><![endif]-->
</head>
<body >

<jsp:include page="p_header.jsp"></jsp:include>

<!-- 查找最顶级栏目  -->
<section id="single">
	<!-- 查找子栏目  -->
	<div class="cat_title">
		<div class="wrapper">
			<h2><strong>Booking information</strong></h2>
			<p><br/>Warm prompt</p> 
		</div>
	</div>
	
	<article class="serv_detailed">
		<div id="detailed">
		<!-- <p class="t4">[专业+专注]</p> -->
<div class="t4Content">
<ul>
<!-- <li>我们致力于为顾客提供网站建设系统、网站管理系统、网站维护系统。</li>
<li>我们专注于企业网站设计制作，为企业提供全程网络解决方案。</li> -->
</ul>
</div>
<p style="color:#123456;font-size:15px;">
I. appointment registration:

1. Time limit for booking registration

Online booking, can be about the next day a week from the source. Online booking registration supports 24-hour service.

The latest day source will be opened at 08:00 every day, and the next day registration will be suspended at 22:00 every day.

2. Reservation conditions

Online appointment booking registration is made by real-name registration. The patient's real name, valid certificate number (id card, military certificate, passport), gender, telephone number, mobile phone number and other basic information should be provided during the appointment.

3. The patient will receive a message and an appointment identification number after a successful appointment.</P>
<p style="color:#123456;font-size:15px;">
Ii. Reservation number:

1, after the success of the reservation, please carry the patients on the clinic day when I registered a patient get an appointment with the effective certificate, bank card, and medical insurance card number to self-service hospital registration machine to take (the user must be in the health care coverage self-service machine number, take in the health care self-service machine number for self-paid), such as booking registration information is wrong, is not normal, see a doctor.

2. Appointment date: date of visit: before 09:30 am; Pick up the number before 15:00 p.m. An appointment will be cancelled if the number is not registered.
</P>
<p style="color:#123456;font-size:15px;">
Iii. Non-compliance treatment:

1. If the patient fails to go to the hospital on time and does not cancel the appointment number after the appointment is made, the patient is deemed to have broken the appointment.

2. If the total number of unreasonably breaches reaches 3 times, it will enter the list of system cancellations. After that, it will not be able to enjoy the registration service within 3 months.
</P>
<p style="color:#123456;font-size:15px;">
Iv. Doctor's suspension:

Please understand the inconvenience caused by the doctor's suspension of medical consultation under special circumstances. The doctor is temporarily suspended, and the staff will inform you in time by telephone. Please help to change the date of visit or other doctors.
</P>
<p style="color:#123456;font-size:15px;">
V. cancellation:

If the patient cannot see the doctor on time after the appointment is made, please cancel the appointment by phone with the order number before 15:00 on the day before the appointment.
</P>
<p style="color:#123456;font-size:15px;">
Vi. Reservation restrictions:

According to the requirements of the reservation instructions of the unified platform of shanxi provincial health department, only one appointment can be made for the same patient's real name (valid certificate number) on the same day of treatment, the same hospital and the same department. The total number of appointments on the same day should not exceed 2 times. The total number of appointments within seven days shall not exceed 3; No more than 5 times within 3 months.
</P>
<p style="color:#123456;font-size:15px;">

</p>
<div class="t4Content">
<ul>
</ul>
</div>
        </div>
		<div id="case_footer"></div>
	</article>
</section>
<jsp:include page="p_foot.jsp"></jsp:include>
<script type="text/javascript" src="client//js/jquery.1.8.2.min.js"></script>
<script type="text/javascript" src="client//js/jquery.plugin.min.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="../js/killie6.js"></script>
<![endif]-->
<script type="text/javascript">
//<![CDATA[
	//Nav Start
	$("header>div>nav>ul>li>a").hover(function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"6px",opacity:"0.7"},{duration:"normal", easing: "easeOutElastic"});
	},function(){
		$(this).parent().stop(false,true).animate({"background-position-x":"10px",opacity:"1"},{duration:"normal", easing: "easeOutElastic"});
	});

		//Nav End
$("#gotop").click(function(){$('body,html').animate({scrollTop:0},500);})
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F3fe5b2b119b5fc4931e9c73e7071b0c6' type='text/javascript'%3E%3C/script%3E"));
	var bds_config = {"bdTop":203};
	$("#bdshell_js").attr("src","http://share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours());
//]]>
</script>
</body>
</html>
