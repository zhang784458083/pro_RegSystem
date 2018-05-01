/**
 * @author         zchangyu
 * @Date           2018年5月1日 下午7:11:16
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.pojo;


public class Liuyan {
	private int id;
	private String tel;
	private String name;
	private String content;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Liuyan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Liuyan(int id, String tel, String name, String content, String date) {
		super();
		this.id = id;
		this.tel = tel;
		this.name = name;
		this.content = content;
		this.date = date;
	}
	
	
}
