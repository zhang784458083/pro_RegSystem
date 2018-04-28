<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />   
<meta name="viewport" content="width=1024" />
<title>预约须知</title>
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
			<h2><strong>预约挂号须知</strong></h2>
			<p><br/>温馨提示</p> 
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
一、预约挂号：
1、预约挂号时间范围
网络预约，可约次日起一个星期的号源。网络预约挂号支持24小时服务。
每日08:00开放最新一天号源，每日22:00点停止次日预约挂号。
2、预约条件
网上预约挂号均采取实名制注册预约，预约时须提供患者真实姓名、有效证件号（身份证、军官证、护照）、性别、电话、手机号码等基本信息。
3、患者预约成功后会收到预约成功短信及预约识别码。</P>
<p style="color:#123456;font-size:15px;">
二、预约取号：
1、预约成功后，请患者于就诊当日携带患者本人注册预约时的有效证件、银行卡及医保卡到医院自助挂号机上进行取号（医保报销用户须在医保自助机取号，在非医保自助机取号为自费），如预约登记信息有误，则无法正常取号就诊。
2、预约取号时间：就诊当日：上午号09:30前取号；下午号15:00前取号；过时未取号者，预约作废。
</P>
<p style="color:#123456;font-size:15px;">
三、 爽约处理：
1、如预约成功后患者未能按时就诊且不办理取消预约号视为爽约。
2、无故爽约累计达到3次将进入系统爽约名单，此后3个月内将无法享受预约挂号服务。
</P>
<p style="color:#123456;font-size:15px;">
四、医生停诊：
如遇特殊情况医生停诊，给您造成的不便尽请谅解。医生临时停诊，工作人员将会以电话方式及时通知您，请配合更改就诊日期或更换其它医生，请您保持电话畅通，如不能及时联系到您，我们将以短信形式通知您，请您关注。
</P>
<p style="color:#123456;font-size:15px;">
五、取消预约：
预约成功后如患者无法按时就诊，请在就诊前一日15:00前通过电话凭预约订单号办理预约取消。
</P>
<p style="color:#123456;font-size:15px;">
六、预约限制：
按照山西省卫生厅统一平台预约须知的要求，同一患者实名（有效证件号）在同一就诊日、同一医院、同一科室只能预约1次；在同一就诊日的预约总量不可超过2次；在七日内的预约总量不可超过3次；在三个月内预约总量不超过5次。
</P>
<p style="color:#123456;font-size:15px;">
七、其他注意事项：
①首次预约患者,预约时必须填写“真实姓名”用于建档备查，首次填写后无需再填写；
②预约成功的医保报销用户请首先确保为本院定点医保用户，首次来院就诊时需到窗口关联医保卡后，再到医院医保自助机取号就诊。预约成功的自费用户请在非医保自助机取号就医；
③使用身份证以外其它证件注册预约的患者，只能到窗口取号；
④预约成功后，请患者于就诊当日携带患者本人的有效证件、银行卡、医保卡、及预约识别码到医院自助挂号机上进行取号（医保报销用户须在医保自助机取号，在非医保自助机取号为自费），如预约登记信息有误，则无法正常取号就诊;
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
