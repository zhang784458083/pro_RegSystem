/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午2:56:31
 * @Description    TODO（一句话描述）
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.dao.IBeerrecordDao;
import com.sys.pojo.BeerRecord;
import com.sys.service.IBeerrecordService;
@Service("beerrecordService")
public class BeerrecordImpl implements IBeerrecordService{
	@Resource(name="IBeerrecordDao")
	private IBeerrecordDao beerrecordDao;

	@Override
	public List<BeerRecord> selectBy(String max, String min, String user_name, String user_tele) {
		return beerrecordDao.selectBy(max, min, user_name, user_tele);
	}

	@Override
	public void insert(BeerRecord beerRecord) {
		beerrecordDao.insert(beerRecord);
	}
}
