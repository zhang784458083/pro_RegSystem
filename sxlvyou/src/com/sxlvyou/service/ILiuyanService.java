/**
 * @author         zchangyu
 * @Date           2018年5月1日 下午7:13:27
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.service;

import java.util.List;

import com.sxlvyou.pojo.Liuyan;

public interface ILiuyanService {
	public List<Liuyan> selectAll();
	public void insert(String tel,String name,String content);
}
