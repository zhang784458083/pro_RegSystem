/**
 * @author         zchangyu
 * @Date           2018年3月11日 上午12:25:53
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.hospital.regsystem.pojo.Chuzhen;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Manager;
import com.hospital.regsystem.pojo.Notice;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.Officelist;
import com.hospital.regsystem.pojo.Order;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.pojo.ReturnObj;
import com.hospital.regsystem.service.IChuzhenService;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.INoticeService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IOfficelistService;
import com.hospital.regsystem.service.IOrderService;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.service.IReturnObjService;
import com.hospital.regsystem.utils.IPUtils;
import com.sun.crypto.provider.DESKeyFactory;

@Controller
public class ManagerController {
	
	private Logger logger = Logger.getLogger(ManagerController.class);
	@Resource(name="orderService")
	private IOrderService orderService;
	@Resource(name="patientService")
	private IPatientService patientService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	@Resource(name="officeService")
	private IOfficeService officeService;
	@Resource(name="returnobjService")
	private IReturnObjService returnobjService;
	@Resource(name="noticeService")
	private INoticeService noticeService;
	@Resource(name="chuzhenService")
	private IChuzhenService chuzhenService;
	@Resource(name="officelistService")
	private IOfficelistService officelistService;
	//查看会员列表
	@RequestMapping("/pinfo")  
	public String patientInfoManage(HttpServletRequest request){
		List<Patient> pList=patientService.selectAll();
		request.setAttribute("pList", pList);
		return "member-list";
	}
	//搜索用户列表
	@RequestMapping("/findP")  
	public String findBy(HttpServletRequest request) throws Exception{
		String max=request.getParameter("datemax");
		String min=request.getParameter("datemin");
		String usernanme=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String tel=request.getParameter("tel");
		List<Patient> pList=patientService.findBySQL(max,min,usernanme,tel);
		request.setAttribute("pList", pList);
		return "member-list";
	}
	//桌面首页
	@RequestMapping("/desk")
	public String desk(HttpServletRequest request){
		//ip地址
		String ip=IPUtils.getIp(request);
		//系统时间
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d=simpleDateFormat.format(date);
		Runtime r = Runtime.getRuntime();  
		Map<String, String> map = System.getenv();  
		
        String computerName = map.get("COMPUTERNAME");// 获取计算机名  
        request.setAttribute("computerName", computerName);
        Properties props = System.getProperties(); 
        //操作系统名字
        String caozuo=props.getProperty("os.name");
        request.setAttribute("caozuo", caozuo);
        request.setAttribute("jiagou", props.getProperty("os.arch"));
        request.setAttribute("version", props.getProperty("os.version"));
		request.setAttribute("ip", ip);
		request.setAttribute("d", d);
		return "m_zhuomian";
	}
	//跳转添加页面
	@RequestMapping("/toAdd")
	public String toAddMember(){
		return "member-add";
		
	}
	//新增用户
	@RequestMapping("/add")
	public String add(Patient patient){
		System.out.println("增加");
		return "member-list";
	}
	
	//查看所有医生
	@RequestMapping("/findDoctor")
	public String findDoctor(HttpServletRequest request){
		List<Doctor> list=doctorService.selectAll();
		request.setAttribute("list", list);
		return "doctor-list";
	}
	
	// 条件选择医生
	@RequestMapping("/findDoctorBy")
	public String findDoctorBy(HttpServletRequest request) throws Exception {
		String workid=request.getParameter("workid");
		String oid=request.getParameter("oid");
		int o;
		if(oid!=null && !oid.equals("")){
			o=Integer.valueOf(oid);
		}else{
			o=0;
		}
		String dname=new String(request.getParameter("dname").getBytes("ISO-8859-1"),"UTF-8");
		String tel=request.getParameter("tel");
		List<Doctor> list = doctorService.findDoctorBy(workid,o,dname,tel);
		request.setAttribute("list", list);
		return "doctor-list";
	}

	// 查看所有科室信息
	@RequestMapping("/findOffice")
	public String findOffice(HttpServletRequest request) {
		List<Office> list = officeService.selectAll();
		request.setAttribute("list", list);
		return "office-list";
	}
	
	// 查看所有订单
	@RequestMapping("/order-list")
	public String findOrder(HttpServletRequest request) {
		List<ReturnObj> list=returnobjService.select();
		/*List<Order> list = orderService.selectAll();*/
		request.setAttribute("list", list);
		return "order-list";
	}

	// 编辑科室UI
	/*@RequestMapping("/edit-list")
	public String edit(HttpServletRequest request) {
		
		Office o  = officeService.selectOfficeById(officeid);
		request.setAttribute("o", o);
		return "edit-list";
	}*/

	// 条件选择科室
	@RequestMapping("findOfficeBy")
	public String findOfficeBy(HttpServletRequest request) throws Exception {
		String dname=new String(request.getParameter("dname").getBytes("ISO-8859-1"),"UTF-8");
		String dids=request.getParameter("did");
		int did;
		if(dids!=null && !dids.equals("")){
			did=Integer.valueOf(dids);
		}else{
			did=0;
		}
		List<Office> list = officeService.findOfficeBy(did,dname);
		request.setAttribute("list", list);
		return "office-list";
	}
	
	
	//条件选择订单
	@RequestMapping("findO")
	public String findOBy(HttpServletRequest request) throws UnsupportedEncodingException{
		String max=request.getParameter("datemax");
		String min=request.getParameter("datemin");
		String orderid=new String(request.getParameter("orderid").getBytes("ISO-8859-1"),"UTF-8");
		String dname=new String(request.getParameter("dname").getBytes("ISO-8859-1"),"UTF-8");
		String oid=new String(request.getParameter("oid").getBytes("ISO-8859-1"),"UTF-8");
		String state=new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		int s;
		int o;
		if(state!=null && !state.equals("")){
			s=Integer.valueOf(state);
		}else{
			s=0;
		}
		if(oid!=null && !oid.equals("")){
			o=Integer.valueOf(oid);
		}else{
			o=0;
		}
		List<ReturnObj> list=returnobjService.findO(max,min,orderid,dname,s,o);
		request.setAttribute("list", list);
		return "order-list";
	}
	@RequestMapping("addOfficeUI")
	public String addOfficeUI(){
		return "add-office";
		
	}
	@RequestMapping("addDoctorUI")
	public String addDoctorUI(){
		return "add-doctor";
		
	}
	//添加科室
	@RequestMapping("addOffice")
	public String addOffice(HttpServletRequest request) throws UnsupportedEncodingException{
		String oname=new String(request.getParameter("office").getBytes("ISO-8859-1"),"UTF-8");
		String desc=new String(request.getParameter("desc").getBytes("ISO-8859-1"),"UTF-8");
		officeService.add(oname,desc);
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）：添加科室"+oname+"成功！");
		List<Office> list = officeService.selectAll();
		request.setAttribute("list", list);
		return "office-list";
		
	}
	
	@RequestMapping("addDoctor")
	public String addDoctor(HttpServletRequest request) throws UnsupportedEncodingException{
		String dname=new String(request.getParameter("dname").getBytes("ISO-8859-1"),"UTF-8");
		String dsex=new String(request.getParameter("dsex").getBytes("ISO-8859-1"),"UTF-8");
		String roles=new String(request.getParameter("role").getBytes("ISO-8859-1"),"UTF-8");
		int role=Integer.valueOf(roles);
		int cost = 0;
		if(role==1){
			cost=3;
		}else if(role==2){
			cost=5;
		}
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String tel=new String(request.getParameter("tel").getBytes("ISO-8859-1"),"UTF-8");
		String oids=new String(request.getParameter("oid").getBytes("ISO-8859-1"),"UTF-8");
		int oid=Integer.valueOf(oids);
		String place=new String(request.getParameter("place").getBytes("ISO-8859-1"),"UTF-8");
		int count=doctorService.selectCount(oid);
		String workid=null;
		if(count+1>9){
			workid="0"+oid+(count+1);
		}else{
			workid="0"+oid+"0"+(count+1);
		}
		
		//添加医生
		doctorService.adddoctor(workid,dname,dsex,role,cost,username,username,tel,oid,place);
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）：添加医生"+dname+"成功！");
		List<Doctor> list=doctorService.selectAll();
		request.setAttribute("list", list);
		return "doctor-list";
	}
	//新闻列表
	@RequestMapping("news-list")
	public String news(HttpServletRequest request){
		List<Notice> list=noticeService.select();
		request.setAttribute("list", list);
		return "news-list";
	}
	//管理添加新闻页面
	@RequestMapping("add-news-ui")
	public String addnewsUI(){
		
		return "add-news";
	}
	@RequestMapping("addnews")
	public String addnews(HttpServletRequest request) throws UnsupportedEncodingException{
		String author=(String) request.getSession().getAttribute("username");
		String title=new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
		String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
		noticeService.add(title,content,author);
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）：添加新闻成功！");
		List<Notice> list=noticeService.select();
		request.setAttribute("list", list);
		return "news-list";
	}
	//科室编辑UI
	@RequestMapping("edit-office-ui")
	public String edit(HttpServletRequest request){
		String id=request.getParameter("oid");
		Integer oid=Integer.valueOf(id);
		Office office=officeService.selectOfficeById(oid);
		request.setAttribute("o", office);
		return "edit-office";
	}
	//科室update
	@RequestMapping("updateoffice")
	public String update(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=request.getParameter("oid");
		Integer oid=Integer.valueOf(id);
		String odesc=new String(request.getParameter("desc").getBytes("ISO-8859-1"),"UTF-8");
		officeService.update(oid,odesc);
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）：更新科室信息成功！");
		List<Office> list = officeService.selectAll();
		request.setAttribute("list", list);
		return "office-list";
	}
	//出诊安排页面
	@RequestMapping("chuzhen-list")
	public String chuzhen(HttpServletRequest request){
		List<Chuzhen> list=chuzhenService.select();
		request.setAttribute("list", list);
		return "chuzhen-list";
		
	}
	
	@RequestMapping("findChuzhen")
	public String findChuzhen(HttpServletRequest request) throws UnsupportedEncodingException{
		String startime=request.getParameter("datemax");
		String endtime=request.getParameter("datemin");
		String dname=new String(request.getParameter("dname").getBytes("ISO-8859-1"),"UTF-8");
		String id=request.getParameter("oid");
		Integer oid=0;
		if(id!=null && !id.equals("")){
			oid=Integer.valueOf(id);
		}
		List<Chuzhen> list=chuzhenService.findChuzhen(startime,endtime,dname,oid);
		request.setAttribute("list", list);
		return "chuzhen-list";
	}
	
	@RequestMapping("edit-chuzhen")
	public String editchuzhen(HttpServletRequest request){
		String v=request.getParameter("vid");
		Integer vid=Integer.valueOf(v);
		Chuzhen chuzhen=chuzhenService.selectByVid(vid);
		
		request.setAttribute("o", chuzhen);
		return "edit-chuzhen";
		
	}
	@RequestMapping("update-chuzhen")
	public String updateChuzhen(HttpServletRequest request){
		int vid=Integer.valueOf(request.getParameter("vid"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		int maxregis=Integer.valueOf(request.getParameter("maxregis"));
		int canregis=Integer.valueOf(request.getParameter("canregis"));
		officelistService.updateByVid(vid, starttime, endtime, canregis, maxregis);
		
		List<Chuzhen> list=chuzhenService.select();
		request.setAttribute("list", list);
		return "chuzhen-list";
		
	}
	
	@RequestMapping("addChuzhenUI")
	public String addChuzhen(HttpServletRequest request){
		
		return "add-chuzhen";
	}
	
	@RequestMapping("addVit")
	public String addVit(HttpServletRequest request) throws UnsupportedEncodingException{
		String office=new String(request.getParameter("office").getBytes("ISO-8859-1"),"UTF-8");
		Office o=officeService.selectOfficeByOname(office);
		String doc=new String(request.getParameter("doc").getBytes("ISO-8859-1"),"UTF-8");
		Doctor doctor=doctorService.selectByDname(doc, o.getOid());
		String date=request.getParameter("date");
		String shang=request.getParameter("shang");
		String starttime="";
		String endtime="";
		if(shang.equals("1")){
			starttime=date+" 08:00:00";
			endtime=date+" 12:00:00";
		}else if(shang.equals("2")){
			starttime=date+" 14:00:00";
			endtime=date+" 18:00:00";
		}
		String max=request.getParameter("max");
		//添加安排出诊
		Officelist officelist=officelistService.select(o.getOid(), starttime, endtime);
		if(officelist!=null){
			request.setAttribute("msg", "安排失败，该医生同一个时间段已经被安排！");
			return "add-chuzhen";
		}
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）：增加出诊信息成功！");
		officelistService.add(o.getOid(),doctor.getRole(),doctor.getDid(),starttime,endtime,0,max,max);
		List<Chuzhen> list=chuzhenService.select();
		request.setAttribute("list", list);
		return "chuzhen-list";
	}
	
}
