package com.Zs.Net;

import java.net.Socket;

public class Client extends Thread{
	protected Socket socket;
	protected String getIP() {
		String IP = null;
		if(socket != null)
		{
			IP=socket.getInetAddress().getHostAddress();
		}
		return IP;
		
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public Client(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
}

