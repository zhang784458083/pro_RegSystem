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
public class BeerRecord {
	private int record_id;
	private String service_time;//时间
	private String record_name;//充值还是消费
	private String user_name;//姓名
	private String user_tele;//电话
	private String rule_name;//活动名称
	private String pay;//支付方式
	private int user_old;//原来数量
	private int user_num;//变化数量
	private int user_new;//现在数量
	private String manager;//操作员
}
