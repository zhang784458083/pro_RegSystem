/**
 * @author         zchangyu
 * @Date           2018年4月22日 下午7:42:53
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.utils.IPUtils;

@Controller
public class PayBackController {
	private Logger logger = Logger.getLogger(PayBackController.class);
	@Resource(name="patientService")
	private IPatientService patientService;
	@RequestMapping("/back")
	public String back(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Patient patient=(Patient) request.getSession().getAttribute("patient");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String r1_Code = request.getParameter("r1_Code");
		if ("1".equals(r1_Code)) {
			String r3_Amt = request.getParameter("r3_Amt");
			double num=Double.valueOf(r3_Amt)*100;
			//账户充值成功
			patientService.pay(patient.getPid(),num+patient.getAccount());
			logger.error("用户（病人）"+patient.getUserName()+" 充值"+num+"元！IP地址为"+request.getRemoteAddr());
			Patient patient2=patientService.checkUser(patient.getUserName());
			request.setAttribute("r3_Amt", num);
			request.setAttribute("account", patient2.getAccount());
			return "pay_success";
		} else {
			logger.error("用户"+IPUtils.getIp(request)+"（病人）"+patient.getUserName()+" 充值失败！银行卡余额不足！");
			
			return "pay_error";
		}

	}
}
