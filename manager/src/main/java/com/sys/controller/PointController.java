/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午1:55:48
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

import com.sys.pojo.BeerRecord;
import com.sys.pojo.Manager;
import com.sys.pojo.PointRecord;
import com.sys.pojo.Rule;
import com.sys.pojo.User;
import com.sys.service.IManagerService;
import com.sys.service.IPointrecordService;
import com.sys.service.IRuleService;
import com.sys.service.IUserService;
import com.sys.utils.DateUtils;

@Controller()
public class PointController {
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="ruleService")
	private IRuleService ruleService;
	@Resource(name="pointrecordService")
	private IPointrecordService pointrecordService;
	/*
	 * 查看积分信息
	 */
	@RequestMapping("/m_pointlist")
	public String m_pointlist(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
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
		return "m_pointlist";
	}
	/*
	 * 充值积分信息页面
	 */
	@RequestMapping("/addpointui")
	public String addpointui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.selectOne(Integer.valueOf(id));
		request.setAttribute("user", u);
		return "m_addpoint";
	}
	/*
	 * 兑换积分 信息页面
	 */
	@RequestMapping("/reducepointui")
	public String reducepointui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.selectOne(Integer.valueOf(id));
		request.setAttribute("user", u);
		List<Rule> rules=ruleService.selectOn("兑换");
		request.setAttribute("list", rules);
		return "m_reducepoint";
	}
	/*
	 * 充值积分信息
	 */
	@RequestMapping("/addpoint")
	public String addpoint(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		int id=Integer.valueOf(new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8"));
		int add=Integer.valueOf(new String(request.getParameter("add").getBytes("ISO-8859-1"),"UTF-8"));
		User user=userService.selectOne(id);
		user.setUser_intergal(user.getUser_intergal()+add);
		userService.update(user);
		PointRecord beerRecord=new PointRecord();
		beerRecord.setManager(s.getUsername());
		beerRecord.setRecord_name("积分");
		beerRecord.setService_time(DateUtils.getDate());
		beerRecord.setUser_name(user.getUser_name());
		beerRecord.setUser_tele(user.getUser_tele());
		beerRecord.setUser_new(user.getUser_intergal());
		beerRecord.setUser_num(add);
		beerRecord.setUser_old(user.getUser_intergal()-add);
		beerRecord.setContent("无");
		pointrecordService.insert(beerRecord);
		User u=userService.selectOne(id);
		request.setAttribute("user", u);
		//TODO 此处应该上传消费明细信息  后期再加
		
		request.setAttribute("msg", "积分成功！");
		return "m_addpoint";
	}
	/*
	 * 兑换积分信息
	 */
	@RequestMapping("/reducepoint")
	public String reducepoint(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		int id=Integer.valueOf(new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8"));
		int num=Integer.valueOf(new String(request.getParameter("reduce").getBytes("ISO-8859-1"),"UTF-8"));
		int rule_id=Integer.valueOf(new String(request.getParameter("rule_id").getBytes("ISO-8859-1"),"UTF-8"));
		
		Rule r=ruleService.selectOne(rule_id);
		User user=userService.selectOne(id);
		//此处获取啤酒数目
		if(num*r.getGoods_prize()>user.getUser_intergal()){
			User u=userService.selectOne(id);
			request.setAttribute("user", u);
			List<Rule> rules=ruleService.selectOn("兑换");
			request.setAttribute("list", rules);
			request.setAttribute("msg", "兑换失败，积分不足！");
			return "m_reducepoint";
		}else{
			user.setUser_intergal(user.getUser_intergal()-num*r.getGoods_prize());
			userService.update(user);
			PointRecord beerRecord=new PointRecord();
			beerRecord.setManager(s.getUsername());
			beerRecord.setRecord_name("兑换");
			beerRecord.setService_time(DateUtils.getDate());
			beerRecord.setUser_name(user.getUser_name());
			beerRecord.setUser_tele(user.getUser_tele());
			beerRecord.setUser_new(user.getUser_intergal());
			beerRecord.setUser_num(num*r.getGoods_prize());
			beerRecord.setUser_old(user.getUser_intergal()+num*r.getGoods_prize());
			beerRecord.setContent("兑换"+r.getRule_name()+",数量为:"+num);
			pointrecordService.insert(beerRecord);
			User u=userService.selectOne(id);
			request.setAttribute("user", u);
			List<Rule> rules=ruleService.selectOn("兑换");
			request.setAttribute("list", rules);
			request.setAttribute("msg", "兑换成功,请兑现顾客商品！");
			return "m_reducepoint";
		}
		
	}
}
