/**
 * @author         zchangyu
 * @Date           2018年5月3日 下午5:23:45
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.ReturnObj;

public interface IReturnObjDao {

	List<ReturnObj> select();
	List<ReturnObj> findO(@Param("max")String max, @Param("min")String min, @Param("orderid")String orderid, @Param("dname")String dname, @Param("s")int s, @Param("o")int o);
	List<ReturnObj> selectByName(@Param("oname")String oname,@Param("dname") String dname);
	List<ReturnObj> dfindOBy(@Param("orderid")String orderid,@Param("state") int state, @Param("starttime")String starttime, @Param("endtime")String endtime, @Param("oname")String oname, @Param("dname")String dname);
	ReturnObj dfindOByVid(@Param("orderid")String orderid);
	
}
