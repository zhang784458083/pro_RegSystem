/**
 * @author         zchangyu
 * @Date           2018年3月24日 下午5:26:23
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Officelist {
	int vid;
	int oid;
	int did;
	int role;
	String starttime;
	String endtime;
	int nowregis;
	int maxregis;
	int canregis;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
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
	public int getNowregis() {
		return nowregis;
	}
	public void setNowregis(int nowregis) {
		this.nowregis = nowregis;
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
	public Officelist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Officelist(int vid, int oid, int did, int role, String starttime, String endtime, int nowregis, int maxregis,
			int canregis) {
		super();
		this.vid = vid;
		this.oid = oid;
		this.did = did;
		this.role = role;
		this.starttime = starttime;
		this.endtime = endtime;
		this.nowregis = nowregis;
		this.maxregis = maxregis;
		this.canregis = canregis;
	}
	@Override
	public String toString() {
		return "Officelist [vid=" + vid + ", oid=" + oid + ", did=" + did + ", role=" + role + ", starttime="
				+ starttime + ", endtime=" + endtime + ", nowregis=" + nowregis + ", maxregis=" + maxregis
				+ ", canregis=" + canregis + "]";
	}
	
}
