/**
 * @author         zchangyu
 * @Date           2018年3月11日 下午2:54:07
 * @Description    TODO（一句话描述）
 */
package com.sys.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerIntercepter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getRequestURI(); 
		//如果是登录操作，则不拦截
		 if(url.indexOf("manaindex")>=0 || url.indexOf("desk")>=0 || url.indexOf("manager")>=0||  url.indexOf("userLogin")>=0 ){ 
		     return true; 
		 } 
		 HttpSession session = request.getSession();  
         String username = (String) session.getAttribute("username");
         //String userName = (String) session.getAttribute("user");
         if(username!=null){  
             //登陆成功的用户  
             return true;  
         }else{  
            //没有登陆，转向登陆界面  
             request.getRequestDispatcher("/WEB-INF/jsp/m_login.jsp").forward(request,response);  
           return false;  
         }  
	}

}
