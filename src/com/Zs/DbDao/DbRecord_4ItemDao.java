package com.Zs.DbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import com.Zs.DbUtil.DbUtil;

import ZS.Util.Time.TestDate;
import ZsUtil.ZsUtil;


public class DbRecord_4ItemDao {
	/**
	 * 得到记录表中所有数据
	 * 成功返回一个DefaultListModel型变量
	 * 
	 * @author AL
	 * @throws SQLException 
	 *
	 */
	public DefaultListModel getAll(Connection con) throws SQLException
	{
		DefaultListModel m = new DefaultListModel();
		String sql="select * from record_4item";
		PreparedStatement pstmt=con.prepareStatement(sql);//预编译
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			m.addElement(rs.getString("Sb") + 
						 rs.getString("UseSth")+
						 rs.getString("DoSth")+
						  rs.getString("InStime") );
		}
		return m;
	}
	/**
	 * 
	 * 得到记录表中做某事的计入 
	 * 成功返回一个DefaultListModel型变量
	 * 
	 * @author AL
	 * @throws SQLException 
	 *
	 */
	public DefaultListModel getDoSth(Connection con,String doSth) throws SQLException
	{
		DefaultListModel m = new DefaultListModel();
		String sql="select * from record_4item where DoSth=?";
		PreparedStatement pstmt=con.prepareStatement(sql);//预编译
		
		
		pstmt.setString(1, doSth);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			m.addElement(rs.getString("Sb") + 
						 rs.getString("UseSth")+
						 rs.getString("DoSth")+
						rs.getString("InStime")   );
			//rs.getDate("InStime");
		}
		return m;
		
	}
	
	public DefaultListModel getUseSth(Connection con,String UseSth) throws SQLException
	{
		DefaultListModel m = new DefaultListModel();
		String sql="select * from record_4item where UseSth=?";
		PreparedStatement pstmt=con.prepareStatement(sql);//预编译
		
		
		pstmt.setString(1, UseSth);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			m.addElement(rs.getString("Sb") + 
						 rs.getString("UseSth")+
						 rs.getString("DoSth")+
						 rs.getString("InStime") );
		}
		return m;
		
	}
	/**
	 * 解析sql中的时间
	 * @param str
	 * @return
	 */
	public static String getStringFromSqlDate(String str)
	{
		if(str.length()!=14)
		{
			return str="   时间解析错误";
		}
		else 
		{
			str = str.substring(0, 4)+"年"+str.substring(4, 6)+"月"
					+str.substring(6, 8)+"日"+str.substring(8, 10)+"时"
					+str.substring(10, 12)+"分"+str.substring(12)+"秒";
		}
		return str;
	}
	
	/**
	 * 得到指定内容
	 * @param con 数据库连接
	 * @param item 表格中的那一列的列明
	 * @param content 那一列的内容
	 * @throws Exception
	 */

	
	public DefaultListModel getSearchingDb(Connection con,String item,String content) throws SQLException
	{
		DefaultListModel m = new DefaultListModel();
		String sql="select * from record_4item where "+item+"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);//预编译
		
		pstmt.setString(1, content);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			m.addElement(rs.getString("Sb") + 
						 rs.getString("UseSth")+
						 rs.getString("DoSth")+
						  rs.getString("InStime") );
		}
		return m;
	}
	
	/**
	 * 添加操作记录
	 * @param con
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public static  int dbRecord_4ItemAdd(Connection con,DbRecord_4ItemMemb record) throws Exception{
		String sql="insert into record_4item values(?,?,?,?,null)";//操作的ID也是自增的
		//括号里表示用户表从0~n里的属性。
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,record.getSb());
		pstmt.setString(2, record.getUseSth());
		pstmt.setString(3, record.getDoSth());
		pstmt.setString(4, ZsUtil.DateToSqlDate_String(TestDate.getDate()));//getInStime().toString()将日期转化成字符串
		return pstmt.executeUpdate();
	}
	
	/**
	 * 直接将得到的str[](sb usesth dosth)存入数据库
	 * @throws Exception 
	 */
	public static void saveFromNet(String str[]) throws Exception
	{
		DbUtil dUtil = new DbUtil();
		DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
		dbRecord_4ItemMemb = DbUtil.changeBuffer2DbRecord_4ItemMemb(str);
		DbRecord_4ItemDao
				.dbRecord_4ItemAdd(dUtil.getCon(), dbRecord_4ItemMemb);
	}
	
}
