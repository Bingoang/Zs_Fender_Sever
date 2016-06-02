package com.Zs.Net;

public class ClientGroup {

	private Client_Computer computerClient;
	private Client_Phone phoneClient;
	private Client_RAM ramClient;
	private CarmeraThreadGet carmeraThreadGet;
	private CarmeraThreadSend carmeraThreadSend;
	private boolean haveComputerClient = false;
	private boolean havePhoneClient = false;
	private boolean haveRAMClient = false;
	private boolean havecarmeraThreadGet = false;
	private boolean havecarmeraThreadSend= false;
	
	
	public CarmeraThreadSend getCarmeraThreadSend() {
		return carmeraThreadSend;
	}
	public void setCarmeraThreadSend(CarmeraThreadSend carmeraThreadSend) {
		havecarmeraThreadSend = true;
		this.carmeraThreadSend = carmeraThreadSend;
	}
	public boolean isHavecarmeraThreadSend() {
		return havecarmeraThreadSend;
	}
	public void setHavecarmeraThreadSend(boolean havecarmeraThreadSend) {
		this.havecarmeraThreadSend = havecarmeraThreadSend;
	}
	public CarmeraThreadGet getCarmeraThreadGet() {
		return carmeraThreadGet;
	}
	public void setCarmeraThreadGet(CarmeraThreadGet carmeraThreadGet) {
		this.carmeraThreadGet = carmeraThreadGet;
	}
	public boolean isHavecarmeraThreadGet() {
		
		return havecarmeraThreadGet;
	}
	public void setHavecarmeraThreadGet(boolean havecarmeraThreadGet) {
		havecarmeraThreadGet = true;
		this.havecarmeraThreadGet = havecarmeraThreadGet;
	}
	//是否已经全部连接
	public boolean haveAllClient()
	{
		return haveComputerClient&havePhoneClient&haveRAMClient;
	}
	//电脑是否连接
	public boolean isHaveComputerClient() {
		return haveComputerClient;
	}

	//手机是否连接
	public boolean isHavePhoneClient() {
		return havePhoneClient;
	}

	//RAM是否连接
	public boolean isHaveRAMClient() {
		return haveRAMClient;
	}

	
	
	
	
	public void setComputerClient(Client_Computer computerClient)
	{
		if(computerClient != null)
		{
			this.computerClient = computerClient;
			haveComputerClient=true;
		}
	}
	
	public Client_Phone getPhoneClient() {
		return phoneClient;
	}

	public void setPhoneClient(Client_Phone phoneClient) {
		if(phoneClient != null)
		{
			this.phoneClient = phoneClient;
			havePhoneClient =true;
		}
	}

	public Client_RAM getRamClient() {
		return ramClient;
	}

	public void setRamClient(Client_RAM ramClient) {
		if(ramClient != null)
		{
			this.ramClient = ramClient;
			haveRAMClient = true;
		}
	}

	public Client_Computer getComputerClient() {
		return computerClient;
	}
	
	
}
