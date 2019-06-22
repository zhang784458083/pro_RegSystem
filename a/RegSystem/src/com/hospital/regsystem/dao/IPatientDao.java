/**
 * @author         zchangyu
 * @Date           2018年2月22日 下午5:02:08
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Patient;

public interface IPatientDao {
	public List<Patient> selectAll();
	public void reg(Patient p);
	public Patient checkUser(String username);
	public void updateAccThree(int pid);
	public void updateAccFive(int pid);
	public void pay(@Param("pid")int pid, @Param("account")double account);
	public void update(@Param("pid")int pid, @Param("tel")String tel, @Param("email")String email,@Param("pdesc") String pdesc);
	public void updatepwd(@Param("pwd")String pwd,@Param("userName") String userName);
	public List<Patient> findBySQL(@Param("max")String max, @Param("min")String min, @Param("username")String usernanme, @Param("tel")String tel);
	
	
}
