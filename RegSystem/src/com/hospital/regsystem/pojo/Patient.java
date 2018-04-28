/**
 * @author         zchangyu
 * @Date           2018年2月22日 上午10:50:01
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

import java.util.Date;

public class Patient {
	private int pid;//主键 id
	private String pname;//姓名
	private String sex;//性别
	private String birthday;//生日
	private String regdate;//生日
	private String pdesc;//家庭地址
	private String idNumber;//身份证号
	private String tel;//手机
	private String userName;//用户名
	private String email;//邮箱
	private String pwd;//密码
	private String state;//状态
	private double account;
	public Patient() {
		super();
	}
	public Patient(int pid, String pname, String sex, String birthday, String regdate, String pdesc, String idNumber,
			String tel, String userName, String email, String pwd, String state, double account) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.sex = sex;
		this.birthday = birthday;
		this.regdate = regdate;
		this.pdesc = pdesc;
		this.idNumber = idNumber;
		this.tel = tel;
		this.userName = userName;
		this.email = email;
		this.pwd = pwd;
		this.state = state;
		this.account = account;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", sex=" + sex + ", birthday=" + birthday + ", regdate="
				+ regdate + ", pdesc=" + pdesc + ", idNumber=" + idNumber + ", tel=" + tel + ", userName=" + userName
				+ ", email=" + email + ", pwd=" + pwd + ", state=" + state + ", account=" + account + "]";
	}
	
	
	
	
}
