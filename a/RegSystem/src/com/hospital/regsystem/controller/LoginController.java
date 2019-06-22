/**
 * @author         zchangyu
 * @Date           2018年1月21日 下午4:39:59
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Manager;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IDoctorService;
import com.hospital.regsystem.service.IManagerService;
import com.hospital.regsystem.service.IPatientService;
import com.hospital.regsystem.utils.IPUtils;

@Controller()
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="patientService")
	private IPatientService patientService;
	@Resource(name="doctorService")
	private IDoctorService doctorService;
	//管理员登录系统
	@RequestMapping("/mlogin")
	public String login(HttpServletRequest request,HttpServletResponse response,String username,String password,String checkCode){
		//获取验证码
		String checkcode=(String) request.getSession().getAttribute("checkcode");
	    String lowCheckcode=checkcode.toLowerCase();
	    if(username==null || password==null||username.equals("")||password.equals("")){
	    	request.setAttribute("message", "用户名或者密码不能为空...");
			return "m_index";
	    }else if(checkCode==null || checkCode.equals("")){
	    	request.setAttribute("message", "验证码不能为空...");
			return "m_index";
	    }else if(!checkCode.equals(checkcode)  && !checkCode.equals(lowCheckcode)){
	    	request.setAttribute("message", "验证码错误！");
			return "m_index";
	    }else{
	    	Manager manager2=managerService.find(username);
	    	Doctor doctor=doctorService.selectBy(username);
	    	if(manager2!=null){
	    		if(password.equals(manager2.getPassword())){
	    			//作用域记住登录状态
	    			String autoLogin=request.getParameter("autoLogin");
	    			String rememberme=request.getParameter("rememberme");
	    			if("1".equals(autoLogin)){
	    				Cookie autoLoginCookie=new Cookie("autoLoginCookie",manager2.getUsername()+"@"+manager2.getPassword());
	    				autoLoginCookie.setPath("/");
	    				autoLoginCookie.setMaxAge(60*60*24*7);
	    				response.addCookie(autoLoginCookie);
	    			}else{
	    				//删除cookie
	    				Cookie autoLoginCookie=new Cookie("autoLoginCookie", "");
	    				autoLoginCookie.setPath("/");
	    				autoLoginCookie.setMaxAge(0);
	    				response.addCookie(autoLoginCookie);
	    			}
	    			if("1".equals(rememberme)){
	    				Cookie remembermeCookie=new Cookie("remembermeCookie", manager2.getUsername());
	    				remembermeCookie.setPath("/");
	    				remembermeCookie.setMaxAge(60*60*24*7);
	    				response.addCookie(remembermeCookie);
	    				
	    			}
	    			
	    			request.getSession().setAttribute("manager", manager2);
	    			request.getSession().setAttribute("username", username);
	    			logger.error("用户"+IPUtils.getIp(request)+"（管理员）"+manager2.getUsername()+" 登录成功！");
	    			return "m_firstPage";
	    		}else{
	    			logger.error("用户"+IPUtils.getIp(request)+"（管理员）"+manager2.getUsername()+" 登录失败，原因：密码错误！");
	    			request.setAttribute("message", "密码错误！");
	    			return "m_index";
	    		}
	    	}else if(doctor!=null){
	    		if(password.equals(doctor.getPassword())){
	    			request.getSession().setAttribute("doctor", doctor);
	    			request.getSession().setAttribute("username", username);
	    			logger.error("用户"+IPUtils.getIp(request)+"（医生）"+doctor.getUsername()+" 登录成功！");
	    			return "d_firstPage";
	    		}else{
	    			logger.error("用户"+IPUtils.getIp(request)+"（医生）"+doctor.getUsername()+" 登录失败，原因：密码错误！");
	    			request.setAttribute("message", "密码错误！");
	    			return "m_index";
	    		}
	    	}else{
	    		logger.error("用户"+IPUtils.getIp(request)+"（管理员）"+username+" 登录失败，原因：用户名不存在！");
	    		request.setAttribute("message", "用户名不存在！请联系高级管理员");
    			return "m_index";
	    	}
	    }
	    
	}
	//病人登录系统
	@RequestMapping("/plogin")
	public String plogin(HttpServletRequest request, HttpServletResponse response, String username, String password,
			String checkCode) {
		// 获取验证码
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		String lowCheckcode = checkcode.toLowerCase();
		if (username == null || password == null || username.equals("") || password.equals("")) {
			request.setAttribute("message", "用户名或者密码不能为空...");
			return "p_login";
		} else if (checkCode == null || checkCode.equals("")) {
			request.setAttribute("message", "验证码不能为空...");
			return "p_login";
		} else if (!checkCode.equals(checkcode) && !checkCode.equals(lowCheckcode)) {
			request.setAttribute("message", "验证码错误！");
			return "p_login";
		} else {
			Patient p = patientService.checkUser(username);
			if (p != null) {
				if (password.equals(p.getPwd())) {
					// 作用域记住登录状态
					String autoLogin = request.getParameter("autoLogin");
					String rememberme = request.getParameter("rememberme");
					if ("1".equals(autoLogin)) {
						Cookie autoLoginCookie = new Cookie("autoLoginCookie",
								p.getUserName() + "@" + p.getPwd());
						autoLoginCookie.setPath("/");
						autoLoginCookie.setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(autoLoginCookie);
					} else {
						// 删除cookie
						Cookie autoLoginCookie = new Cookie("autoLoginCookie", "");
						autoLoginCookie.setPath("/");
						autoLoginCookie.setMaxAge(0);
						response.addCookie(autoLoginCookie);
					}
					if ("1".equals(rememberme)) {
						Cookie remembermeCookie = new Cookie("remembermeCookie", p.getUserName());
						remembermeCookie.setPath("/");
						remembermeCookie.setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(remembermeCookie);

					}

					request.getSession().setAttribute("patient", p);
					request.getSession().setAttribute("userName", p.getUserName());
					logger.error("用户"+IPUtils.getIp(request)+"（病人）" + p.getUserName() + " 登录成功！");
					return "p_index";
				} else {
					logger.error("用户"+IPUtils.getIp(request)+"（病人）" + p.getUserName() + " 登录失败，原因：密码错误！");
					request.setAttribute("message", "密码错误！");
					return "p_login";
				}
			} else {
				logger.error("用户"+IPUtils.getIp(request)+"（病人）" + username + " 登录失败，原因：用户名不存在！");
				request.setAttribute("message", "用户名不存在！请联系管理员");
				return "p_login";
			}
		}

	}
}
