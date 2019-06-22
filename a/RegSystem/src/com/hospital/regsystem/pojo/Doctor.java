/**
 * @author         zchangyu
 * @Date           2018年4月1日 下午4:51:16
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Doctor {
	private int did;
	private String workid;
	private String dname;
	private String dsex;
	private int role;
	private int cost;
	private String username;
	private String password;
	private String tel;
	private int oid;
	private String place;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDsex() {
		return dsex;
	}
	public void setDsex(String dsex) {
		this.dsex = dsex;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int did, String workid, String dname, String dsex, int role, int cost, String username,
			String password, String tel, int oid, String place) {
		super();
		this.did = did;
		this.workid = workid;
		this.dname = dname;
		this.dsex = dsex;
		this.role = role;
		this.cost = cost;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.oid = oid;
		this.place = place;
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", workid=" + workid + ", dname=" + dname + ", dsex=" + dsex + ", role=" + role
				+ ", cost=" + cost + ", username=" + username + ", password=" + password + ", tel=" + tel + ", oid="
				+ oid + ", place=" + place + "]";
	}

	
}
