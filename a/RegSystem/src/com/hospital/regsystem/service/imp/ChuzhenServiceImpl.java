/**
 * @author         zchangyu
 * @Date           2018年5月4日 下午6:05:27
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IChuzhenDao;
import com.hospital.regsystem.pojo.Chuzhen;
import com.hospital.regsystem.service.IChuzhenService;
@Service("chuzhenService")
public class ChuzhenServiceImpl implements IChuzhenService{
	@Resource(name="IChuzhenDao")
	IChuzhenDao chuzhenDao;
	@Override
	public List<Chuzhen> select() {
		return chuzhenDao.select();
	}

	@Override
	public Chuzhen selectByVid(int vid) {
		return chuzhenDao.selectByVid(vid);
	}

	@Override
	public void updateByVid(int vid,String starttime,String endtime,int canregis,int maxregis) {
		chuzhenDao.updateByVid(vid, starttime, endtime, canregis, maxregis);
	}
		
	@Override
	public void addChuzhen(int did, int oid, String starttime, String endtime, int maxregis) {
		chuzhenDao.addChuzhen(did, oid, starttime, endtime, maxregis);
	}

	@Override
	public List<Chuzhen> findChuzhen(String startime, String endtime, String dname, Integer oid) {
		return chuzhenDao.findChuzhen(startime,endtime,dname,oid);
	}

	@Override
	public List<Chuzhen> selectBy(String oname, String dname) {
		return chuzhenDao.selectBy(oname,dname);
	}

	@Override
	public List<Chuzhen> selectByOD(String starttime, String endtime, String oname, String dname) {
		return chuzhenDao.selectByOD(starttime,endtime,oname,dname);
	}
	
}
