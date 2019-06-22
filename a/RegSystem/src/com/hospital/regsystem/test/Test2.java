/**
 * @author         zchangyu
 * @Date           2018年3月23日 下午9:21:46
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test2 {
	public static void main(String[] args) {
		/*Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(date);
		int hour=calendar.get(Calendar.DAY_OF_WEEK);
		
		if(hour==1){
			System.err.println("周日");
		}
		System.out.println("日期："+dateString+"---星期："+(hour-1));*/
		
		/*for(int i=1;i<8;i++){
			System.out.println(i);
		}*/
		String s1="2018年03月22";
		try {
			Date date1 = new SimpleDateFormat("yyyy年MM月dd").parse(s1);
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String s2=simpleDateFormat.format(date1);
			System.out.println(s2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
