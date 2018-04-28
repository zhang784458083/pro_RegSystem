/**
 * @author         zchangyu
 * @Date           2018年3月10日 下午10:20:45
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.dao;

import com.hospital.regsystem.pojo.Manager;

public interface IManagerDao {
	public Manager find(String username);
}
