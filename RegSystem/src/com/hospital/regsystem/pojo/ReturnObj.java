/**
 * @author         zchangyu
 * @Date           2018年5月3日 下午5:17:01
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class ReturnObj {
	private String orderid;
	private String oname ;
	private String dname;
	private String pname;
	private String descs;
	private String regtime;
	private String runstarttime;
	private String runendtime;
	private String state;
	private String finshtime;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFinshtime() {
		return finshtime;
	}
	public void setFinshtime(String finshtime) {
		this.finshtime = finshtime;
	}
	public ReturnObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnObj(String orderid, String oname, String dname, String pname, String descs, String regtime,
			String runstarttime, String runendtime, String state, String finshtime) {
		super();
		this.orderid = orderid;
		this.oname = oname;
		this.dname = dname;
		this.pname = pname;
		this.descs = descs;
		this.regtime = regtime;
		this.runstarttime = runstarttime;
		this.runendtime = runendtime;
		this.state = state;
		this.finshtime = finshtime;
	}
	@Override
	public String toString() {
		return "ReturnObj [orderid=" + orderid + ", oname=" + oname + ", dname=" + dname + ", pname=" + pname
				+ ", descs=" + descs + ", regtime=" + regtime + ", runstarttime=" + runstarttime + ", runendtime="
				+ runendtime + ", state=" + state + ", finshtime=" + finshtime + "]";
	}
	
	
}
