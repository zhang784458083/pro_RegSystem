/**
 * @author         zchangyu
 * @Date           2018年3月31日 下午11:46:30
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.Order;

public interface IOrderService {
	public Order selectOrder(int pid,String runstarttime);
	public List<Order> selectOrderById(int pid);
	void insert(String orderid,int pid, int oid,int did,String desc,int state,String regtime, String dateStart, String dateEnd);
	public List<Order> selectAll();
	public void update(String orderid, int state, String result);
}
