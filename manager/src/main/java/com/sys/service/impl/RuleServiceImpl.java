/**
 * @author         zchangyu
 * @Date           2019年6月21日 下午11:00:06
 * @Description    TODO（一句话描述）
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.dao.IRuleDao;
import com.sys.dao.IUserDao;
import com.sys.pojo.Rule;
import com.sys.service.IRuleService;
@Service("ruleService")
public class RuleServiceImpl implements IRuleService{
	@Resource(name="IRuleDao")
	private IRuleDao ruleDao;
	@Override
	public List<Rule> selectOn(String rule_type) {
		return ruleDao.selectOn(rule_type);
	}

	@Override
	public List<Rule> selectAll(String rule_type, String rule_name) {
		return ruleDao.selectAll(rule_type, rule_name);
	}

	@Override
	public Rule selectOne(int rule_id) {
		return ruleDao.selectOne(rule_id);
	}
	@Override
	public void insert(Rule rule) {
		ruleDao.insert(rule);
	}

	@Override
	public void update(Rule rule) {
		ruleDao.update(rule);
	}

	@Override
	public void delete(int rule_id) {
		ruleDao.delete(rule_id);
	}

}
