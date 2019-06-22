/**
 * @author         zchangyu
 * @Date           2018年12月5日 上午11:55:17
 * @Description    TODO（一句话描述）
 */
package com.sys.service;

import com.sys.pojo.Manager;

public interface IManagerService {
	public Manager find1(String username);
	public void resetpassword(String username, String password);
}
