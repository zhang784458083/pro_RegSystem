/**
 * @author         zchangyu
 * @Date           2019年2月20日 上午11:41:21
 * @Description    TODO（一句话描述）
 */
package com.sys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sys.pojo.Manager;
import com.sys.service.IManagerService;
import com.sys.utils.DateUtils;
import com.sys.utils.IPUtils;

@Controller()
public class ManagerController {
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Resource(name="managerService")
	private IManagerService managerService;
	@RequestMapping("/index")
	public String manager(HttpServletRequest request,HttpServletResponse response){
		
		return "m_login";
		
	}
	// 桌面首页
	@RequestMapping("/desk")
	public String desk(HttpServletRequest request) {
		// ip地址
		String ip = IPUtils.getIp(request);
		// 系统时间
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = simpleDateFormat.format(date);
		Runtime r = Runtime.getRuntime();
		Map<String, String> map = System.getenv();

		String computerName = map.get("COMPUTERNAME");// 获取计算机名
		request.setAttribute("computerName", computerName);
		Properties props = System.getProperties();
		// 操作系统名字
		String caozuo = props.getProperty("os.name");
		request.setAttribute("caozuo", caozuo);
		request.setAttribute("jiagou", props.getProperty("os.arch"));
		request.setAttribute("version", props.getProperty("os.version"));
		request.setAttribute("ip", ip);
		request.setAttribute("d", d);

		return "m_zhuomian";
	}
	@RequestMapping("/m_resetui")
	public String resetui(HttpServletRequest request,HttpServletResponse response){
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		
		request.setAttribute("s", s);
		return "m_reset";
	}
	
	@RequestMapping("/m_reset")
	public String reset(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		managerService.resetpassword(s.getUsername(),password);
		
		request.setAttribute("s", s);
		request.setAttribute("msg", "修改成功！");
		return "m_reset";
		
	}
	
	/*@RequestMapping("/m_userlist")
	public String userlist(HttpServletRequest request,HttpServletResponse response){
		SeniorManager s = (SeniorManager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "index";
		}
		List<User> cuns=userService.selectAll();
		request.setAttribute("list", cuns);
		return "m_userlist";
	}
	@RequestMapping("/m_selectUserByName")
	public String selectUserByName(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		SeniorManager s = (SeniorManager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "index";
		}
		String name=null;
		if(request.getParameter("username")!=null && !request.getParameter("username").equals("")){
			name=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		}
		List<User> cuns=userService.selectUserByUserName(name);
		request.setAttribute("list", cuns);
		return "m_userlist";
	}*/
	
	/*@RequestMapping("/edituserUI")
	public String m_edituserui(HttpServletRequest request) throws UnsupportedEncodingException{
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.find1(username);
		request.setAttribute("list", u);
		return "m_edituserui";
	}
	
	@RequestMapping("/adduserui")
	public String m_adduserui(HttpServletRequest request) throws UnsupportedEncodingException{
		
		return "m_adduserui";
	}
	@RequestMapping("/updateuser")
	public String updateuser(HttpServletRequest request) throws UnsupportedEncodingException{
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String tel=new String(request.getParameter("tel").getBytes("ISO-8859-1"),"UTF-8");
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		userService.updateUser(username,password,name,tel);
		
		User u=userService.find1(username);
		request.setAttribute("list", u);
		request.setAttribute("msg", "修改成功！");
		return "m_edituserui";
	}
	@RequestMapping("/adduser")
	public String adduser(HttpServletRequest request) throws UnsupportedEncodingException{
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String tel=new String(request.getParameter("tel").getBytes("ISO-8859-1"),"UTF-8");
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setName(name);
		user.setTel(tel);
		user.setIf_fenpei(0);
		userService.insert(user);
		
		request.setAttribute("msg", "添加成功！");
		return "m_adduserui";
	}
	
	@ResponseBody
	@RequestMapping("/deleteUser")
	public void toubao(String id) {
		int ii = Integer.valueOf(id);
		userService.delete(ii);
	}
	
	// 文件下载页面
	@RequestMapping("/m_docenter")
	public String docenter(HttpServletRequest request) {
		SeniorManager s = (SeniorManager) request.getSession().getAttribute("loginUser");
		if (s == null) {
			return "index";
		}

		List<FilePojo> list = fileService.select();
		request.setAttribute("list", list);
		return "m_docenter";
	}
	// 文件下载页面
		@RequestMapping("/u_docenter")
		public String u_docenter(HttpServletRequest request) {
			User s = (User) request.getSession().getAttribute("loginUser");
			if (s == null) {
				return "index";
			}

			List<FilePojo> list = fileService.select();
			request.setAttribute("list", list);
			return "u_docenter";
		}

	// 文件页面
	@RequestMapping("/m_selectName")
	public String selectName(HttpServletRequest request) throws UnsupportedEncodingException {
		SeniorManager s = (SeniorManager) request.getSession().getAttribute("loginUser");
		if (s == null) {
			return "index";
		}
		String name = null,type=null;
		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		}
		if (request.getParameter("fenlei") != null && !request.getParameter("fenlei").equals("")) {
			type = new String(request.getParameter("fenlei").getBytes("ISO-8859-1"), "UTF-8");
		}
		List<FilePojo> list = fileService.selectByName(name,type);
		request.setAttribute("list", list);
		return "m_docenter";
	}

	// 文件页面
	@RequestMapping("/u_selectName")
	public String u_selectName(HttpServletRequest request) throws UnsupportedEncodingException {
		User s = (User) request.getSession().getAttribute("loginUser");
		if (s == null) {
			return "index";
		}
		String name = null, type = null;
		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		}
		if (request.getParameter("fenlei") != null && !request.getParameter("fenlei").equals("")) {
			type = new String(request.getParameter("fenlei").getBytes("ISO-8859-1"), "UTF-8");
		}
		List<FilePojo> list = fileService.selectByName(name, type);
		request.setAttribute("list", list);
		return "u_docenter";
	}

	@RequestMapping("/addzhiliaoui")
	public String addui(HttpServletRequest request) {

		return "m_addziliao";
	}

	@RequestMapping("/addzhiliao")
	public String addzhiliao(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) throws UnsupportedEncodingException {
		SeniorManager s = (SeniorManager) request.getSession().getAttribute("loginUser");
		if (s == null) {
			return "index";
		}
		//String fenlei=new String(request.getParameter("fenlei").getBytes("ISO-8859-1"), "UTF-8");
		String fenlei=request.getParameter("fenlei");
		String realname=request.getParameter("realname");
		String path=request.getServletContext().getRealPath("/");
		FilePojo filePojo = new FilePojo();
		filePojo.setRealName(realname);
		if (files != null && files.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
				String[] aString = file.getOriginalFilename().split("\\.");
				filePojo.setHome("movie/"+file.getOriginalFilename());
				filePojo.setName(aString[0]);
				
				filePojo.setType(aString[1]);
				filePojo.setTime(DateUtils.getDate());
				filePojo.setUser(s.getUsername());
				filePojo.setFenlei(fenlei);
				fileService.insert(filePojo);
				saveFile(files[i], path+"/movie/");
			}
		}

		request.setAttribute("msg", "上传成功！");
		return "m_addziliao";
	}
	
	private boolean saveFile(MultipartFile file, String path) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                File filepath = new File(path);
                if (!filepath.exists()) 
                    filepath.mkdirs();
                // 文件保存路径  
                String savePath = path + file.getOriginalFilename(); 
               
                // 转存文件  
                file.transferTo(new File(savePath));  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    } 
	
	@ResponseBody
	@RequestMapping("/deleteFile")
	public void toubao(String id) {
		int ii = Integer.valueOf(id);
		fileService.delete(ii);
	}
	
	@RequestMapping("/downFile")
	public void down(HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, IOException{
		int id=Integer.valueOf(new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8"));
		FilePojo filePojo=fileService.selectById(id);
		String src="attachment;filename="+java.net.URLEncoder.encode(filePojo.getName()+"."+filePojo.getType(),"utf-8");
		response.setHeader("Content-Disposition", src);
		ServletOutputStream sos=response.getOutputStream();
		String path=request.getSession().getServletContext().getRealPath("/");
		InputStream is=new FileInputStream(new File(path+filePojo.getHome()));
		byte[] date=new byte[2048];
		int len=0;
		while((len=is.read(date))!=-1){
			sos.write(date);
		}
	}
	
	
	@RequestMapping("/play")
	public String play(HttpServletRequest request) throws UnsupportedEncodingException{
		String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),"UTF-8");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("path", path);
		
		return "movie1";
		
	}*/

}
