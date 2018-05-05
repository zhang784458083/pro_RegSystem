/**
 * @author         zchangyu
 * @Date           2018年3月2日 下午6:09:46
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.message.Config;
import com.hospital.regsystem.message.HttpUtil;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.EntityOrder;
import com.hospital.regsystem.pojo.Notice;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.Order;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.INoticeService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IOrderService;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.utils.IPUtils;


@Controller()
public class PatientController {

	private Logger logger = Logger.getLogger(PatientController.class);
	@Resource(name="patientService")
	private IPatientService patientService;
	@Resource(name="orderService")
	private IOrderService orderService;
	@Resource(name="officeService")
	private IOfficeService officeService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	@Resource(name="noticeService")
	private INoticeService noticeService;
	//跳转关于我们页面
	@RequestMapping("/sysabout")
	public String aboutUs(){
		return "sys_about";
	}
	//跳转新闻资讯
	@RequestMapping("/news")
	public String news(HttpServletRequest req,HttpServletResponse resp){
		List<Notice> list=noticeService.selectAll();
		req.setAttribute("list", list);
		return "p_news";
	}
	//跳转登录页面
	@RequestMapping("/ploginUI")
	public String plogin(){
		return "p_login";
	}
	//跳转注册页面
	@RequestMapping("/pregUI")
	public String pregUI(){
		
		return "p_reg";
	}
	
	@RequestMapping("/preg")
	public String preg(HttpServletRequest request,Patient p,String checkCode){
		//获取系统正确验证码
		String checkcode=(String) request.getSession().getAttribute("checkcode");
		String lowCheckcode=checkcode.toLowerCase();
		Date d=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String regDate=simpleDateFormat.format(d);
		try {
			//默认会员状态启用状态
			p.setState("1");
			p.setRegdate(regDate);
			p.setPname(new String(p.getPname().getBytes("ISO-8859-1"),"UTF-8"));
			p.setSex(new String(p.getSex().getBytes("ISO-8859-1"),"UTF-8"));
			p.setPdesc(new String(p.getPdesc().getBytes("ISO-8859-1"),"UTF-8"));
			p.setAccount(5);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(checkCode==null || checkCode.equals("")){
			request.setAttribute("message", "验证码不能为空！");
			return "p_reg";
		}else if(!checkCode.equals(checkcode) && !checkCode.equals(lowCheckcode)){
			request.setAttribute("message", "验证码错误！");
			return "p_reg";
		}
		String code=request.getParameter("msg");
		Object object=request.getSession().getAttribute("x");
		if(object==null){
			request.setAttribute("message", "手机短信验证码错误！");
			return "p_reg";
		}
		int xx=(int) object;
		String x=(""+xx+"").trim();
		if(!code.equals(x)){
			request.setAttribute("message", "手机短信验证码错误！");
			return "p_reg";
		}
		request.getSession().removeAttribute("x");
		//注册会员
		patientService.reg(p);
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+p.getUserName()+" 注册成功！");
		return "p_reg_success";
	}
	@RequestMapping("/checkusername")
	public void checkuser(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String username=req.getParameter("username");
		Patient patient=patientService.checkUser(username);
		if(patient==null){
			resp.getWriter().println(1);
		}else{
			resp.getWriter().println(patient.getTel());
		}
		
	}
	@RequestMapping("/pcenter")
	public String pcenter(HttpServletRequest request){
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		List<Order> orderList=orderService.selectOrderById(patient.getPid());
		Iterator<Order> iterator=orderList.iterator();
		List<EntityOrder> entityOrderList=new ArrayList<EntityOrder>();
		while(iterator.hasNext()){
			Order order=iterator.next();
			EntityOrder entityOrder=new EntityOrder();
			Office office=officeService.selectOfficeById(order.getOid());
			entityOrder.setOid(order.getOrderid());
			entityOrder.setOname(office.getOname());
			entityOrder.setRegtime(order.getRegtime().substring(0, order.getRegtime().length()-2));
			Doctor doctor=doctorService.selectById(order.getDid(), order.getOid());
			entityOrder.setDname(doctor.getDname());
			entityOrder.setPlace(doctor.getPlace());
			entityOrder.setDesc(order.getDesc());
			entityOrder.setStarttime(order.getRunstarttime().substring(0, order.getRunstarttime().length()-2));
			entityOrder.setEndtime(order.getRunendtime().substring(0, order.getRunendtime().length()-2));
			if(order.getState()==1){
				entityOrder.setState("已预约");
			}else if(order.getState()==2){
				entityOrder.setState("进行中");
			}else if(order.getState()==3){
				entityOrder.setState("已完成");
			}else{
				entityOrder.setState("未知");
			}
			entityOrderList.add(entityOrder);
		}
		request.setAttribute("entityOrderList", entityOrderList);
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 查看个人订单！");
		return "p_center";
		
	}
	
	@RequestMapping("/paccount")
	public String paccountUI(HttpServletRequest request){
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		String username=(String) request.getSession().getAttribute("userName");
		Patient patient1=patientService.checkUser(username);
		//double account=patient.getAccount();
		request.setAttribute("account", patient1.getAccount());
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 查看账户余额！");
		return "p_account";
		
	}
	
	@RequestMapping("/personUI")
	public String personUI(HttpServletRequest request){
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		request.setAttribute("p", patient);
		return "p_person";
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request) throws Exception{
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		String tel=request.getParameter("tel");
		String code=request.getParameter("msg");
		Object object=request.getSession().getAttribute("x");
		if(object==null){
			request.setAttribute("error", "验证码错误！");
			return "p_backpwdui";
		}
		int xx=(int) object;
		String x=(""+xx+"").trim();
		String email=request.getParameter("email");
		String pdesc=new String(request.getParameter("pdesc").getBytes("ISO-8859-1"),"UTF-8");
		if(!code.equals(x)){
			request.setAttribute("p", patient);
			request.setAttribute("error", "验证码错误！");
			return "p_person";
		}
		request.getSession().removeAttribute("x");
		//修改个人资料
		patientService.update(patient.getPid(),tel,email,pdesc);
		
		//Patient patient2=patientService.checkUser(patient.getUserName());
		//request.setAttribute("p", patient2);
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 修改个人信息成功！");
		return "p_update_success";
	}
	
	//修改信息验证码
	@RequestMapping("/gettel")
	public void gettel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String tel=request.getParameter("tel");
		request.getSession().setAttribute("tel", tel);
		String operation = "/industrySMS/sendSMS";
		String accountSid = Config.ACCOUNT_SID;
		String templateid = "224745576";
		String to =(String) request.getSession().getAttribute("tel");
		int x;
		Random ne = new Random();// 实例化一个random的对象ne
		x = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999
		request.getSession().setAttribute("x", x);
		// API接口调用
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(templateid, "UTF-8");
		} catch (Exception e) {

		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + tmpSmsContent
				+ HttpUtil.createCommonParam() + "&param=" + x;
		// 提交请求
		String result = HttpUtil.post(url, body);
		//System.out.println("result:" + System.lineSeparator() + result);
		
	}
	
	//注册验证码
	@RequestMapping("/regsend")
	public void sendreg(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String tel=request.getParameter("tel");
		request.getSession().setAttribute("tel", tel);
		String operation = "/industrySMS/sendSMS";
		String accountSid = Config.ACCOUNT_SID;
		String templateid = "224746588";
		String to =(String) request.getSession().getAttribute("tel");
		int x;
		Random ne = new Random();// 实例化一个random的对象ne
		x = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999
		request.getSession().setAttribute("x", x);
		// API接口调用
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(templateid, "UTF-8");
		} catch (Exception e) {

		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + tmpSmsContent
				+ HttpUtil.createCommonParam() + "&param=" + x;
		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
	
	
	@RequestMapping("/backpwdui")
	public String backPWDui(){
		
		return "p_backpwdui";
	}
	@RequestMapping("/backpwd")
	public String backPWD(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("msg");
		Object object=request.getSession().getAttribute("x");
		if(object==null){
			request.setAttribute("error", "验证码错误！");
			return "p_backpwdui";
		}
		int xx=(int) object;
		String x=(""+xx+"").trim();
		if(!code.equals(x)){
			request.setAttribute("error", "验证码错误！");
			return "p_backpwdui";
		}
		request.getSession().removeAttribute("x");
		patientService.updatepwd(pwd,username);
		
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+username+" 找回密码成功！");
		return "p_login";
	}
	
	//重置密码
	@RequestMapping("/resetpwd")
	public String resetpwd(HttpServletRequest request,HttpServletResponse response){
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login";
		}
		String pwd=request.getParameter("pwd");
		String old=request.getParameter("old");
		String code=request.getParameter("msg");
		if(!old.equals(patient.getPwd())){
			request.setAttribute("username", patient.getUserName());
			request.setAttribute("error", "原密码错误！");
			return "p_resetpwd";
		}
		Object object=request.getSession().getAttribute("x");
		if(object==null){
			request.setAttribute("username", patient.getUserName());
			request.setAttribute("error", "验证码错误！");
			return "p_resetpwd";
		}
		int xx=(int) object;
		String x=(""+xx+"").trim();
		if(!code.equals(x)){
			request.setAttribute("username", patient.getUserName());
			request.setAttribute("error", "验证码错误！");
			return "p_resetpwd";
		}
		request.getSession().removeAttribute("x");
		patientService.updatepwd(pwd,patient.getUserName());
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 重置密码成功！");
		return "p_reset_success";
	}
	
	//重置密码
	@RequestMapping("/resetpwdUI")
	public String resetUI(HttpServletRequest request){
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		if(patient!=null){
			request.setAttribute("username", patient.getUserName());
			request.setAttribute("tel", patient.getTel());
			return "p_resetpwd"; 
		}
		else{
			return "p_login";
		}
	}
}
