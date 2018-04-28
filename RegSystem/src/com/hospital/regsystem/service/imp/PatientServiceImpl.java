/**
 * @author         zchangyu
 * @Date           2018年2月22日 下午4:59:06
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IPatientDao;
import com.hospital.regsystem.pojo.Patient;
import com.hospital.regsystem.service.IPatientService;
@Service("patientService")
public class PatientServiceImpl implements IPatientService{
	@Resource(name="IPatientDao")
	private IPatientDao patientDao;
	@Override
	public List<Patient> selectAll() {
		return patientDao.selectAll();
	}
	public IPatientDao getPatientDao() {
		return patientDao;
	}
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	@Override
	public void reg(Patient p) {
		patientDao.reg(p);
	}
	@Override
	public Patient checkUser(String username) {
		
		return patientDao.checkUser(username);
	}
	
	@Override
	public void updateAccThree(int pid) {
		patientDao.updateAccThree(pid);
	}
	@Override
	public void updateAccFive(int pid) {
		patientDao.updateAccFive(pid);
	}
	
	@Override
	public void pay(int pid, double account) {
		patientDao.pay(pid,account);
		
	}
	@Override
	public void update(int pid, String tel, String email, String pdesc) {
		patientDao.update(pid,tel ,email, pdesc);
		
	}
	
	@Override
	public void updatepwd(String pwd, String userName) {
		patientDao.updatepwd(pwd,userName);
	}
	
	@Override
	public List<Patient> findBySQL(String max, String min, String usernanme, String tel) {
		return patientDao.findBySQL(max,min,usernanme,tel);
	}
	
}
