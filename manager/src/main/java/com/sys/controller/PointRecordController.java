/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午3:07:32
 * @Description    TODO（一句话描述）
 */
package com.sys.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.sys.pojo.BeerRecord;
import com.sys.pojo.Manager;
import com.sys.pojo.PointRecord;
import com.sys.pojo.User;
import com.sys.service.IBeerrecordService;
import com.sys.service.IManagerService;
import com.sys.service.IPointrecordService;
import com.sys.service.IRuleService;
import com.sys.service.IUserService;
import com.sys.utils.DateUtils;
import com.sys.utils.ExcelUtil;

@Controller()
public class PointRecordController {
	@Resource(name="managerService")
	private IManagerService managerService;
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="ruleService")
	private IRuleService ruleService;
	@Resource(name="pointrecordService")
	private IPointrecordService pointrecordService;
	/*
	 * 查看积分记录信息
	 */
	@RequestMapping("/m_pointrecordlist")
	public String m_pointrecordlist(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Manager s = (Manager) request.getSession().getAttribute("loginUser");
		if(s==null){
			return "m_login";
		}
		String name=null,tele=null,max=null,min=null;
		if(request.getParameter("datemax")!=null && !request.getParameter("datemax").equals("")){
			max=new String(request.getParameter("datemax").getBytes("ISO-8859-1"),"UTF-8");
		}
		if(request.getParameter("datemin")!=null&& !request.getParameter("datemin").equals("")){
			min=new String(request.getParameter("datemin").getBytes("ISO-8859-1"),"UTF-8");
		}
		if(request.getParameter("name")!=null && !request.getParameter("name").equals("")){
			name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		}
		if(request.getParameter("tele")!=null && !request.getParameter("tele").equals("")){
			tele=new String(request.getParameter("tele").getBytes("ISO-8859-1"),"UTF-8");
		}
		List<PointRecord> cuns=pointrecordService.selectBy(max, min, name, tele);
		request.setAttribute("list", cuns);
		return "m_pointrecordlist";
	}
	@ResponseBody
	@RequestMapping("/downPR")
	public void down(String id,HttpServletRequest request) throws NumberFormatException, UnsupportedEncodingException{
		int i=Integer.valueOf(id);
		List<PointRecord> beerRecords=pointrecordService.selectBy(null, null, null, null);
		Iterator<PointRecord> usIterator=beerRecords.iterator();
		String path = "D:\\"+DateUtils.getTimes()+".xls";
		//表头
		List<String> headers = Lists.newArrayList();
		/*for (int i = 1; i < 10; i++) {*/
			headers.add("时间");
			headers.add("类型");
			headers.add("顾客");
			headers.add("电话");
			headers.add("原有积分(分)");
			headers.add("变动积分(分)");
			headers.add("现有积分(分)");
			headers.add("明细");
			headers.add("操作员");
		/*}*/
		//数据行
		List<Map> datas = new ArrayList<Map>();
		Map m = null;
		for(int i1=1;i1<7;i1++){
			m = new HashMap(); //一行数据集
			while(usIterator.hasNext()){
				PointRecord beerRecord=usIterator.next();
				m.put(0, beerRecord.getService_time());
				m.put(1, beerRecord.getRecord_name());
				m.put(2, beerRecord.getUser_name());
				m.put(3, beerRecord.getUser_tele());
				m.put(4, beerRecord.getUser_old());
				m.put(5, beerRecord.getUser_num());
				m.put(6, beerRecord.getUser_new());
				m.put(7, beerRecord.getContent());
				m.put(8, beerRecord.getManager());
				
			}
			datas.add(m);
			
		}
		
		ExcelUtil.ExpExs(path,"","营销报表",headers,datas);
	}
}
