/**
 * @author         zchangyu
 * @Date           2018年1月13日 上午11:39:39
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
public class IndexController {
	//后台管理登录
	@RequestMapping("/m_index")  
	public String index(){
		
	    return "m_index";  
	}
	//用户端首页
	@RequestMapping("/pindex")  
	public String pIndex(){
		
		return "p_index";  
	}
	
	
}
