/**
 * @author         zchangyu
 * @Date           2018年5月3日 下午5:24:26
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.ReturnObj;

public interface IReturnObjService {

	List<ReturnObj> select();
	List<ReturnObj> findO(String max, String min, String orderid, String dname, int s, int o);
	List<ReturnObj> selectByName(String oname, String dname);
	List<ReturnObj> dfindOBy(String orderid, int state, String starttime, String endtime, String oname, String dname);
	ReturnObj dfindOByVid(String orderid);
}
