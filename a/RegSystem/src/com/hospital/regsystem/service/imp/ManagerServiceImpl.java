/**
 * @author         zchangyu
 * @Date           2018年3月10日 下午10:32:05
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.IManagerDao;
import com.hospital.regsystem.pojo.Manager;
import com.hospital.regsystem.service.IManagerService;
@Service("managerService")
public class ManagerServiceImpl implements IManagerService{
	@Resource(name="IManagerDao")
	private IManagerDao managerDao;
	@Override
	public Manager find(String username) {
		return managerDao.find(username);
	}
	
}
