/**
 * @author         zchangyu
 * @Date           2018年3月31日 下午11:45:23
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Order;

public interface IOrderDao {
	public Order selectOrder(@Param("pid")int pid,@Param("runstarttime")String runstarttime); 
	void insert(@Param("orderid")String orderid,@Param("pid")int pid, @Param("oid")int oid, @Param("did")int did, @Param("desc")String desc,@Param("state")int state,@Param("regtime")String regtime,@Param("runstarttime")  String dateStart,@Param("runendtime")  String endTime);
	public List<Order> selectOrderById(@Param("pid")int pid);
	public List<Order> selectAll();
	public void update(@Param("orderid")String orderid, @Param("state")int state, @Param("result")String result);
}
