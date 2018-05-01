/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午4:54:16
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxlvyou.pojo.Product;

public interface IProductDao {
	public List<Product> selectByType(@Param("type")String type);
	public Product selectOne(@Param("id")int id);
	public List<Product> selectAll();
	
	public void delete(@Param("id")Integer id);
	
	public void add(@Param("type")String type, @Param("title")String title, @Param("content")String concent, @Param("img")String img, @Param("string")String string, Date date);
}
