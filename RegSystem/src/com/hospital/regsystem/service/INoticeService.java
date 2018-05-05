/**
 * @author         zchangyu
 * @Date           2018年4月24日 下午9:03:11
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.Notice;

public interface INoticeService {
	public List<Notice> selectAll();
	public void add(String title, String content, String author);
	public List<Notice> select();
}
