/**
 * @author         zchangyu
 * @Date           2018年3月31日 下午11:42:18
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

import java.util.Date;

public class Order {
	int rid;
	String orderid;
	int pid;
	int oid;
	int did;
	String desc;
	int state;
	String regtime;
	String canceltime;
	String finshtime;
	String result;
	String runstarttime;
	String runendtime;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getCanceltime() {
		return canceltime;
	}
	public void setCanceltime(String canceltime) {
		this.canceltime = canceltime;
	}
	public String getFinshtime() {
		return finshtime;
	}
	public void setFinshtime(String finshtime) {
		this.finshtime = finshtime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRunstarttime() {
		return runstarttime;
	}
	public void setRunstarttime(String runstarttime) {
		this.runstarttime = runstarttime;
	}
	public String getRunendtime() {
		return runendtime;
	}
	public void setRunendtime(String runendtime) {
		this.runendtime = runendtime;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int rid, String orderid, int pid, int oid, int did, String desc, int state, String regtime,
			String canceltime, String finshtime, String result, String runstarttime, String runendtime) {
		super();
		this.rid = rid;
		this.orderid = orderid;
		this.pid = pid;
		this.oid = oid;
		this.did = did;
		this.desc = desc;
		this.state = state;
		this.regtime = regtime;
		this.canceltime = canceltime;
		this.finshtime = finshtime;
		this.result = result;
		this.runstarttime = runstarttime;
		this.runendtime = runendtime;
	}
	@Override
	public String toString() {
		return "Order [rid=" + rid + ", orderid=" + orderid + ", pid=" + pid + ", oid=" + oid + ", did=" + did
				+ ", desc=" + desc + ", state=" + state + ", regtime=" + regtime + ", canceltime=" + canceltime
				+ ", finshtime=" + finshtime + ", result=" + result + ", runstarttime=" + runstarttime + ", runendtime="
				+ runendtime + "]";
	}
	
	
}
