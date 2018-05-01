/**
 * @author         zchangyu
 * @Date           2018年5月1日 下午7:15:34
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxlvyou.pojo.Liuyan;

public interface ILiuyanDao {
	public List<Liuyan> selectAll();
	public void insert(@Param("tel")String tel,@Param("name")String name,@Param("content")String content);
}
