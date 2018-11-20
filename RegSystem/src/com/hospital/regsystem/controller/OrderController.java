/**
 * @author         zchangyu
 * @Date           2018年3月31日 上午12:25:57
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.regsystem.dao.IDoctorDao;
import com.hospital.regsystem.message.Config;
import com.hospital.regsystem.message.HttpUtil;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.Officelist;
import com.hospital.regsystem.pojo.Order;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IOfficelistService;
import com.hospital.regsystem.service.IOrderService;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.utils.IPUtils;
import com.hospital.regsystem.utils.OrderIdUtils;


@Controller()
public class OrderController {
	private Logger logger = Logger.getLogger(OrderController.class);
	@Resource(name="patientService")
	private IPatientService patientService;
	@Resource(name="officelistService")
	private IOfficelistService officelistService;
	@Resource(name="officeService")
	private IOfficeService officeService;
	@Resource(name="orderService")
	private IOrderService orderService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	String startTime="";
	String endTime="";
	String officeVal="";
	String dname="";
	//普通挂号next
	@RequestMapping("/ordernext")
	public @ResponseBody void orderNext(String dates, String period,String officeval){
		officeVal=officeval;
		String date=dates.split("<br>")[0];
		String per=period.split("<br>")[0];
		
		SimpleDateFormat s1=new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat s2=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d=s1.parse(date);
			String string=s2.format(d);
			if(per.equals("AM")){
				startTime=string+" 08:00:00";
				endTime=string+" 12:00:00";
			}
			if(per.equals("PM")){
				startTime=string+" 14:00:00";
				endTime=string+" 18:00:00";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	// 专家挂号next
	@RequestMapping("/orderPronext")
	public @ResponseBody void orderPronext(String dates, String period, String officeval, String d) {
		officeVal = officeval;
		dname = d;
		String date = dates.split("<br>")[0];
		String per = period.split("<br>")[0];
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = s1.parse(date);
			String string = s2.format(d1);
			if (per.equals("AM")) {
				startTime = string + " 08:00:00";
				endTime = string + " 12:00:00";
			}
			if (per.equals("PM")) {
				startTime = string + " 14:00:00";
				endTime = string + " 18:00:00";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	//普通挂号填写信息页面
	@RequestMapping("p_orderUI")
	public String p_orderUI(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("officeVal", officeVal);
		request.getSession().setAttribute("startTime", startTime);
		request.getSession().setAttribute("endTime", endTime);
		request.getSession().setAttribute("officeVal", officeVal);
		return "order_next";
		
	}

	// 专家挂号填写信息页面
	@RequestMapping("p_pro_orderUI")
	public String p_pro_orderUI(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("startTime", startTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("officeVal", officeVal);
		request.setAttribute("d", dname);
		request.getSession().setAttribute("startTime", startTime);
		request.getSession().setAttribute("endTime", endTime);
		request.getSession().setAttribute("officeVal", officeVal);
		request.getSession().setAttribute("d", dname);
		return "order_pro_next";

	}
	//普通号预定下单
	@RequestMapping("/porder")
	public String porder(HttpServletRequest request,String checkCode){
		//获取病情描述
		String desc="";
		try {
			desc=new String(request.getParameter("desc").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String username=(String) request.getSession().getAttribute("userName");
		//获取系统正确验证码
		String checkcode=(String) request.getSession().getAttribute("checkcode");
		//预约开始时间
		String dateStart=(String) request.getSession().getAttribute("startTime");
		/*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateStart=null;
		try {
			dateStart=simpleDateFormat.parse(startTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//预约截止时间
		String dateEnd=(String) request.getSession().getAttribute("endTime");
		/*Date dateEnd=null;
		try {
			dateEnd=simpleDateFormat.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//预约科室
		String officeVal=(String) request.getSession().getAttribute("officeVal");
		//科室对应的ID
		Office office=officeService.selectOfficeByOname(officeVal);
		String lowCheckcode=checkcode.toLowerCase();
		if(checkCode==null || checkCode.equals("")){
			request.getSession().setAttribute("startTime", startTime);
			request.getSession().setAttribute("endTime", endTime);
			request.getSession().setAttribute("officeVal", officeVal);
			request.setAttribute("message", "验证码不能为空！");
			return "order_next";
		}else if(!checkCode.equals(checkcode) && !checkCode.equals(lowCheckcode)){
			request.getSession().setAttribute("startTime", startTime);
			request.getSession().setAttribute("endTime", endTime);
			request.getSession().setAttribute("officeVal", officeVal);
			request.setAttribute("message", "验证码错误！");
			return "order_next";
		}
		Patient patient=patientService.checkUser(username);
		//判断余额是否够
		if(patient.getAccount()<3){
			request.setAttribute("reason", "您的账户余额不足，请及时充值！");
			logger.error("用户"+IPUtils.getIp(request)+"（病人）" + username + " 挂普通号失败，原因：账户余额不足。");
			return "order_fail";
		}
		//判断是否冲突
		Order order=orderService.selectOrder(patient.getPid(), startTime);
		if(order!=null){
			request.setAttribute("reason", "同一时间段您的预约有冲突，建议您重新预约！");
			logger.error("用户"+IPUtils.getIp(request)+"（病人）" + username + " 挂普通号失败，原因：同一时间段预约有冲突。");
			return "order_fail";
		}
		/**
		 * 开始进入Order流程
		 * 1.扣钱  patient表
		 * 2.减少 增加  安排表
		 * 3.insert orders 同时展示信息，查询房间信息  以及医生姓名  
		 * 
		 */
		
		//更新安排表 已挂人数  now 剩余can挂号人数
		officelistService.update(office.getOid(), dateStart);
		//查出安排计划  获取did医生姓名  nowregis人数
		Officelist officelist=officelistService.select(office.getOid(), dateStart,dateEnd);
		//获取did oid科室  查出医生姓名
		Doctor doctor=doctorService.selectById(officelist.getDid(),officelist.getOid());
		//订单号   A+1804011709+01+001
		String uuid=OrderIdUtils.getOrderId("A", office.getOid(), officelist.getNowregis());
		//insert 正式写入订单表
		Date time=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regtime=s.format(time);
		int state=1;
		orderService.insert(uuid,patient.getPid(),office.getOid(),doctor.getDid(),desc,state,regtime,dateStart,dateEnd);
		//扣钱-3元
		patientService.updateAccThree(patient.getPid());
		request.setAttribute("uuid", uuid);
		request.setAttribute("start", startTime);
		request.setAttribute("end", endTime);
		request.setAttribute("office", office.getOname());
		request.setAttribute("doctor", doctor.getDname());
		request.setAttribute("place", doctor.getPlace());
		
		/*
		 * 发信息提示
		 */
		String operation = "/industrySMS/sendSMS";
		String accountSid = Config.ACCOUNT_SID;
		String templateid = "225779967";
		String to =patient.getTel();
		// API接口调用
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(templateid, "UTF-8");
		} catch (Exception e) {

		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + tmpSmsContent
				+ HttpUtil.createCommonParam() + "&param="+patient.getPname()+"," + uuid.substring(uuid.length()-5, uuid.length())+","+startTime;
		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
		
		logger.error("用户"+IPUtils.getIp(request)+"（病人）" + username + " 挂普通号成功，"+officeVal+",医生为"+doctor.getDname()+",时间为"+startTime);
		return "order_success";
		
	}
	
	
	/*
	 * 专家号预定下单 2018.04.25
	 */
	@RequestMapping("/pro_order")
	public String pro_porder(HttpServletRequest request, String checkCode) {
		// 获取病情描述
		String desc = "";
		try {
			desc = new String(request.getParameter("desc").getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String username = (String) request.getSession().getAttribute("userName");
		// 获取系统正确验证码
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		// 预约开始时间
		String dateStart = (String) request.getSession().getAttribute("startTime");
		// 预约截止时间
		String dateEnd = (String) request.getSession().getAttribute("endTime");
		// 预约科室
		String officeVal = (String) request.getSession().getAttribute("officeVal");
		// 科室对应的ID
		Office office = officeService.selectOfficeByOname(officeVal);
		String lowCheckcode = checkcode.toLowerCase();
		if (checkCode == null || checkCode.equals("")) {
			request.getSession().setAttribute("startTime", startTime);
			request.getSession().setAttribute("endTime", endTime);
			request.getSession().setAttribute("officeVal", officeVal);
			request.setAttribute("message", "验证码不能为空！");
			return "order_next";
		} else if (!checkCode.equals(checkcode) && !checkCode.equals(lowCheckcode)) {
			request.getSession().setAttribute("startTime", startTime);
			request.getSession().setAttribute("endTime", endTime);
			request.getSession().setAttribute("officeVal", officeVal);
			request.setAttribute("message", "验证码错误！");
			return "order_next";
		}
		Patient patient = patientService.checkUser(username);
		// 判断余额是否够
		if (patient.getAccount() < 5) {
			request.setAttribute("reason", "您的账户余额不足，请及时充值！");
			logger.error("用户" + IPUtils.getIp(request) + "（病人）" + username + " 挂专家号失败，原因：账户余额不足。");
			return "order_fail";
		}
		// 判断是否冲突
		Order order = orderService.selectOrder(patient.getPid(), startTime);
		if (order != null) {
			request.setAttribute("reason", "同一时间段您的预约有冲突，建议您重新预约！");
			logger.error("用户" + IPUtils.getIp(request) + "（病人）" + username + " 挂专家号失败，原因：同一时间段预约有冲突。");
			return "order_fail";
		}
		/**
		 * 开始进入Order流程 1.扣钱 patient表 2.减少 增加 安排表 3.insert orders 同时展示信息，查询房间信息
		 * 以及医生姓名
		 * 
		 */

		// 更新安排表 已挂人数 now 剩余can挂号人数
		officelistService.update(office.getOid(), dateStart);
		// 查出安排计划 获取did医生姓名 nowregis人数
		Officelist officelist = officelistService.select(office.getOid(), dateStart, dateEnd);
		// 获取did oid科室 查出医生姓名
		String dname=(String) request.getSession().getAttribute("d");
		Doctor doctor = doctorService.selectByDname(dname, officelist.getOid());
		// 订单号 A+1804011709+01+001
		String uuid = OrderIdUtils.getOrderId("B", office.getOid(), officelist.getNowregis());
		// insert 正式写入订单表
		Date time = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regtime = s.format(time);
		int state = 1;
		orderService.insert(uuid, patient.getPid(), office.getOid(), doctor.getDid(), desc, state, regtime, dateStart,
				dateEnd);
		// 扣钱-5元
		patientService.updateAccFive(patient.getPid());
		request.setAttribute("uuid", uuid);
		request.setAttribute("start", startTime);
		request.setAttribute("end", endTime);
		request.setAttribute("office", office.getOname());
		request.setAttribute("doctor", dname);
		request.setAttribute("place", doctor.getPlace());

		/*
		 * 发信息提示
		 */
		String operation = "/industrySMS/sendSMS";
		String accountSid = Config.ACCOUNT_SID;
		String templateid = "225779967";
		String to = patient.getTel();
		// API接口调用
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(templateid, "UTF-8");
		} catch (Exception e) {

		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + tmpSmsContent
				+ HttpUtil.createCommonParam() + "&param=" + patient.getPname() + ","
				+ uuid.substring(uuid.length() - 5, uuid.length()) + "," + startTime;
		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);

		logger.error("用户" + IPUtils.getIp(request) + "（病人）" + username + " 挂专家号成功，" + officeVal + ",医生为"
				+ doctor.getDname() + ",时间为" + startTime);
		return "order_success";

	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOfficeVal() {
		return officeVal;
	}
	public void setOfficeVal(String officeVal) {
		this.officeVal = officeVal;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
