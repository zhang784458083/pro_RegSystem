/**
 * @author         zchangyu
 * @Date           2018年5月1日 下午7:14:52
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxlvyou.dao.ILiuyanDao;
import com.sxlvyou.pojo.Liuyan;
import com.sxlvyou.service.ILiuyanService;
@Service("liuyanService")
public class LiuyanServiceImpl implements ILiuyanService{

	@Resource(name="ILiuyanDao")
	private ILiuyanDao liuyanDao;
	@Override
	public List<Liuyan> selectAll() {
		return liuyanDao.selectAll();
	}

	@Override
	public void insert(String tel, String name, String content) {
		liuyanDao.insert(tel, name, content);
	}

}
