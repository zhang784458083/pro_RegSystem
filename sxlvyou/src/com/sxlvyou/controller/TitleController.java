/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午12:20:02
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxlvyou.pojo.Product;
import com.sxlvyou.service.IProductService;

@Controller
public class TitleController {

	@Resource(name="productService")
	private IProductService productService;
	//网站首页
	@RequestMapping("/index")
	public String toFirst(){
		return "index";
		
	}
	//旅游风景
	@RequestMapping("beautiful")
	public String beautiful(HttpServletRequest request,HttpServletResponse response){
		List<Product> list=productService.selectByType("lyfj");
		request.setAttribute("list", list);
		return "beautiful";
	}
	//旅游景点
	@RequestMapping("tourism")
	public String lvyou(HttpServletRequest request){
		List<Product> list=productService.selectByType("lyjd");
		request.setAttribute("list", list);
		return "tourism";
	}
	//美食
	@RequestMapping("delicacy")
	public String meishi(HttpServletRequest request){
		List<Product> list=productService.selectByType("sxms");
		request.setAttribute("list", list);
		return "delicacy";
		
	}
	
	//动态
	@RequestMapping("new")
	public String dongtai(HttpServletRequest request){
		List<Product> list=productService.selectByType("news");
		request.setAttribute("list", list);
		return "new";
		
	}
	
	//留言
	@RequestMapping("leave")
	public String leave(){
		return "leave";
		
	}
	
	//团队介绍
	@RequestMapping("about")
	public String about(){
		return "about";
		
	}
	//联系我们
	@RequestMapping("connection")
	public String conn(){
		return "connection";
	}
	
	//每一个具体的图片详情
	@RequestMapping("lyfjintro")
	public String lyfjintro(HttpServletRequest request){
		String rid=request.getParameter("id");
		Integer id=Integer.valueOf(rid);
		Product product=productService.selectOne(id);
		request.setAttribute("p", product);
		return "lyfj_introduce";
		
	}

	// 每一个具体的图片详情
	@RequestMapping("lyjdintro")
	public String lyjdintro(HttpServletRequest request) {
		String rid = request.getParameter("id");
		Integer id = Integer.valueOf(rid);
		Product product = productService.selectOne(id);
		request.setAttribute("p", product);
		return "lyjd_introduce";

	}

	// 每一个具体的图片详情
	@RequestMapping("sxmsintro")
	public String sxmsintro(HttpServletRequest request) {
		String rid = request.getParameter("id");
		Integer id = Integer.valueOf(rid);
		Product product = productService.selectOne(id);
		request.setAttribute("p", product);
		return "sxms_introduce";

	}

	// 每一个具体的图片详情
	@RequestMapping("newsintro")
	public String newsintro(HttpServletRequest request) {
		String rid = request.getParameter("id");
		Integer id = Integer.valueOf(rid);
		Product product = productService.selectOne(id);
		request.setAttribute("p", product);
		return "news_introduce";

	}

}
