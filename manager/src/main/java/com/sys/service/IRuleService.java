/**
 * @author         zchangyu
 * @Date           2019年6月21日 下午10:59:18
 * @Description    TODO（一句话描述）
 */
package com.sys.service;

import java.util.List;

import com.sys.pojo.Rule;

public interface IRuleService {
	public List<Rule> selectOn(String rule_type);
	public List<Rule> selectAll(String rule_type,String rule_name);
	public Rule selectOne(int rule_id);
	public void insert(Rule rule);
	public void update(Rule rule);
	public void delete(int rule_id);
}
