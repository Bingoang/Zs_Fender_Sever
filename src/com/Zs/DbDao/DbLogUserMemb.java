package com.Zs.DbDao;

public class DbLogUserMemb {
	private int ID;
	private String User;
	private String Password;
	private String TelNum;
	private String Q1;
	private String Q2;
	private String Q3;
	private String A1;
	private String A2;
	private String A3;
	
	public DbLogUserMemb( String user, String password, String telNum,
			String q1, String q2, String q3, String a1, String a2, String a3) {
		super();
		
		User = user;
		Password = password;
		TelNum = telNum;
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		A1 = a1;
		A2 = a2;
		A3 = a3;
	}

	public DbLogUserMemb(String User,String PassWord) {
		// TODO Auto-generated constructor stub
		this.User = User;
		this.Password = PassWord;
	}
	
	public DbLogUserMemb() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTelNum() {
		return TelNum;
	}
	public void setTelNum(String telNum) {
		TelNum = telNum;
	}
	public String getQ1() {
		return Q1;
	}
	public void setQ1(String q1) {
		Q1 = q1;
	}
	public String getQ2() {
		return Q2;
	}
	public void setQ2(String q2) {
		Q2 = q2;
	}
	public String getQ3() {
		return Q3;
	}
	public void setQ3(String q3) {
		Q3 = q3;
	}
	public String getA1() {
		return A1;
	}
	public void setA1(String a1) {
		A1 = a1;
	}
	public String getA2() {
		return A2;
	}
	public void setA2(String a2) {
		A2 = a2;
	}
	public String getA3() {
		return A3;
	}
	public void setA3(String a3) {
		A3 = a3;
	}
	
}
