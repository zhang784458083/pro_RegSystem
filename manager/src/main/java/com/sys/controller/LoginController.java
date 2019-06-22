/**
 * @author         zchangyu
 * @Date           2018年11月20日 下午1:59:38
 * @Description    TODO（一句话描述）
 */
package com.sys.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sys.pojo.Manager;
import com.sys.service.IManagerService;

@Controller()
public class LoginController {
	@Resource(name="managerService")
	private IManagerService managerService;
	//管理员登录系统
	@RequestMapping("/manaindex")
	public String login(HttpServletRequest request,HttpServletResponse response,String username,String password,String checkCode) throws NumberFormatException, UnsupportedEncodingException{
		// 获取验证码
		int type=Integer.valueOf(new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8"));
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		String lowCheckcode = checkcode.toLowerCase();
		if (username == null || password == null || username.equals("") || password.equals("")) {
			request.setAttribute("message", "用户名或者密码不能为空...");
			return "m_login";
		} else if (checkCode == null || checkCode.equals("")) {
			request.setAttribute("message", "验证码不能为空...");
			return "m_login";
		} else if (!checkCode.equals(checkcode) && !checkCode.equals(lowCheckcode)) {
			request.setAttribute("message", "验证码错误！");
			return "m_login";
		}else{
			if(type==1){
				Manager manager=managerService.find1(username);
		    	if(manager!=null && manager.getType()==1){
		    		if(password.equals(manager.getPassword())){
		    			request.getSession().setAttribute("loginUser", manager);
		    			request.getSession().setAttribute("username", username);
		    			return "m_index";
		    			
		    		}else{
		    			request.setAttribute("message", "密码错误！");
		    			return "m_login";
		    		}
		    	}
		    	
		    	else{
		    		request.setAttribute("message", "用户名不存在！");
	    			return "m_login";
		    	}
			}
			else{
				Manager manager=managerService.find1(username);
		    	if(manager!=null && manager.getType()==2){
		    		if(password.equals(manager.getPassword())){
		    			request.getSession().setAttribute("loginUser", manager);
		    			request.getSession().setAttribute("username", username);
		    			return "m2_index";
		    			
		    		}else{
		    			request.setAttribute("message", "密码错误！");
		    			return "m_login";
		    		}
		    	}
		    	
		    	else{
		    		request.setAttribute("message", "用户名不存在！");
	    			return "m_login";
		    	}
			}
			
	    }
	}
	
	
}
