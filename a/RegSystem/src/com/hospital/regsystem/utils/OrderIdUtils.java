/**
 * @author         zchangyu
 * @Date           2018年4月1日 上午9:55:26
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderIdUtils {
	public static String getOrderId(String type,int oid,int nowreg){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyMMddHHmm");
		String d=simpleDateFormat.format(date);
		String orderID="";
		if(nowreg<10){
			orderID=type+d+"0"+oid+"00"+nowreg;
		}
		if(nowreg<100 &&nowreg>9){
			orderID=type+d+"0"+oid+"0"+nowreg;
		}
		
		return orderID;
		
	}
	public static void main(String[] args) {
		/*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date = simpleDateFormat.parse("2018-04-30 08:20:20");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		getOrderId("A",1,1);
		
	}
}
