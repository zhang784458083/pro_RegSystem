/**
 * @author         zchangyu
 * @Date           2018年5月5日 上午12:39:50
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.pojo.Chuzhen;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.pojo.ReturnObj;
import com.hospital.regsystem.service.IChuzhenService;
import com.hospital.regsystem.service.IOfficeService;
import com.hospital.regsystem.service.IOrderService;
import com.hospital.regsystem.service.IReturnObjService;
import com.hospital.regsystem.utils.IPUtils;

@Controller()
public class DoctorController {
	private Logger logger = Logger.getLogger(DoctorController.class);
	@Resource(name="chuzhenService")
	private IChuzhenService chuzhenService;
	@Resource(name="returnobjService")
	private IReturnObjService returnobjService;
	@Resource(name="officeService")
	private IOfficeService officeService;
	@Resource(name="orderService")
	private IOrderService orderService;
	@RequestMapping("d-order-list")
	public String orderlist(HttpServletRequest request){
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		Office office=officeService.selectOfficeById(doctor.getOid());
		List<ReturnObj> list=returnobjService.selectByName(office.getOname(),doctor.getDname());
		/*List<Order> list = orderService.selectAll();*/
		request.setAttribute("list", list);
		return "d-order-list";
		
	}
	
	@RequestMapping("d-chuzhen")
	public String chuzhen(HttpServletRequest request){
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		Office office=officeService.selectOfficeById(doctor.getOid());
		List<Chuzhen> list=chuzhenService.selectBy(office.getOname(),doctor.getDname());
		request.setAttribute("list", list);
		return "d-chuzhen-list";
		
	}
	@RequestMapping("d-chuzhen-by")
	public String dchuzhen(HttpServletRequest request){
		String starttime=request.getParameter("datemax");
		String endtime=request.getParameter("datemin");
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		Office office=officeService.selectOfficeById(doctor.getOid());
		List<Chuzhen> list=chuzhenService.selectByOD(starttime,endtime,office.getOname(),doctor.getDname());
		request.setAttribute("list", list);
		return "d-chuzhen-list";
		
	}
	
	@RequestMapping("d-about")
	public String about(HttpServletRequest request){
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		request.setAttribute("d", doctor);
		return "d-about";
	}
	@RequestMapping("dfindOBy")
	public String dfindOBy(HttpServletRequest request) throws UnsupportedEncodingException{
		String orderid=request.getParameter("orderid");
		String s=new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		int state;
		int o;
		if(s!=null && !s.equals("")){
			state=Integer.valueOf(s);
		}else{
			state=0;
		}
		String starttime=request.getParameter("datemax");
		String endtime=request.getParameter("datemin");
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		Office office=officeService.selectOfficeById(doctor.getOid());
		List<ReturnObj> list=returnobjService.dfindOBy(orderid,state,starttime,endtime,office.getOname(),doctor.getDname());
		request.setAttribute("list", list);
		return "d-order-list";
	}
	
	
	@RequestMapping("dEditOrderUi")
	public String dEditOrderUi(HttpServletRequest request) throws UnsupportedEncodingException{
		String orderid=request.getParameter("orderid");
		ReturnObj r=returnobjService.dfindOByVid(orderid);
		request.setAttribute("r", r);
		return "d-edit-order";
	}
	
	@RequestMapping("dUpdateOrder")
	public String dUpdateOrder(HttpServletRequest request) throws UnsupportedEncodingException{
		Doctor doctor=(Doctor) request.getSession().getAttribute("doctor");
		String orderid=request.getParameter("orderid");
		String s=new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		String result=new String(request.getParameter("result").getBytes("ISO-8859-1"),"UTF-8");
		int state=Integer.valueOf(s);
		orderService.update(orderid,state,result);
		logger.error("用户"+IPUtils.getIp(request)+"（医生）"+doctor.getDname()+"修改订单"+orderid+" 状态为已诊断！");
		
		Office office=officeService.selectOfficeById(doctor.getOid());
		List<ReturnObj> list=returnobjService.selectByName(office.getOname(),doctor.getDname());
		request.setAttribute("list", list);
		return "d-order-list";
	}
}
