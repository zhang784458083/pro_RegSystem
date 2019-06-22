/**
 * @author         zchangyu
 * @Date           2019年6月15日 下午6:27:26
 * @Description    TODO（一句话描述）
 */
package com.sys.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sys.pojo.Manager;
import com.sys.pojo.User;
import com.sys.service.IManagerService;
import com.sys.service.IUserService;
import com.sys.utils.DateUtils;

@Controller
public class UserController {
	
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="userService")
	private IUserService userService;
	/*
	 * 查看顾客信息
	 */
	@RequestMapping("/m_userlist")
	public String selectUserByName(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		String name=null,tele=null;
		int enter_id=s.getEnter_id();
		if(request.getParameter("name")!=null && !request.getParameter("name").equals("")){
			name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		}
		if(request.getParameter("tele")!=null && !request.getParameter("tele").equals("")){
			tele=new String(request.getParameter("tele").getBytes("ISO-8859-1"),"UTF-8");
		}
		List<User> cuns=userService.select(enter_id,tele, name);
		request.setAttribute("list", cuns);
		return "m_userlist";
	}
	
	/*
	 * 添加顾客页面
	 */
	@RequestMapping("/adduserui")
	public String adduserui(HttpServletRequest request) throws UnsupportedEncodingException{
		
		return "m_adduser";
	}
	
	/*
	 * 编辑顾客信息页面
	 */
	@RequestMapping("/edituserui")
	public String m_edituserui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.selectOne(Integer.valueOf(id));
		request.setAttribute("user", u);
		return "m_edituser";
	}
	/*
	 * 更新顾客信息
	 */
	@RequestMapping("/updateuser")
	public String updateuser(HttpServletRequest request) throws UnsupportedEncodingException{
		int id=Integer.valueOf(new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8"));
		String name=new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"UTF-8");
		String tele=new String(request.getParameter("user_tele").getBytes("ISO-8859-1"),"UTF-8");
		User user=userService.selectOne(id);
		user.setUser_name(name);
		user.setUser_tele(tele);
		
		userService.update(user);
		User u=userService.selectOne(id);
		request.setAttribute("user", u);
		request.setAttribute("msg", "修改成功！");
		return "m_edituser";
	}
	/*
	 * 新增顾客
	 */
	@RequestMapping("/adduser")
	public String adduser(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		User user=new User();
		String user_name=new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"UTF-8");
		String user_tele=new String(request.getParameter("user_tele").getBytes("ISO-8859-1"),"UTF-8");
		user.setEnter_id(s.getEnter_id());
		user.setService_time(DateUtils.getDate());
		user.setUser_sum(0);
		user.setUser_intergal(0);
		user.setUser_level("无");//暂定 
		user.setUser_name(user_name);
		user.setUser_tele(user_tele);
		userService.add(user);
		request.setAttribute("msg", "提交成功!");
		return "m_adduser";
	}
	/*
	 * 删除顾客
	 */
	@ResponseBody
	@RequestMapping("/deleteuser")
	public void delete(String id) {
		int ii = Integer.valueOf(id);
		userService.delete(ii);
	}
	
	
}
