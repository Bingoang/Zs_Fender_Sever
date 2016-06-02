package com.Zs.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import javax.xml.crypto.Data;

import ZS.Util.Time.TestDate;

import com.Zs.DbDao.DbRecord_4ItemMemb;

/**
 * 获取数据库连接
 * @author AL
 *
 */

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/ZsFender";
	private String dbUserName="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public  Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
	/**
	 * 函数方法：转换下位机传过来的字符串，翻译成中文存到SQL中。格式：包头+谁+用什么+做了什么+时间
	 * @param str[](3位)
	 * @return
	 */
	@SuppressWarnings("null")
	public static DbRecord_4ItemMemb changeBuffer2DbRecord_4ItemMemb(String[] str)
	{
		DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
		String sb = null;
		String useSth = null;
		String doSth = null;
		Date inStime;
		/*下位机传来的是byte型，我们将其视为string型，因为要将其一位位取出来，所以是要转为char型，
		 因为switch必须识别int型
		 */
		if(str.length<3)
		{
			return null;
		}

		switch ( Integer.valueOf(   str[0]  ) ){
		case 1:
			sb = "叶健";
			break;
			
		case 2:
			sb="赵思晨";
			break;
			
			case 3:
			sb="马敬川";
			break;
			
			case 4:
			sb="郭新兴";
			break;
			
			case 5:
			sb="李轩昂";
			
		default:
			break;
		}
		
		switch ( Integer.valueOf(  str[1]   )  ){
		case 1:
			useSth = "用指纹";
			
		case 2:
			useSth="用钥匙";
			break;
			
			case 3:
			useSth="用短信授权";
			break;
			
			case 4:
			useSth="用手机授权";
			break;
			
			case 5:
			useSth="用电脑授权";
			break;
			
		default:
			break;
		}
		
		switch ( Integer.valueOf( str[2])   ){
		case 1:
			doSth = "开门在";
			break;
			
		case 2:
		doSth = "按门铃在";
		break;
		
		case 3:
		doSth = "发短信在";
		break;
		
		case 4:
		doSth ="非法侵入";
		break;
		
		default:
		break;
		}
        inStime = TestDate.getDate();
		dbRecord_4ItemMemb.setSb(sb);
		dbRecord_4ItemMemb.setUseSth(useSth);
		dbRecord_4ItemMemb.setDoSth(doSth);
		dbRecord_4ItemMemb.setInStime(inStime);
		return dbRecord_4ItemMemb;
	}
	

}
