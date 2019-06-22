/**
 * @author         zchangyu
 * @Date           2019年6月21日 下午8:49:55
 * @Description    TODO（一句话描述）
 */
package com.sys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {
	private int rule_id;//ID
	private String rule_name;
	private int rule_status;//是否生效  1是  2否
	private String rule_type;//类型： 充值/兑换
	private int add_num;//充
	private int give_num;//送
	private int goods_prize;//  如果是兑换的话  ，需要兑换的物品的所需积分
	private String insert_user;
	private String  insert_time;
}
