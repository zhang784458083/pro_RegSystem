/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午7:49:10
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxlvyou.service.ILiuyanService;

@Controller
public class LiuyanController {
	@Resource(name="liuyanService")
	private ILiuyanService liuyanService;
	@RequestMapping("/liuyan")
	public String liuyan (HttpServletRequest request,String txtCode) throws Exception{
		String txtUserName=new String(request.getParameter("txtUserName").getBytes("ISO-8859-1"),"UTF-8");
		String txtUserTel=request.getParameter("txtUserTel");
		String txtUserQQ=new String(request.getParameter("txtUserQQ").getBytes("ISO-8859-1"),"UTF-8");
		String txtContent=new String(request.getParameter("txtContent").getBytes("ISO-8859-1"),"UTF-8");
		//获取系统正确验证码
		String checkcode=(String) request.getSession().getAttribute("checkcode");
		String lowCheckcode=checkcode.toLowerCase();
		if(!txtCode.equals(checkcode) && !txtCode.equals(lowCheckcode)){
			request.setAttribute("message", "验证码错误！");
			return "leave";
		}else{
			//留言成功  存入数据库
			liuyanService.insert(txtUserTel, txtUserName, txtContent);
			
			request.setAttribute("message", "留言成功！感谢您提出宝贵的意见！");
		}
		
		return "leave";
	}
}
