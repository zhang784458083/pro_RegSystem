/**
 * @author         zchangyu
 * @Date           2018年12月5日 上午11:55:40
 * @Description    TODO（一句话描述）
 */
package com.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.Manager;

public interface IManagerDao {
	public Manager find1(@Param("username")String username);
	public void resetpassword(@Param("username")String username, @Param("password")String password);
}
