/**
 * @author         zchangyu
 * @Date           2018年4月30日 下午1:10:13
 * @Description    TODO（一句话描述）
 */
package com.sxlvyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
	@RequestMapping("introduce")
	public String introducesx(){
		return "introduce";
		
	}
	@RequestMapping("Culture")
	public String Culture(){
		return "Culture";
	}
	@RequestMapping("historic")
	public String historic(){
		return "historic";
	}
}
