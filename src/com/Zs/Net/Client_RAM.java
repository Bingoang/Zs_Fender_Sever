package com.Zs.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import com.Zs.DbDao.DbRecord_4ItemDao;
import com.Zs.DbDao.DbRecord_4ItemMemb;
import com.Zs.DbUtil.DbUtil;
import com.Zs.View.MainFrm;
/**
 * 连接ram的服务器
 * 当调用这个类时 应当start（），这样就可以监听
 * 来自于ram的信息了
 * @author AL
 *
 */
public class Client_RAM extends Client{
	public Client_RAM(MainFrm mainFrm) throws SocketException {
		super(null);
		this.mainFrm = mainFrm;
		
	}
	private DbUtil dbUtil = new DbUtil();
	private Connection con;
	public static final  String IP = "192.168.8.1";
	private String str;
	private MainFrm mainFrm;
	private PrintWriter printWriter;
	@Override
	public void run() {
		try {
		    socket = new Socket(IP,2001);
			mainFrm.setLinkRAMbuttonText("断开RAM");
			mainFrm.setMainNetTextAreaText("RAM已经连接！");
			mainFrm.setRamIsConnectedFlag(true);
			printWriter = new PrintWriter(socket.getOutputStream(),true);
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while(true)
			{
				str="";
				System.out.println("监听RAM信息...");
				str = bufferedReader.readLine();
				send2ComputerClient(str);//转发给电脑 
				send2Phone(str);//转发给手机
				System.out.println(str);
				if(str!=null)
				{
					char mesg[] =str.toCharArray();
					String mesgStr = null;
					for(int i=0;i<mesg.length;i++)
					{
						switch (mesg[i]) {
						case 's'://门状态
							if((i+1)<=mesg.length)//判断是否会越界
							{
								mesgStr  = mesg[i+1]+"";
								System.out.println("门状态:"+mesgStr);
							}
							break;
						case 'T'://CPU温度
							if(i+2<=mesg.length)
							{
								mesgStr = mesg[i+1]+""+mesg[i+2]+"";
								System.out.println("CPU温度："+mesgStr);
							}
							break;
						case 't'://室温
							if(i+4<=mesg.length)
							{
								mesgStr = mesg[i+1]+""+mesg[i+2]+""+mesg[i+3]+""+mesg[i+4]+"";
								System.out.println("室温："+mesgStr);
							}
							break;
						case 'o'://操作
							if((i+2)<=mesg.length)//判断是否会越界
							{
								mesgStr = mesg[i+1]+ (mesg[i+2]+"");
								System.out.println("操作编号:"+mesgStr);
								
								saveRecord(Integer.valueOf(mesgStr));//把相应的数据存入数据库
							}
							break;
						case 'h'://人体感应触发状态
							if(i+1<=mesg.length)
							{
								mesgStr = mesg[i+1]+"";
								System.out.println("门外状态:"+mesgStr);
//								System.out.println("室温："+mesgStr);
							}
							break;
						default:
							break;
						}
					}
				}else
				{
					
				}
			}
		} catch (UnknownHostException e) {
//			mainFrm.setLinkRAMbuttonText("连接");
//			mainFrm.setMainNetTextAreaText("网络错误，已经和RAM断开连接！！！");
//			mainFrm.setRamIsConnectedFlag(false);
			socket = null;
			this.suspend();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally
	{
		
	}
	}
	
	private void send2Phone(String str) throws IOException
	{
		if(!mainFrm.ClientGroups.isEmpty()&&
				mainFrm.ClientGroups.get(0).isHavePhoneClient()&&
				mainFrm.ClientGroups.get(0).getPhoneClient().socket.isConnected())
		{
			PrintWriter printWriter1 = new PrintWriter(mainFrm.ClientGroups.get(0).getPhoneClient().socket.getOutputStream(), true);
			printWriter1.println(str);//发送内容给指定的手机设备
			System.out.println("已经发送 "+str+" 给手机");
		}
		else
		{
			System.out.println("手机未连接");
//			mainFrm.setMainNetTextAreaText("exception <RAM> ----> " + "手机未连接 ");
		}
	}
	private void send2ComputerClient(String str) throws IOException
	{
		if(!mainFrm.ClientGroups.isEmpty()&&
				mainFrm.ClientGroups.get(0).isHaveComputerClient()&&
				mainFrm.ClientGroups.get(0).getComputerClient().socket.isConnected())
		{
			PrintWriter printWriter1 = new PrintWriter(mainFrm.ClientGroups.get(0).getComputerClient().socket.getOutputStream(), true);
			printWriter1.println(str);//发送内容给指定的电脑设备 
		}
		{
//			mainFrm.setMainNetTextAreaText("exception <RAM> ----> " + "电脑未连接 ");
			System.out.println("电脑未连接哦！无法发送RAM数据给电脑。");
		}	
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void send(String str) {
		printWriter.println(str);
	}
	
	private void saveRecord(Integer operate) throws Exception {
		// TODO Auto-generated method stub
		con = dbUtil.getCon();//获取数据库连接
		switch (operate) {
		case 22://有人按门铃
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("有人", "", "按门铃在"));
			break;
		case 20://陌生人按指纹
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("陌生人", "", "按指纹在"));
			break;
		case 21://亲戚按指纹
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("亲戚马敬川", "用指纹", "开门在"));
			break;	
		case 81://赵老板用指纹开门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("赵老板", "用指纹", "开门在"));
			break;	
		case 82://叶健用指纹开门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("叶老板", "用指纹", "开门在"));
			break;	
		case 80://钥匙开门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "用钥匙", "开门在"));
			break;	
		case 41://蓝牙开门	
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "用蓝牙", "开门在"));
			break;
		case 40://蓝牙关门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "用蓝牙", "关门在"));
			break;
		case 43://蓝牙手动打开报警
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "用蓝牙", "手动开启报警在"));
			break;
		case 44://蓝牙手动关闭报警
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "用蓝牙", "手动关闭报警在"));
			break;
		case 31://WIFI开门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过网络", "开门在"));
			break;
		case 30://WIFI关门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过网络", "关门在"));
			break;
		case 33://WIFi 报警
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过网络", "手动开启报警在"));
			break;
		case 34://WIFI关闭报警
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过网络", "手动关闭报警在"));
			break;
		case 51://短信开门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过短信", "开门在"));
			break;
		case 50://短信关门
			DbRecord_4ItemDao.dbRecord_4ItemAdd(con, new DbRecord_4ItemMemb("主人", "通过短信", "关门在"));
			break;
		default:
			break;
			
		}
		con.close();//关闭数据库
	}
	}
	
	
	


