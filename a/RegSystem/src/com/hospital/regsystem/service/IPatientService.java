/**
 * @author         zchangyu
 * @Date           2018年2月22日 下午4:58:41
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.Patient;

public interface IPatientService {

	public List<Patient> selectAll();
	public void reg(Patient p);
	public Patient checkUser(String username);
	public void updateAccThree(int pid);
	public void updateAccFive(int pid);
	public void pay(int pid, double account);
	public void update(int pid, String tel, String email, String pdesc);
	public void updatepwd(String pwd, String userName);
	public List<Patient> findBySQL(String max, String min, String usernanme, String tel);
	
}
