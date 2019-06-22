/**
 * @author         zchangyu
 * @Date           2018年12月5日 上午11:56:06
 * @Description    TODO（一句话描述）
 */
package com.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.dao.IManagerDao;
import com.sys.pojo.Manager;
import com.sys.service.IManagerService;

@Service("managerService")
public class ManagerServiceImp implements IManagerService{
	@Resource(name="IManagerDao")
	private IManagerDao managerDao;
	@Override
	public Manager find1(String username) {
		return managerDao.find1(username);
	}
	@Override
	public void resetpassword(String username, String password) {
		managerDao.resetpassword(username,password);
	}
}
