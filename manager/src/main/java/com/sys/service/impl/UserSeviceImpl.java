/**
 * @author         zchangyu
 * @Date           2019年6月15日 下午6:28:53
 * @Description    TODO（一句话描述）
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.dao.IManagerDao;
import com.sys.dao.IUserDao;
import com.sys.pojo.User;
import com.sys.service.IUserService;
@Service("userService")
public class UserSeviceImpl implements IUserService{
	@Resource(name="IUserDao")
	private IUserDao userDao;
	@Override
	public List<User> select(int enter_id,String tele, String name) {
		return userDao.select(enter_id,tele, name);
	}
	@Override
	public User selectOne(int id) {
		return userDao.selectOne(id);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void add(User user) {
		userDao.insert(user);
	}
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
	
}
