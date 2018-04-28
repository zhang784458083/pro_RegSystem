/**
 * @author         zchangyu
 * @Date           2018年4月24日 下午9:04:02
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hospital.regsystem.dao.INoticeDao;
import com.hospital.regsystem.pojo.Notice;
import com.hospital.regsystem.service.INoticeService;
@Service("noticeService")
public class NoticeServiceImpl implements INoticeService{
	@Resource(name="INoticeDao")
	private INoticeDao noticeDao;
	@Override
	public List<Notice> selectAll() {
		return noticeDao.selectAll();
	}

}
