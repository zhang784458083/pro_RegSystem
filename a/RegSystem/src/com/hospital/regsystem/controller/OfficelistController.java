package com.hospital.regsystem.controller;

import java.io.UnsupportedEncodingException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IOfficelistService;
import com.hospital.regsystem.utils.DateUtils;
import com.hospital.regsystem.utils.IPUtils;

/**
 * @author zchangyu
 * @Date 2018年3月22日 下午9:38:57
 * @Description TODO（一句话描述）
 */
@Controller()
public class OfficelistController {
	private Logger logger = Logger.getLogger(OfficelistController.class);
	@Resource(name="officelistService")
	private IOfficelistService officelistService;
	@Resource(name="officeService")
	private IOfficeService officeService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	// 挂号UI
	@RequestMapping("/orderUI")
	public String regisUI(HttpServletRequest request) {
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		return "p_order_index";

	}

	@RequestMapping("/order")
	public String guahao(HttpServletRequest request) {
		Patient patient = (Patient) request.getSession().getAttribute("patient");

		return "p_order_finish";
	}

	// 普通医生首页
	@RequestMapping("/generalUI")
	public String generalUI(HttpServletRequest request) {
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		return "order_general_first";
	}

	// 专家首页
	@RequestMapping("/expertUI")
	public String expertUI(HttpServletRequest request) {
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		return "order_professor_first";
	}

	// 查看科室的出诊情况
	@RequestMapping("/officelist")
	public String officelist(HttpServletRequest request) {
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		if(patient==null){
			return "p_login"; 
		}
		String officeId=request.getParameter("office");
		int officeid=Integer.valueOf(officeId);
		Office office=officeService.selectOfficeById(officeid);
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 查看了普通号的"+office.getOname()+"出诊安排表。");
		request.setAttribute("oname", office.getOname());
		//先遍历之后一个星期的日期
		for(int i=1;i<8;i++){
			//例如：2018年3月22日
			request.setAttribute("d"+i+"", DateUtils.date(i));
			//例如：星期一
			request.setAttribute("w"+i+"", DateUtils.week(i));
			//数据库中查询需要带入的参数 2018-03-23 另外拼接08:00:00
			String date=DateUtils.toDate(DateUtils.date(i));
			int nowCanRegAM=officelistService.selectOfficeCanRegAM(officeid,date+" 8:00:00",date+" 12:00:00");
			//获取当日上午的可挂号人数
			/*if(nowCanRegAM==9999){
				request.setAttribute("a"+i+"", "预约已满！");
				
			}else{
				request.setAttribute("a"+i+"", nowCanRegAM);
			}*/
			request.setAttribute("a"+i+"", nowCanRegAM);
			//获取当日下午的可挂号人数
			int nowCanRegPM=officelistService.selectOfficeCanRegPM(officeid,date+" 14:00:00",date+" 18:00:00");
			/*if(nowCanRegPM==0){
				request.setAttribute("p"+i+"", "预约已满！");
				
			}else{
				request.setAttribute("p"+i+"", "剩余"+nowCanRegAM+"人<br>可预约</a>");
			}*/
			request.setAttribute("p"+i+"", nowCanRegPM);
		}
		
		return "order_general";
	}
	
		// 查看科室的出诊情况
		@RequestMapping("/officelistPro")
		public String officelistPro(HttpServletRequest request) throws UnsupportedEncodingException {
			Patient patient = (Patient) request.getSession().getAttribute("patient");
			if(patient==null){
				return "p_login"; 
			}
			String oname=new String(request.getParameter("office").getBytes("ISO-8859-1"),"UTF-8");
			String dname=new String(request.getParameter("doc").getBytes("ISO-8859-1"),"UTF-8");
			Office office=officeService.selectOfficeByOname(oname);
			Doctor doctor=doctorService.selectByDname(dname,office.getOid());
			logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 查看了"+oname+":"+dname+"专家的出诊安排表。");
			request.setAttribute("oname", oname);
			request.setAttribute("dname", dname);
			//先遍历之后一个星期的日期
			for(int i=1;i<8;i++){
				//例如：2018年3月22日
				request.setAttribute("d"+i+"", DateUtils.date(i));
				//例如：星期一
				request.setAttribute("w"+i+"", DateUtils.week(i));
				//数据库中查询需要带入的参数 2018-03-23 另外拼接08:00:00
				String date=DateUtils.toDate(DateUtils.date(i));
				int nowCanRegAM=officelistService.selectOfficeCanRegAMByDname(office.getOid(),doctor.getDid(),date+" 8:00:00",date+" 12:00:00");
				//获取当日上午的可挂号人数
				/*if(nowCanRegAM==9999){
					request.setAttribute("a"+i+"", "预约已满！");
					
				}else{
					request.setAttribute("a"+i+"", nowCanRegAM);
				}*/
				request.setAttribute("a"+i+"", nowCanRegAM);
				//获取当日下午的可挂号人数
				int nowCanRegPM=officelistService.selectOfficeCanRegPMByDname(office.getOid(),doctor.getDid(),date+" 14:00:00",date+" 18:00:00");
				/*if(nowCanRegPM==0){
					request.setAttribute("p"+i+"", "预约已满！");
					
				}else{
					request.setAttribute("p"+i+"", "剩余"+nowCanRegAM+"人<br>可预约</a>");
				}*/
				request.setAttribute("p"+i+"", nowCanRegPM);
			}
			
			return "order_pro";
		}

}
