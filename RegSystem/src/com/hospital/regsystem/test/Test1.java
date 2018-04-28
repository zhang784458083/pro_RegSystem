/**
 * @author         zchangyu
 * @Date           2017年11月19日 下午12:19:34
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		String a="4YM6";
		System.out.println(a.toLowerCase());
		List<String> list=new ArrayList<String>();
		for(int i=0;i<a.length();i++){
			char s=a.charAt(i);
			if((s>='A')&&(s<='Z')){
				s+=32;
				System.out.println(s);
			}
			list.add("");
		}
	}
}
