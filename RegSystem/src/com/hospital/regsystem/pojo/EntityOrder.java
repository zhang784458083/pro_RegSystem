/**
 * @author         zchangyu
 * @Date           2018年4月3日 下午10:45:13
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

import java.util.Date;

public class EntityOrder {
	String oid;
	String regtime;
	String state;
	String desc;
	String oname;
	String dname;
	String endtime;
	String starttime;
	String place;
	
	public EntityOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EntityOrder(String oid, String regtime, String state, String desc, String oname, String dname,
			String endtime, String starttime, String place) {
		super();
		this.oid = oid;
		this.regtime = regtime;
		this.state = state;
		this.desc = desc;
		this.oname = oname;
		this.dname = dname;
		this.endtime = endtime;
		this.starttime = starttime;
		this.place = place;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "EntityOrder [oid=" + oid + ", regtime=" + regtime + ", state=" + state + ", desc=" + desc + ", oname="
				+ oname + ", dname=" + dname + ", endtime=" + endtime + ", starttime=" + starttime + ", place=" + place
				+ "]";
	}
	
	
}
