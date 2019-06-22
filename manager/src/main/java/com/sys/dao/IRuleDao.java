/**
 * @author         zchangyu
 * @Date           2019年6月21日 下午8:54:50
 * @Description    TODO（一句话描述）
 */
package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.Rule;

public interface IRuleDao {
	public List<Rule> selectOn(@Param("rule_type")String rule_type);
	public List<Rule> selectAll(@Param("rule_type")String rule_type,@Param("rule_name")String rule_name);
	public Rule selectOne(@Param("rule_id")int rule_id);
	public void insert(Rule rule);
	public void update(Rule rule);
	public void delete(@Param("rule_id")int rule_id);
}
