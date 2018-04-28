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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.utils.IPUtils;
import com.sun.crypto.provider.DESKeyFactory;

@Controller
public class ManagerController {
	@Resource(name="patientService")
	private IPatientService patientService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	@Resource(name="officeService")
	private IOfficeService officeService;
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
}
