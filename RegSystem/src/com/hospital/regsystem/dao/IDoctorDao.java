/**
 * @author         zchangyu
 * @Date           2018年4月1日 下午4:45:46
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Doctor;

public interface IDoctorDao {
	public Doctor selectById(@Param("did")int did,@Param("oid")int oid);
	public Doctor selectByDname(@Param("dname")String dname,@Param("oid")int oid);
	public List<Doctor> selectAll();
	public List<Doctor> findDoctorBy(@Param("workid")String workid, @Param("oid")int oid, @Param("dname")String dname, @Param("tel")String tel);
	public int selectCount(@Param("oid")int oid);
	public void adddoctor(@Param("workid")String workid,@Param("dname") String dname,@Param("dsex") String dsex, @Param("role")int role, @Param("cost")int cost, @Param("username")String username, @Param("username")String username2,
			@Param("tel")String tel, @Param("oid")int oid, @Param("place")String place);
	
	public Doctor selectByname(@Param("username")String username);
	
}
