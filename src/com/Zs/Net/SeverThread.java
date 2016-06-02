package com.Zs.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.Zs.View.MainFrm;
import com.Zs.View.SearchingSimplePanel;

public class SeverThread extends Thread{
	private MainFrm mainFrm;
	private Socket socket;
	private SearchingSimplePanel searchingSimplePanel;
	private int index;
	public SeverThread(MainFrm mainFrm , SearchingSimplePanel searchingSimplePanel) {
		
		this.mainFrm = mainFrm;
		index = mainFrm.NetIndex;
		this.searchingSimplePanel = searchingSimplePanel;
	}
	@Override
	public void run() {
		try {
			mainFrm.setMainNetTextAreaText("Sever Thread  <"+index+">  is Opened and i am lisinering...");
			ServerSocket serverSocket = new ServerSocket(8089);
			System.out.println("i am in the waiting for info");
			while(true)
			{
			socket = serverSocket.accept();//阻塞函数	
			System.out.println("info comed");
			//********客户进程*********//
			new ClientThread(socket, mainFrm,searchingSimplePanel).start();
			//***********************//
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
