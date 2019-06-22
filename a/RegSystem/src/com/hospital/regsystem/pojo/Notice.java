/**
 * @author         zchangyu
 * @Date           2018年4月24日 下午5:41:55
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Notice {
	private int nid;
	private String title;
	private String date;
	private String author;
	private String content;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int nid, String title, String date, String author, String content) {
		super();
		this.nid = nid;
		this.title = title;
		this.date = date;
		this.author = author;
		this.content = content;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", title=" + title + ", date=" + date + ", author=" + author + ", content="
				+ content + "]";
	}
	
}
