/**
 * @author         zchangyu
 * @Date           2019年3月7日 下午6:19:42
 * @Description    TODO（一句话描述）
 */
package com.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getDate(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
		
	}
	
	
	public static String getTimes(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMddHHmmss");
		return simpleDateFormat.format(date);
		
	}
}
