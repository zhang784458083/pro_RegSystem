/**
 * @author         zchangyu
 * @Date           2018年3月27日 下午8:45:47
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;

public interface IOfficeDao {
	public Office selectOfficeById(int officeid);
	public Office selectOfficeByOname(String oname);
	public List<Office> selectAll();
}
