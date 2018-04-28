/**
 * @author         zchangyu
 * @Date           2018年3月27日 下午8:49:18
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;

public interface IOfficeService {
	public Office selectOfficeById(int officeid);
	public Office selectOfficeByOname(String oname);
	public List<Office> selectAll();
}
