/**
 * @author         zchangyu
 * @Date           2018年4月24日 下午9:05:11
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import java.util.List;

import com.hospital.regsystem.pojo.Notice;

public interface INoticeDao {
	public List<Notice> selectAll();

}
