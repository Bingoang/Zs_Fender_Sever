/**
 * 一些通用的方法
 * 
 */
package ZsUtil;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ZsUtil {
	public static void distroyFrm(JFrame me)
	{
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
		if(result == 0)
		{
			me.dispose();
		}
	}
	public static boolean stringIsEmpty(String str)
	{
		if("".equals(str)||str==null)
		{
			return true;
		}
		return false;
		
	}
	public static DefaultListModel DftMd_Add(DefaultListModel a ,DefaultListModel b)
	{
		for (int i = 0; i < b.getSize(); i++) {
			a.addElement(b.get(i));
		}
		return a;
	}
	public static String getNowTime_String()
	{
		Date now = new Date();
		DateFormat d = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
	    String str = d.format(now);
		return str;
	}
	public static Date getNowTime_Int()
	{
		Date now = new Date();
		DateFormat d = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
		return now;
	}
	/**
	 * 从date中得到格式为 20150311131153
	 * 2015年3月11日11段13分53秒
	 * @param date
	 * @return
	 */
	public static String DateToSqlDate_String(Date date)
	{
		String str,year,mouth,day,hour,min,second;
		year= "20"+(date.getYear()-100);
		
		if(date.getMonth()<9)
		{
			mouth = "0"+(date.getMonth()+1);
		}
		else
		{
			mouth = (date.getMonth()+1)+"";
		}
		day = DateToSqlDate_Sub( date.getDate() );
		hour = DateToSqlDate_Sub( date.getHours() );
		min = DateToSqlDate_Sub( date.getMinutes());
		second = DateToSqlDate_Sub( date.getSeconds() );
		str = year + mouth +day + hour + min +second;
		return str;
	}
	public static String DateToSqlDate_Sub(int i)
	{
		String str;
		if(i<10)
		{
			str = "0"+i;
		}
		else
		{
			str = i+"";
		}
		return str;
	}
	/**
	 * 比较从sql中得到日期的大小 可直接传入得到的内容
	 * date1>date2 返回1 相等 0 小于 返回-1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareSqlDateString(String date1,String date2)
	{
		if((date1.length()<13)||(date2.length()<13))
		{
			return 0;
		}
		int date1_year,date1_time,date2_year,date2_time;
		date1_year = Integer.parseInt( 
					(date1.substring(date1.length()-14, date1.length()-6) )
					 );
		
		date1_time = Integer.parseInt( 
				(date1.substring(date1.length()-6))
				 );
		
		date2_year = Integer.parseInt( 
				(date2.substring(0, date2.length()-6) )
				 );
	
		date2_time = Integer.parseInt( 
			(date2.substring(date2.length()-6))
			 );
		switch (compareInt(date1_year, date2_year)) {
		case 1:
		case -1:
			int a =compareInt(date1_year, date2_year);
			int b =compareInt(date1_time, date2_time);
			return compareInt(date1_year, date2_year);
		case 0:
			return compareInt(date1_time, date2_time);
		default:
			break;
		}
		return 0;
	}
	public static int compareInt(int a,int b)
	{
		if(a>b)
		{
			return 1;
		}else
		{
			if(a==b)
			{
				return 0;
			}else{return -1;}
		}
	}
	
}
