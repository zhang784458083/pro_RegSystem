/**
 * @author         zchangyu
 * @Date           2018年3月10日 下午10:18:32
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Manager {
	private int id;
	private String username;
	private String password;
	private String tele;
	private String ip;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int id, String username, String password, String tele, String ip) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tele = tele;
		this.ip = ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", password=" + password + ", tele=" + tele + ", ip="
				+ ip + "]";
	}
	
	
}
