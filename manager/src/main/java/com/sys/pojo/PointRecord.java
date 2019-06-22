/**
 * @author         zchangyu
 * @Date           2019年6月22日 下午2:40:20
 * @Description    TODO（一句话描述）
 */
package com.sys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointRecord {
	private int record_id;
	private String service_time;//时间
	private String record_name;//积分还是兑换
	private String user_name;//姓名
	private String user_tele;//电话
	private int user_old;//原来分
	private int user_num;//变化分
	private int user_new;//现在分
	private String content;//明细
	private String manager;//操作员
}
