/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午4:49:58
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.service;

import java.util.Date;
import java.util.List;

import com.sxlvyou.pojo.Product;

public interface IProductService {
	public List<Product> selectByType(String type);
	public Product selectOne(int id);

	public List<Product> selectAll();
	
	public void delete(Integer id);
	
	public void add(String type, String title, String concent, String img, String string, Date date);
}
