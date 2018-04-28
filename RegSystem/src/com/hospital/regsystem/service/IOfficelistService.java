/**
 * @author         zchangyu
 * @Date           2018年3月23日 下午11:37:59
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.Date;

import com.hospital.regsystem.pojo.Officelist;

public interface IOfficelistService {
	public int selectOfficeCanRegAM(int officeId,String date1,String date2);
	public int selectOfficeCanRegPM(int officeId,String date1,String date2);
	public void update(int oid,String starttime);
	public Officelist select(int oid, String dateStart, String dateEnd);
	public int selectOfficeCanRegAMByDname(int oid, int did, String string, String string2);
	public int selectOfficeCanRegPMByDname(int oid, int did, String string, String string2);
	 
}
