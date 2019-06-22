/**
 * @author         zchangyu
 * @Date           2018年3月11日 下午2:54:07
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerIntercepter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getRequestURI(); 
		//如果是登录操作，则不拦截
		if(url.indexOf("mlogin")>=0 || url.indexOf("pindex")>=0 || url.indexOf("news")>=0 ||url.indexOf("about")>=0||url.indexOf("ploginUI")>=0 ||url.indexOf("preg")>=0||url.indexOf("checkusername")>=0||url.indexOf("plogin")>=0 ||url.indexOf("m_index")>=0 || url.indexOf("backpwdui")>=0 || url.indexOf("backpwd")>=0 || url.indexOf("regsend")>=0 ||url.indexOf("gettel")>=0){ 
		     return true; 
		 } 
		 HttpSession session = request.getSession();  
         String username = (String) session.getAttribute("username");
         String userName = (String) session.getAttribute("userName");
         if(username!=null || userName!=null){  
             //登陆成功的用户  
             return true;  
         }else{  
            //没有登陆，转向登陆界面  
             request.getRequestDispatcher("/WEB-INF/jsp/p_login.jsp").forward(request,response);  
           return false;  
         }  
	}

}
