/**
 * @author         zchangyu
 * @Date           2018年3月31日 下午11:47:00
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IOrderDao;
import com.hospital.regsystem.pojo.Order;
import com.hospital.regsystem.service.IOrderService;
@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	@Resource(name="IOrderDao")
	private IOrderDao orderDao;
	
	
	@Override
	public Order selectOrder(int pid, String runstarttime) {
		return orderDao.selectOrder(pid, runstarttime);
	}

	@Override
	public void insert(String orderid,int pid, int oid, int did, String desc, int state,String date, String dateStart, String dateEnd) {
		orderDao.insert(orderid,pid,oid,did,desc,state,date,dateStart,dateEnd);
	}

	@Override
	public List<Order> selectOrderById(int pid) {
		return orderDao.selectOrderById(pid);
	}

	
	@Override
	public List<Order> selectAll() {
		// TODO Auto-generated method stub
		return orderDao.selectAll();
	}

}
