/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午2:55:48
 * @Description    TODO（一句话描述）
 */
package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.BeerRecord;
import com.sys.pojo.PointRecord;

public interface IPointrecordService {
	public List<PointRecord> selectBy(String max, String min,String user_name,String user_tele);
	public void insert(PointRecord pointRecord);
	
}