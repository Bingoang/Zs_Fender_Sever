package com.Zs.Net;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.Zs.View.MainFrm;

/**
 * 用于接收图像的线程
 * @author AL
 *
 */
public class CarmeraThreadGet extends Thread{
	private Socket socket;
	private MainFrm mainFrm;
	private InputStream inputStream;
	private Socket phoneSocket;
	public CarmeraThreadGet(Socket socket,MainFrm mainFrm) {
		this.socket=socket;
		this.mainFrm = mainFrm;
	}
	@Override
	public void run() {
//		receiveFile(socket);
		InputStream in;
		try {
			in = socket.getInputStream();
			phoneSocket = mainFrm.ClientGroups.get(0).getCarmeraThreadSend().getSocket();
			OutputStream out = phoneSocket.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			//2.往输出流里面投放数据
			while ((len = in.read(buf)) != -1)
			{
				out.write(buf,0,len);
			}
			phoneSocket.shutdownOutput();
			
			in.close();
			phoneSocket.close();
			socket.close();
			System.out.println("传输完成！");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			//创建图片字节流
//			FileOutputStream fos = new FileOutputStream("D:\\imageFromClient.jpg");
//			byte[] buf = new byte[1024];
//			int len = 0;
//			//往字节流里写图片数据
////			BufferedImage image = ImageIO.read(in);
//			
//			while ((len = in.read(buf)) != -1)
//			{
//				fos.write(buf,0,len);
//				System.out.println("收到： "+len);
//			}
//			
////			mainFrm.labelCarmera.setIcon(new ImageIcon(image));
//			//获取输出流，准备给客户端发送消息
//			OutputStream out = socket.getOutputStream();
//			out.write("上传成功".getBytes());
//			System.out.println("服务器已经接收到了图片.");
//			mainFrm.ClientGroups.get(0).getCarmeraThreadSend().start();
//			//关闭资源
//			fos.close();
//			in.close();
//			out.close();
//			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void receiveFile(Socket socket){
        byte[] inputByte = null;
        int length = 0;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        try {
            try {
                dis = new DataInputStream(socket.getInputStream());
                fos = new FileOutputStream(new File("D:\\imageFromClient.jpg"));
                inputByte = new byte[1024];
                System.out.println("开始接收数据...");
                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
                    System.out.println(length);
                    fos.write(inputByte, 0, length);
                    fos.flush();
                }
                System.out.println("完成接收");
                mainFrm.ClientGroups.get(0).getCarmeraThreadSend().start();
            } finally {
                if (fos != null)
                    fos.close();
                if (dis != null)
                    dis.close();
                if (socket != null)
                    socket.close();
            }
        } catch (Exception e) {
        }
    }
}
