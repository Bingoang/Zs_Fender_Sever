package com.Zs.Net;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultListModel;

import com.Zs.DbDao.DbRecord_4ItemDao;
import com.Zs.DbUtil.DbUtil;
import com.Zs.View.MainFrm;
import com.Zs.View.SearchingSimplePanel;
/**
 * 做一些简单的判断 执行任务
 * 并且判断新连接的这个sock应该属于哪一类 然后 然后进行分类
 * @author AL
 *
 */
	public class ClientThread extends Thread{
	public static final String RAMISCONNECTED = "1234";//RAM连接后发来的标示符
	private Client_Computer computerClient;
	private Client_Phone phoneClient;
	private Client_RAM ramClient;
	private Socket socket;
	private MainFrm mainFrm;
	private PrintWriter printWriter;
	private SearchingSimplePanel searchingSimplePanel;
	private int index;
	public ClientThread(Socket socket,MainFrm mainFrm,  SearchingSimplePanel searchingSimplePanel) {
		this.socket = socket;
		this.mainFrm = mainFrm;
		index = mainFrm.NetIndex;
		mainFrm.setNetIndex(index+1);
		this.searchingSimplePanel= searchingSimplePanel;
		this.setPriority(6);
	}
	@Override
	public void run() {
		mainFrm.setMainNetTextAreaText("新的socket连接!");
//		mainFrm.getmainNetTextArea().setText(mainFrm.getmainNetTextArea().getText()  +"新的socket连接!"+ "\n" );
		//get mes
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(
						socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(
				inputStreamReader);
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			boolean flag =true;
			while (flag) 
			{
				String strs = null;
				String str,str1 = null;
				strs = bufferedReader.readLine();
				if(strs == null)
				{
					flag=false;
					if(socket.isConnected())
					{
						try {
							socket.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
					str ="连接 <"+index+"> 已断开";
				}else
				{
					str = strs.split("&")[0];
//					str2 = strs.split("@")[0];
					System.out.println("str = "+str);
					if(strs.split("&").length>=2)
					{
						str1= strs.split("&")[1];
//						str3 = strs.split("@")[1];
						System.out.println("str1 = "+str1);
					}
					//手机得到所有的记录（sb usesth dosth intime）(电脑从服务器调数据还没做，参考这里)
					if(str.equals("Phone get all records"))
					{
						DefaultListModel defaultListModel = searchingSimplePanel.getAllList();
						String strForRecord = "";
						for(int i = 0; i<defaultListModel.size();i++)
						{
							strForRecord = strForRecord + "Records&"+defaultListModel.get(i).toString()+"@";//将所有的记录组合成一个STRING
							System.out.println("Records&"+strForRecord);
						}
						printWriter.println(strForRecord);
						mainFrm.setMainNetTextAreaText("i send to Thread <"+index+"> ----> " + "已发送所有记录 ");
					}
					//手机用户以连接
					if(str.equals("phone is connected"))
					{
//						printWriter.println("station&虚掩&17.5°&危险&危险的很&天气干燥&恶劣");
//						mainFrm.setMainNetTextAreaText("i send to Thread <"+index+"> ----> " + "已发送测试状态信息");
						phoneClient = new Client_Phone(socket);
						if(mainFrm.ClientGroups.isEmpty())
						{
							mainFrm.ClientGroups.add(new ClientGroup());
						}
						mainFrm.ClientGroups.get(0).setPhoneClient(phoneClient);
						System.out.println("手机用户已经连接");
						
					}
					if(str.equals("computer client is connected"))
					{
						printWriter.println("sever is connected");
						computerClient = new Client_Computer(socket);
						if(mainFrm.ClientGroups.isEmpty())
						{
							mainFrm.ClientGroups.add(new ClientGroup());
						}
						mainFrm.ClientGroups.get(0).setComputerClient(computerClient);
						System.out.println("电脑用户已经连接！");
					}
					//发给手机的 轩昂看这里
					if(str.equals("to phone"))//str2.equals("to phone")
					{						
						//如果已经有默认用户登录且手机已经登录并且已经连接
						if(!mainFrm.ClientGroups.isEmpty()&&
								mainFrm.ClientGroups.get(0).isHavePhoneClient()&&
								mainFrm.ClientGroups.get(0).getPhoneClient().socket.isConnected())
						{
							PrintWriter printWriter1 = new PrintWriter(mainFrm.ClientGroups.get(0).getPhoneClient().socket.getOutputStream(), true);
							printWriter1.println(strs.substring(str.length()+1));//发送内容给指定的手机设备
						}
						else
						{
							System.out.println("手机未连接");
							mainFrm.setMainNetTextAreaText("exception <"+index+"> ----> " + "手机未连接 ");
						}
					}
					//发给电脑
					if(str.equals("to computer"))
					{
						toComputer(str1);
						
						//如果已经有默认用户登录且手机已经登录并且已经连接
		
					}
					//发送给RAM
					if(str.equals("to RAM"))
					{
						if(!mainFrm.ClientGroups.isEmpty()&&//ClientGroups不为空
								mainFrm.ClientGroups.get(0).isHaveRAMClient()&&//连接了RAM用户
								mainFrm.ClientGroups.get(0).getRamClient().getSocket().isConnected())//RAM用户在线
						{
							PrintWriter printWriter1 = new PrintWriter(mainFrm.ClientGroups.get(0).getRamClient().getSocket().getOutputStream(), true);
							printWriter1.println(str1);//发送内容给指定的ram用户 接收到的strs = to RAM&1 发送用的str1=1
						}
						else
						{
							System.out.println("RAM未连接");
							printWriter.println("您的RAM未在线耶T.T");
							mainFrm.setMainNetTextAreaText("exception <"+index+"> ----> " + "RAM未连接 ");
//							mainFrm.getmainNetTextArea().setText(mainFrm.getmainNetTextArea().getText()  
//									+ "exception <"+index+"> ----> " + "RAM未连接 "+ "\n" );
						}
					}
					mainFrm.setMainNetTextAreaText("i got from Thread <"+index+"> ----> " + strs);
//					mainFrm.getmainNetTextArea().setText(mainFrm.getmainNetTextArea().getText() 
//							+ "i got from Thread <"+index+"> ----> " + strs+ "\n" );
				}
			}
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	private void toComputer(String str1) throws IOException {
		if(!mainFrm.ClientGroups.isEmpty()&&
				mainFrm.ClientGroups.get(0).isHaveComputerClient()&&
				mainFrm.ClientGroups.get(0).getComputerClient().socket.isConnected())
		{
			PrintWriter printWriter1 = new PrintWriter(mainFrm.ClientGroups.get(0).getComputerClient().socket.getOutputStream(), true);
			printWriter1.println(str1);//发送内容给指定的电脑设备
		}
		else
		{
			System.out.println("电脑未连接");
			printWriter.println("您的电脑未在线耶T.T");
			mainFrm.setMainNetTextAreaText("exception <"+index+"> ----> " + "电脑未连接 ");
		}
	}

	/**
	 * 用于将来自于RAM的记录存入数据库 并如果有报警信息提示电脑报警
	 * 数据格式 : to phone&station&门状态(1 2 3)&是否有记录（有记录为1）&室内温度&CPU温度&sb&useSth&doSth&isAlarm(0/1)
	 * @param strs
	 * @throws Exception 
	 */
}
