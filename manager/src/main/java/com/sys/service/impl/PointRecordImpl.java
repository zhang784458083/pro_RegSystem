/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午4:09:49
 * @Description    TODO（一句话描述）
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.dao.IBeerrecordDao;
import com.sys.dao.IPointrecordDao;
import com.sys.pojo.PointRecord;
import com.sys.service.IPointrecordService;
@Service("pointrecordService")
public class PointRecordImpl implements IPointrecordService{
	@Resource(name="IPointrecordDao")
	private IPointrecordDao pointrecordDao;

	@Override
	public List<PointRecord> selectBy(String max, String min, String user_name, String user_tele) {
		return pointrecordDao.selectBy(max, min, user_name, user_tele);
	}
	@Override
	public void insert(PointRecord pointRecord) {
		pointrecordDao.insert(pointRecord);
	}

}
