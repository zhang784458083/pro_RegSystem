/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午12:31:38
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
import com.sys.pojo.Rule;
import com.sys.pojo.User;
import com.sys.service.IBeerrecordService;
import com.sys.service.IManagerService;
import com.sys.service.IRuleService;
import com.sys.service.IUserService;
import com.sys.utils.DateUtils;

@Controller()
public class BeerController {
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="ruleService")
	private IRuleService ruleService;
	@Resource(name="beerrecordService")
	private IBeerrecordService beerrecordService;
	/*
	 * 查看啤酒信息
	 */
	@RequestMapping("/m_beerlist")
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
		return "m_beerlist";
	}
	/*
	 * 充值啤酒信息页面
	 */
	@RequestMapping("/addbeerui")
	public String addbeerui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.selectOne(Integer.valueOf(id));
		request.setAttribute("user", u);
		List<Rule> rules=ruleService.selectOn("充值");
		request.setAttribute("list", rules);
		return "m_addbeer";
	}
	/*
	 * 消费啤酒信息页面
	 */
	@RequestMapping("/reducebeerui")
	public String reducebeerui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		User u=userService.selectOne(Integer.valueOf(id));
		request.setAttribute("user", u);
		return "m_reducebeer";
	}
	/*
	 * 充值啤酒信息
	 */
	@RequestMapping("/addbeer")
	public String addbeer(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		int id=Integer.valueOf(new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8"));
		int add=Integer.valueOf(new String(request.getParameter("add").getBytes("ISO-8859-1"),"UTF-8"));
		int rule_id=Integer.valueOf(new String(request.getParameter("rule_id").getBytes("ISO-8859-1"),"UTF-8"));
		String pay=new String(request.getParameter("pay").getBytes("ISO-8859-1"),"UTF-8");
		User user=userService.selectOne(id);
		//此处获取啤酒数目
		if(rule_id==0){
			user.setUser_sum(user.getUser_sum()+add);
			userService.update(user);
			BeerRecord beerRecord=new BeerRecord();
			beerRecord.setManager(s.getUsername());
			beerRecord.setPay(pay);
			beerRecord.setRecord_name("充值");
			beerRecord.setService_time(DateUtils.getDate());
			beerRecord.setUser_name(user.getUser_name());
			beerRecord.setUser_tele(user.getUser_tele());
			beerRecord.setUser_new(user.getUser_sum());
			beerRecord.setUser_num(add);
			beerRecord.setUser_old(user.getUser_sum()-add);
			beerRecord.setRule_name("无");
			beerrecordService.insert(beerRecord);
			User u=userService.selectOne(id);
			request.setAttribute("user", u);
			List<Rule> rules=ruleService.selectOn("充值");
			request.setAttribute("list", rules);
			request.setAttribute("msg", "充值啤酒成功！");
			return "m_addbeer";
		}else{
			Rule rule=ruleService.selectOne(rule_id);
			//判断规则是否可用
			if(add>=rule.getAdd_num()){
				user.setUser_sum(user.getUser_sum()+add+rule.getGive_num());
				userService.update(user);
				BeerRecord beerRecord=new BeerRecord();
				beerRecord.setManager(s.getUsername());
				beerRecord.setPay(pay);
				beerRecord.setRecord_name("充值");
				beerRecord.setService_time(DateUtils.getDate());
				beerRecord.setUser_name(user.getUser_name());
				beerRecord.setUser_tele(user.getUser_tele());
				beerRecord.setUser_new(user.getUser_sum());
				beerRecord.setUser_num(add);
				beerRecord.setUser_old(user.getUser_sum()-add-rule.getGive_num());
				beerRecord.setRule_name("充值"+rule.getAdd_num()+"瓶送"+rule.getGive_num()+"瓶");
				beerrecordService.insert(beerRecord);
				User u=userService.selectOne(id);
				request.setAttribute("user", u);
				List<Rule> rules=ruleService.selectOn("充值");
				request.setAttribute("list", rules);
				request.setAttribute("msg", "充值啤酒成功！");
				return "m_addbeer";
			}else{
				//规则选择错误！！
				//userService.update(user);
				User u=userService.selectOne(id);
				request.setAttribute("user", u);
				List<Rule> rules=ruleService.selectOn("充值");
				request.setAttribute("list", rules);
				request.setAttribute("msg", "充值失败，重新选择参与活动！");
				return "m_addbeer";
			}
		}
		
	}
	/*
	 * 消费啤酒信息
	 */
	@RequestMapping("/reducebeer")
	public String reducebeer(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		int id=Integer.valueOf(new String(request.getParameter("user_id").getBytes("ISO-8859-1"),"UTF-8"));
		int reduce=Integer.valueOf(new String(request.getParameter("reduce").getBytes("ISO-8859-1"),"UTF-8"));
		
		User user=userService.selectOne(id);
		//此处获取啤酒数目
		if(reduce>user.getUser_sum()){
			request.setAttribute("msg", "消费失败，啤酒数不足！");
			return "m_reducebeer";
		}else{
			user.setUser_sum(user.getUser_sum()-reduce);
			userService.update(user);
			BeerRecord beerRecord=new BeerRecord();
			beerRecord.setManager(s.getUsername());
			beerRecord.setPay("无");
			beerRecord.setRecord_name("消费");
			beerRecord.setService_time(DateUtils.getDate());
			beerRecord.setUser_name(user.getUser_name());
			beerRecord.setUser_tele(user.getUser_tele());
			beerRecord.setUser_new(user.getUser_sum());
			beerRecord.setUser_num(reduce);
			beerRecord.setUser_old(user.getUser_sum()+reduce);
			beerRecord.setRule_name("无");
			beerrecordService.insert(beerRecord);
			User u=userService.selectOne(id);
			request.setAttribute("user", u);
			request.setAttribute("msg", "消费成功！");
			return "m_reducebeer";
		}
		
	}
	
}
