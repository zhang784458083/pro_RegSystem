/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午4:46:08
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.pojo;

public class Product {
	private int id;
	private String type;
	private String title;
	private String content;
	private String img;
	private String auther;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String type, String title, String content, String img, String auther, String date) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.content = content;
		this.img = img;
		this.auther = auther;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + ", img=" + img
				+ ", auther=" + auther + ", date=" + date + "]";
	}
	
}
