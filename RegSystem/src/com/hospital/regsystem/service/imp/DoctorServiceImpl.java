/**
 * @author         zchangyu
 * @Date           2018年4月1日 下午5:02:24
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IDoctorDao;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.service.IDoctorService;
@Service("doctorService")
public class DoctorServiceImpl implements IDoctorService{
	@Resource(name="IDoctorDao")
	private IDoctorDao doctorDao;
	
	@Override
	public Doctor selectById(int did,int oid) {
		return doctorDao.selectById(did,oid);
	}
	@Override
	public Doctor selectByDname(String dname,int oid) {
		return doctorDao.selectByDname(dname,oid);
	}
	@Override
	public List<Doctor> selectAll() {
		return doctorDao.selectAll();
	}
	@Override
	public List<Doctor> findDoctorBy(String workid, int oid, String dname, String tel) {
		return doctorDao.findDoctorBy(workid,oid,dname,tel);
	}

}
