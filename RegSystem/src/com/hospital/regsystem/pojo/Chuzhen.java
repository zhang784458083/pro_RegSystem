/**
 * @author         zchangyu
 * @Date           2018年5月4日 下午5:52:45
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Chuzhen {
	private int vid;
	private String oname;
	private String dname;
	private String role;
	private String starttime;
	private String endtime;
	private int maxregis;
	private int canregis;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getMaxregis() {
		return maxregis;
	}
	public void setMaxregis(int maxregis) {
		this.maxregis = maxregis;
	}
	public int getCanregis() {
		return canregis;
	}
	public void setCanregis(int canregis) {
		this.canregis = canregis;
	}
	public Chuzhen() {
		super();
	}
	public Chuzhen(int vid, String oname, String dname, String role, String starttime, String endtime, int maxregis,
			int canregis) {
		super();
		this.vid = vid;
		this.oname = oname;
		this.dname = dname;
		this.role = role;
		this.starttime = starttime;
		this.endtime = endtime;
		this.maxregis = maxregis;
		this.canregis = canregis;
	}
	@Override
	public String toString() {
		return "Chuzhen [vid=" + vid + ", oname=" + oname + ", dname=" + dname + ", role=" + role + ", starttime="
				+ starttime + ", endtime=" + endtime + ", maxregis=" + maxregis + ", canregis=" + canregis + "]";
	}
	
}
