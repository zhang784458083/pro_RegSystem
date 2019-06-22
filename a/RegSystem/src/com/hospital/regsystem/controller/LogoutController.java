/**
 * @author         zchangyu
 * @Date           2018年2月22日 上午11:13:34
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.utils.IPUtils;

@Controller()
public class LogoutController {
	private Logger logger = Logger.getLogger(LogoutController.class);
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		String username=(String) request.getSession().getAttribute("username");
		logger.error("用户"+IPUtils.getIp(request)+"（管理员）"+username+" 退出系统！");
		request.getSession().removeAttribute("manager");
		request.getSession().removeAttribute("username");
		try {
			response.sendRedirect(request.getContextPath()+"/m_index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/plogout")
	public String plogout(HttpServletRequest request,HttpServletResponse response){
		String username=(String) request.getSession().getAttribute("userName");
		logger.error("用户"+IPUtils.getIp(request)+"（病人）"+username+" 退出系统！");
		request.getSession().removeAttribute("patient");
		request.getSession().removeAttribute("userName");
		try {
			response.sendRedirect(request.getContextPath()+"/pindex");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
