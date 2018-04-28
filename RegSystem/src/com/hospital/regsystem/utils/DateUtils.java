/**
 * @author         zchangyu
 * @Date           2018年3月23日 下午9:37:26
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.support.StaticApplicationContext;

public class DateUtils {
	public static void main(String[] args) {
		date(1);
	}
	public static String date(int num){
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,num);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(date);
		return dateString;
	}
	public static String week(int num){
		String week = null;
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,num);//把日期往后增加一天.整数往后推,负数往前移动
		int hour=calendar.get(Calendar.DAY_OF_WEEK);
		if(hour==7){
			week= "星期六";
		}
		if(hour==6){
			week= "星期五";
		}
		if(hour==5){
			week=  "星期四";
		}
		if(hour==4){
			week= "星期三";
		}
		if(hour==3){
			week= "星期二";
		}
		if(hour==2){
			week= "星期一";
		}
		if(hour==1){
			week= "星期日";
		}
		
		return week;
		
	}
	
	public static String toDate(String date){
		try {
			Date date1 = new SimpleDateFormat("yyyy年MM月dd").parse(date);
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String s2=simpleDateFormat.format(date1);
			
			return s2;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
