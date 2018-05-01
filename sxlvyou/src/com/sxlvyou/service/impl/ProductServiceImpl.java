/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午4:51:06
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxlvyou.dao.IProductDao;
import com.sxlvyou.pojo.Product;
import com.sxlvyou.service.IProductService;
@Service("productService")
public class ProductServiceImpl implements IProductService{
	@Resource(name="IProductDao")
	private IProductDao productDao;
	@Override
	public List<Product> selectByType(String type) {
		return productDao.selectByType(type);
	}
	
	@Override
	public Product selectOne(int id) {
		return productDao.selectOne(id);
	}

	
	@Override
	public List<Product> selectAll() {
		
		return productDao.selectAll();
	}

	
	@Override
	public void delete(Integer id) {
		productDao.delete(id);
		
	}

	@Override
	public void add(String type, String title, String concent, String img, String string, Date date) {
		productDao.add(type,title,concent,img,"admin",new Date());
	}

}
