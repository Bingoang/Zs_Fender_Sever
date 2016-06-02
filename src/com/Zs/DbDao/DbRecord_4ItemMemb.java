package com.Zs.DbDao;

import java.util.Date;


public class DbRecord_4ItemMemb {
	private String sb;
	private String useSth;
	private String doSth;
	private Date inStime;
	private int id;
	
			
	public DbRecord_4ItemMemb() {
		super();
	}
	
	public DbRecord_4ItemMemb(String sb, String useSth, String doSth,
			Date inStime) {
		super();
		this.sb = sb;
		this.useSth = useSth;
		this.doSth = doSth;
		this.inStime = inStime;
	}
	public DbRecord_4ItemMemb(String sb, String useSth, String doSth) {
		super();
		this.sb = sb;
		this.useSth = useSth;
		this.doSth = doSth;
	}

	public DbRecord_4ItemMemb(String sb) {
		super();
		this.sb = sb;
	}

	public String getSb() {
		return sb;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public String getUseSth() {
		return useSth;
	}
	public void setUseSth(String useSth) {
		this.useSth = useSth;
	}
	public String getDoSth() {
		return doSth;
	}
	public void setDoSth(String doSth) {
		this.doSth = doSth;
	}
	public Date getInStime() {
		return inStime;
	}
	public void setInStime(Date inStime) {
		this.inStime = inStime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
