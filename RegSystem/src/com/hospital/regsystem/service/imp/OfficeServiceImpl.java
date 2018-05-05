/**
 * @author         zchangyu
 * @Date           2018年3月27日 下午8:51:06
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IOfficeDao;
import com.hospital.regsystem.pojo.Doctor;
import com.hospital.regsystem.pojo.Office;
import com.hospital.regsystem.service.IOfficeService;
@Service("officeService")
public class OfficeServiceImpl implements IOfficeService{
	@Resource(name="IOfficeDao")
	private IOfficeDao officeDao;
	
	@Override
	public Office selectOfficeById(int officeid) {
		
		return officeDao.selectOfficeById(officeid);
	}
	
	
	@Override
	public Office selectOfficeByOname(String oname) {
		
		return officeDao.selectOfficeByOname(oname);
	}
	
	@Override
	public List<Office> selectAll() {
		return officeDao.selectAll();
	}
	public IOfficeDao getOfficeDao() {
		return officeDao;
	}

	public void setOfficeDao(IOfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	@Override
	public void add(String oname, String desc) {
		officeDao.add(oname,desc);
		
	}

	@Override
	public List<Office> findOfficeBy(int did, String dname) {
		return officeDao.findOfficeBy(did,dname);
	}
	@Override
	public void update(Integer oid, String odesc) {
		 officeDao.updateoffice(oid,odesc);
	}

	

}
