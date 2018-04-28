/**
 * @author         zchangyu
 * @Date           2018年3月23日 下午11:45:22
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.hospital.regsystem.pojo.Officelist;

public interface IOfficelistDao {
	public int selectOfficeCanRegAM(@Param("officeId")int officeId,@Param("date1")String date1,@Param("date2")String date2);
	public int selectOfficeCanRegPM(@Param("officeId")int officeId,@Param("date1")String date1,@Param("date2")String date2);
	public void update(@Param("oid")int oid,@Param("starttime") String starttime);
	public Officelist select(@Param("oid")int oid, @Param("starttime")String dateStart,@Param("endtime") String dateEnd);
	public int selectOfficeCanRegAMByDname(@Param("oid")int oid, @Param("did")int did, @Param("string")String string, @Param("string2")String string2);
	public int selectOfficeCanRegPMByDname(@Param("oid")int oid, @Param("did")int did, @Param("string")String string, @Param("string2")String string2);
}
