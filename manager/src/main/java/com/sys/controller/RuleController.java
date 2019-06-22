/**
 * @author         zchangyu
 * @Date           2019年6月21日 下午11:02:26
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.pojo.Manager;
import com.sys.pojo.Rule;
import com.sys.pojo.User;
import com.sys.service.IManagerService;
import com.sys.service.IRuleService;
import com.sys.utils.DateUtils;

@Controller()
public class RuleController {
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="ruleService")
	private IRuleService ruleService;
	/*
	 * 管理员查看充值规则信息
	 */
	@RequestMapping("/m2_buyrulelist")
	public String selectBuyRule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		String rule_name=null,rule_type="充值";
		
		if(request.getParameter("rule_name")!=null && !request.getParameter("rule_name").equals("")){
			rule_name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		}
		
		List<Rule> rules=ruleService.selectAll(rule_type, rule_name);
		request.setAttribute("list", rules);
		return "m2_buyrulelist";
	}
	/*
	 * 管理员查看兑换规则信息
	 */
	@RequestMapping("/m2_exchrulelist")
	public String selectExchRule(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		String rule_name=null,rule_type="兑换";
		
		if(request.getParameter("rule_name")!=null && !request.getParameter("rule_name").equals("")){
			rule_name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		}
		
		List<Rule> rules=ruleService.selectAll(rule_type, rule_name);
		request.setAttribute("list", rules);
		return "m2_exchrulelist";
	}
	
	/*
	 * 添加充值规则页面
	 */
	@RequestMapping("/addbuyruleui")
	public String addbugruleui(HttpServletRequest request) throws UnsupportedEncodingException{
		
		return "m2_addbuyrule";
	}
	/*
	 * 添加兑换规则页面
	 */
	@RequestMapping("/addexchruleui")
	public String addexchruleui(HttpServletRequest request) throws UnsupportedEncodingException{
		
		return "m2_addexchrule";
	}
	/*
	 * 编辑充值规则信息页面
	 */
	@RequestMapping("/editbuyruleui")
	public String editbuyruleui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		Rule u=ruleService.selectOne(Integer.valueOf(id));
		request.setAttribute("rule", u);
		return "m2_editbuyrule";
	}
	/*
	 * 编辑兑换规则信息页面
	 */
	@RequestMapping("/editexchruleui")
	public String editexchruleui(HttpServletRequest request) throws UnsupportedEncodingException{
		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		Rule u=ruleService.selectOne(Integer.valueOf(id));
		request.setAttribute("rule", u);
		return "m2_editexchrule";
	}
	/*
	 * 更新充值规则信息
	 */
	@RequestMapping("/updatebuyrule")
	public String updatebuyrule(HttpServletRequest request) throws UnsupportedEncodingException{
		int id=Integer.valueOf(new String(request.getParameter("rule_id").getBytes("ISO-8859-1"),"UTF-8"));
		String rule_name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		
		int add=Integer.valueOf(new String(request.getParameter("add").getBytes("ISO-8859-1"),"UTF-8"));
		int give=Integer.valueOf(new String(request.getParameter("give").getBytes("ISO-8859-1"),"UTF-8"));
		Rule rule=ruleService.selectOne(id);
		rule.setAdd_num(add);
		rule.setGive_num(give);
		rule.setRule_name(rule_name);
		ruleService.update(rule);
		Rule u=ruleService.selectOne(Integer.valueOf(id));
		request.setAttribute("rule", u);
		request.setAttribute("msg", "修改成功！");
		return "m2_editbuyrule";
	}
	/*
	 * 更新兑换规则信息
	 */
	@RequestMapping("/updateexchrule")
	public String updateexchrule(HttpServletRequest request) throws UnsupportedEncodingException{
		int id=Integer.valueOf(new String(request.getParameter("rule_id").getBytes("ISO-8859-1"),"UTF-8"));
		String name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		int prize=Integer.valueOf(new String(request.getParameter("goods_prize").getBytes("ISO-8859-1"),"UTF-8"));
		Rule rule=ruleService.selectOne(id);
		rule.setGoods_prize(prize);
		rule.setRule_name(name);
		ruleService.update(rule);
		Rule u=ruleService.selectOne(Integer.valueOf(id));
		request.setAttribute("rule", u);
		request.setAttribute("msg", "修改成功！");
		return "m2_editexchrule";
	}
	
	/*
	 * 新增充值规则
	 */
	@RequestMapping("/addbuyrule")
	public String addbuyrule(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		Rule rule=new Rule();
		String rule_name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		int add_num=Integer.valueOf(new String(request.getParameter("add_num").getBytes("ISO-8859-1"),"UTF-8"));
		int give_num=Integer.valueOf(new String(request.getParameter("give_num").getBytes("ISO-8859-1"),"UTF-8"));
		rule.setAdd_num(add_num);
		rule.setGive_num(give_num);
		rule.setInsert_time(DateUtils.getDate());
		rule.setInsert_user(s.getUsername());
		rule.setRule_name(rule_name);
		rule.setRule_status(1);
		rule.setRule_type("充值");
		ruleService.insert(rule);
		request.setAttribute("msg", "提交成功!");
		return "m2_addbuyrule";
	}
	/*
	 * 新增兑换规则
	 */
	@RequestMapping("/addexchrule")
	public String addexchrule(HttpServletRequest request) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		Rule rule=new Rule();
		String rule_name=new String(request.getParameter("rule_name").getBytes("ISO-8859-1"),"UTF-8");
		int goods_prize=Integer.valueOf(new String(request.getParameter("goods_prize").getBytes("ISO-8859-1"),"UTF-8"));
		rule.setInsert_time(DateUtils.getDate());
		rule.setInsert_user(s.getUsername());
		rule.setRule_name(rule_name);
		rule.setRule_status(1);
		rule.setGoods_prize(goods_prize);
		rule.setRule_type("兑换");
		ruleService.insert(rule);
		request.setAttribute("msg", "提交成功!");
		return "m2_addexchrule";
	}
	
	/*
	 * 删除规则
	 */
	@ResponseBody
	@RequestMapping("/deleterule")
	public void delete(String id) {
		int ii = Integer.valueOf(id);
		ruleService.delete(ii);
	}
	/*
	 * 启用规则
	 */
	@ResponseBody
	@RequestMapping("/start")
	public void start(String id) {
		int ii = Integer.valueOf(id);
		Rule rule=ruleService.selectOne(ii);
		rule.setRule_status(1);
		ruleService.update(rule);
	}
	/*
	 * 停用规则
	 */
	@ResponseBody
	@RequestMapping("/stop")
	public void stop(String id) {
		int ii = Integer.valueOf(id);
		Rule rule=ruleService.selectOne(ii);
		rule.setRule_status(0);
		ruleService.update(rule);
	}
	
}
