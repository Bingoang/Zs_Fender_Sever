//��ʾ��ǰϵͳʱ��
package ZS.Util.Time;
import java.util.*; 
import java.text.*;

public class TestDate { 
   public static void main(String[] args) { 
      Date now = new Date(); 
      Calendar cal = Calendar.getInstance(); 
      DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //��ʾ���ڣ�ʱ�䣨��ȷ���֣�
     String str8 = d8.format(now);//��SHORT�����ȣ����ַ�ʽ�����
   //   System.out.println(str8);
      System.out.println((now.getYear()-100+2000)+"-"+(now.getMonth()+1)+"-"+now.getDate()+"-"+
    		  			 now.getHours()+"-"+now.getMinutes()+"-"+now.getSeconds());
   }
   public static String getTime()
   {
	   	 Date now = new Date(); 
	     Calendar cal = Calendar.getInstance(); 
	     DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //��ʾ���ڣ�ʱ�䣨��ȷ���֣�
	     String str8 = d8.format(now);//��SHORT�����ȣ����ַ�ʽ�����
	     str8=(now.getYear()-100+2000)+"-"+(now.getMonth()+1)+"-"+now.getDate()+"-"+
	  			 now.getHours()+"-"+now.getMinutes()+"-"+now.getSeconds();
	     return str8;
   }

   public static Date getDate()
   {
	   Date now = new Date(); 
	     Calendar cal = Calendar.getInstance(); 
	     DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //��ʾ���ڣ�ʱ�䣨��ȷ���֣�
	     return now;
   }
}


