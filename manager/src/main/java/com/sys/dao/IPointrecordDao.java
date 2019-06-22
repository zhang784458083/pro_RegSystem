/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午4:08:33
 * @Description    TODO（一句话描述）
 */
package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.PointRecord;

public interface IPointrecordDao {
	public List<PointRecord> selectBy(@Param("max") String max, @Param("min")String min,@Param("user_name")String user_name,@Param("user_tele")String user_tele);
	public void insert(PointRecord pointRecord);
	
}
