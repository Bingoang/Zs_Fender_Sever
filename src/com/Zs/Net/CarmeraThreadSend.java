package com.Zs.Net;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.naming.Context;

import com.Zs.View.MainFrm;
/**
 * 用于发送图像的线程
 * @author AL
 *
 */
public class CarmeraThreadSend extends Thread{
	private MainFrm mainFrm;
	private Socket socket;
	public CarmeraThreadSend(MainFrm mainFrm, Socket socket) {
		this.mainFrm = mainFrm;
		this.socket = socket;
	}
	public Socket getSocket()
	{
		return socket;
	}
	@Override
	public void run() {
		System.out.println("正在发送给手机——截图");
		String filePath = "D:\\carmera.jpg";  
	    DataInputStream dis ;
	    try {
	    		boolean flag = true;
		    	//mainFrm.catchViedo();
	    		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());    
	            FileInputStream fis = new FileInputStream(filePath);    
	            int size = fis.available();  
	            System.out.println("size = "+size);  
	            byte[] data = new byte[size];    
	            fis.read(data);    
	            dos.writeInt(size);    
	            dos.write(data);    
	            dos.flush();   
	            dos.close();    
	            fis.close();   
	            socket.close();     
	            this.interrupt(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    
	   
	} 


}
