/**
 * @author         zchangyu
 * @Date           2018年5月3日 下午5:24:48
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IReturnObjDao;
import com.hospital.regsystem.pojo.ReturnObj;
import com.hospital.regsystem.service.IReturnObjService;
@Service("returnobjService")
public class ReturnObjSericeImpl implements IReturnObjService{
	@Resource(name="IReturnObjDao")
	private IReturnObjDao returnobjDao;

	@Override
	public List<ReturnObj> select() {
		return returnobjDao.select();
	}
	@Override
	public List<ReturnObj> findO(String max, String min, String orderid, String dname, int s, int o) {
		return returnobjDao.findO(max,  min,  orderid,  dname,  s,  o);
	}
	@Override
	public List<ReturnObj> selectByName(String oname, String dname) {
		return returnobjDao.selectByName(oname,dname);
	}
	@Override
	public List<ReturnObj> dfindOBy(String orderid, int state, String starttime, String endtime, String oname,
			String dname) {
		return returnobjDao.dfindOBy(orderid,state,starttime,endtime,oname,dname);
	}
	@Override
	public ReturnObj dfindOByVid(String orderid) {
		return returnobjDao.dfindOByVid(orderid);
	}
}
