/**
 * @author         zchangyu
 * @Date           2019年6月15日 下午6:06:37
 * @Description    TODO（一句话描述）
 */
package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.User;

public interface IUserDao {
	public List<User> select(@Param("enter_id") int enter_id,@Param("tele")String tele,@Param("name")String name);
	public User selectOne(@Param("id")int id);
	public void update(User user);
	public void insert(User user);
	public void delete(@Param("id")int id);
}
