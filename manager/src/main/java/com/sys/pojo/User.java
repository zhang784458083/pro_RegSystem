/**
 * @author         zchangyu
 * @Date           2019年6月15日 下午5:59:29
 * @Description    TODO（一句话描述）
 */
package com.sys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int user_id;
	private String user_tele;
	private String user_name;
	private int enter_id;
	private String service_time; // 时间
	private String user_level; //等级
	private int user_intergal; //  积分
	private int user_sum;//酒数量
	private String s1;//备用 string 
	private int i1;//备用 int
	
}

