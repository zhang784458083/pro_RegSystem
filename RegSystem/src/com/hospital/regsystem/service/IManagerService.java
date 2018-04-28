/**
 * @author         zchangyu
 * @Date           2018年3月10日 下午10:30:36
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import com.hospital.regsystem.pojo.Manager;

public interface IManagerService {
	public Manager find(String username);
}
