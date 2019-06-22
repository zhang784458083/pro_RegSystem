/**
 * @author         zchangyu
 * @Date           2018年3月27日 下午8:45:47
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Office;

public interface IOfficeDao {
	public Office selectOfficeById(int officeid);
	public Office selectOfficeByOname(String oname);
	public List<Office> selectAll();
	public void add(@Param("oname")String oname,@Param("odesc") String desc);
	public List<Office> findOfficeBy(@Param("did")int did, @Param("dname")String dname);
	public void updateoffice(@Param("oid")Integer oid, @Param("odesc")String odesc);
}
