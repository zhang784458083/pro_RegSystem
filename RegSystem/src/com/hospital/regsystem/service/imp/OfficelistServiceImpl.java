/**
 * @author         zchangyu
 * @Date           2018年3月24日 上午12:05:52
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IOfficelistDao;
import com.hospital.regsystem.pojo.Officelist;
import com.hospital.regsystem.service.IOfficelistService;
@Service("officelistService")
public class OfficelistServiceImpl implements IOfficelistService{
	@Resource(name="IOfficelistDao")
	private IOfficelistDao officelistDao;
	
	@Override
	public int selectOfficeCanRegAM(int officeId, String date1, String date2) {
		
		return officelistDao.selectOfficeCanRegAM(officeId, date1, date2);
	}

	@Override
	public int selectOfficeCanRegPM(int officeId, String date1, String date2) {
		return officelistDao.selectOfficeCanRegPM(officeId, date1, date2);
	}
	
	@Override
	public void update(int oid, String starttime) {
		officelistDao.update(oid, starttime);
		
	}
	@Override
	public Officelist select(int oid, String dateStart, String dateEnd) {
		return officelistDao.select(oid,dateStart,dateEnd);
	}
	
	
	
	
	public IOfficelistDao getOfficelistDao() {
		return officelistDao;
	}

	public void setOfficelistDao(IOfficelistDao officelistDao) {
		this.officelistDao = officelistDao;
	}

	@Override
	public int selectOfficeCanRegAMByDname(int oid, int did, String string, String string2) {
		return officelistDao.selectOfficeCanRegAMByDname(oid,did,string,string2);
	}
	@Override
	public int selectOfficeCanRegPMByDname(int oid, int did, String string, String string2) {
		return officelistDao.selectOfficeCanRegPMByDname(oid,did,string,string2);
	}

	

}
