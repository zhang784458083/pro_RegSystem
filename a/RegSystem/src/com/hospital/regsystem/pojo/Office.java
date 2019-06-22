/**
 * @author         zchangyu
 * @Date           2018年3月27日 下午8:38:00
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.pojo;

public class Office {
	int oid;
	String oname;
	String odesc;
	public Office(int oid, String oname, String odesc) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.odesc = odesc;
	}
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOdesc() {
		return odesc;
	}
	public void setOdesc(String odesc) {
		this.odesc = odesc;
	}
	@Override
	public String toString() {
		return "Office [oid=" + oid + ", oname=" + oname + ", odesc=" + odesc + "]";
	}
	
}
