/**
 * @author         zchangyu
 * @Date           2019年6月15日 下午6:28:12
 * @Description    TODO（一句话描述）
 */
package com.sys.service;

import java.util.List;

import com.sys.pojo.User;

public interface IUserService {
	public List<User> select(int enter_id,String tele,String name);
	public User selectOne(int id);
	public void update(User user);
	public void add(User user);
	public void delete(int id);
}
