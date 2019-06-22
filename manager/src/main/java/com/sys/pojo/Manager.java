/**
 * @author         zchangyu
 * @Date           2018年12月5日 上午11:44:51
 * @Description    TODO（一句话描述）
 */
package com.sys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
	private int id;
	private int enter_id;//企业ID
	private String username;
	private String password;
	private String name;//真实姓名
	private String tele;
	private int type;//类型    普通管理是1  高级管理是2
	private String s1;//备用字段
	private String s2;//备用字段

	
}
