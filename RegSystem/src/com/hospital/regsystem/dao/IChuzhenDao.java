/**
 * @author         zchangyu
 * @Date           2018年5月4日 下午6:06:39
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Chuzhen;

public interface IChuzhenDao {
	public List<Chuzhen> select();
	public Chuzhen selectByVid(@Param("vid")int vid);
	public void updateByVid(@Param("vid")int vid,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("canregis")int canregis,@Param("maxregis")int maxregis);
	public void addChuzhen(@Param("did")int did,@Param("oid")int oid,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("maxregis")int maxregis);
	public List<Chuzhen> findChuzhen(@Param("startime")String startime,@Param("endtime") String endtime,@Param("dname") String dname, @Param("oid")Integer oid);
	public List<Chuzhen> selectBy(@Param("oname")String oname, @Param("dname")String dname);
	public List<Chuzhen> selectByOD(@Param("starttime")String starttime, @Param("endtime")String endtime, @Param("oname")String oname, @Param("dname")String dname);
}
