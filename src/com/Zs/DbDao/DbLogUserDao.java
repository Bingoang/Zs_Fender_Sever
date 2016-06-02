package com.Zs.DbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;


public class DbLogUserDao {

	/**
	 * 登录验证
	 */
	public DbLogUserMemb login(Connection con,DbLogUserMemb user) throws Exception{
		DbLogUserMemb resultUser=null;
		String sql="select * from LogUser where User=? and Password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUser());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new DbLogUserMemb();
			resultUser.setUser(rs.getString("User"));
			resultUser.setPassword(rs.getString("Password"));
		}
		return resultUser;
	}
	public boolean setPassword (Connection con,String ID,String Password) 
	{
		String sql="update loguser "+
					"set Password = ? where ID = ?";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Password);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 添加新用户
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int logUserAdd(Connection con,DbLogUserMemb user) throws Exception{
		String sql="insert into loguser values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUser());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getTelNum());
		pstmt.setString(4, user.getQ1());
		pstmt.setString(5, user.getA1());
		pstmt.setString(6, user.getQ2());
		pstmt.setString(7, user.getA2());
		pstmt.setString(8, user.getQ3());
		pstmt.setString(9, user.getA3());
		return pstmt.executeUpdate();
	}
	public String getSearchingDb(Connection con,String item,String content) throws SQLException
	{
		String str = null;
		String sql="select * from LogUser where "+item+"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, content);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()){
			str = rs.getString("Password");
		}
		return str;
	}
		
		public Vector<String> getSearchingDbQusetionPassword(Connection con,String item,String content) throws SQLException
		{
			Vector<String> v = new Vector<String>();
			String sql="select * from LogUser where "+item+"=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, content);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				v.add(rs.getString("Q1"));
				v.add(rs.getString("Q2"));
				v.add(rs.getString("Q3"));
				v.add(rs.getString("A1"));
				v.add(rs.getString("A2"));
				v.add(rs.getString("A3"));
				v.add(rs.getString("Password"));
				v.add(rs.getString("ID"));
			}else{
				return null;
			}
	
		return v;
	}
	
}

