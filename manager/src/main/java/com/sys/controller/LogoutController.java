/**
 * @author         zchangyu
 * @Date           2018年12月5日 下午12:53:56
 * @Description    TODO（一句话描述）
 */
package com.sys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("manager1");
		request.getSession().removeAttribute("manager2");
		try {
			response.sendRedirect(request.getContextPath()+"/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	} 
}
