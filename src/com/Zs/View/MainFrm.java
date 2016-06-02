/*
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.Vector;
import javax.imageio.ImageIO;
import com.Zs.Net.ClientGroup;
import com.Zs.Net.Client_RAM;
import com.Zs.Net.SeverThread;
import ZS.Util.Time.TestDate;

/**
 *
 * @author  __USER__
 */
public class MainFrm extends javax.swing.JFrame {

	//***************carmera********************/
	private BufferedImage imgForSave = null;
	private int cameraFlag = 0;
	//**************************************//
	SearchingSimplePanel searchingSimplePanel = new SearchingSimplePanel();
	//***********NET****************//
	private boolean ramIsConnectedFlag = false;
	private boolean falg_RAMisConnected = false;
	public Vector<ClientGroup> ClientGroups = new Vector<ClientGroup>();
	public SeverThread severThread = new SeverThread(this, searchingSimplePanel);
	public int NetIndex = 0;//用于标识现在有多少个连接
	private int startSeverFlag = 0;//0 初始状态 1 中断 2重新打开
	//	private SeverThread severThread;
	//***************************//
	private String Port;
	private Integer ComNumber = 1;

	//	private static byte[] byt = { 0x10, 0x00, 0x11 };//用来发送命令！

	/** Creates new form MainFrm */
	public MainFrm() {
		initComponents();
		this.SearchingTabbedPane.addTab("简单检索", searchingSimplePanel);
		this.SearchingTabbedPane.addTab("专家检索", new SearchingExpertPanel());
		ClientGroups.add(new ClientGroup());
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		SearchingTabbedPane = new javax.swing.JTabbedPane();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		mainNetTextArea = new javax.swing.JTextArea();
		severNetButton = new javax.swing.JButton();
		clearNetButton = new javax.swing.JButton();
		linkRAMbutton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setForeground(new java.awt.Color(0, 0, 255));
		jLabel1.setText("\u6ce8\u518c");
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});

		mainNetTextArea.setColumns(20);
		mainNetTextArea.setRows(5);
		jScrollPane1.setViewportView(mainNetTextArea);

		severNetButton.setText("\u5f00\u59cb\u670d\u52a1");
		severNetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				severNetButtonActionPerformed(evt);
			}
		});

		clearNetButton.setText("\u6e05\u7a7a");
		clearNetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearNetButtonActionPerformed(evt);
			}
		});

		linkRAMbutton.setText("\u8fde\u63a5RAM");
		linkRAMbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					linkRAMbuttonActionPerformed(evt);
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(155,
																		155,
																		155)
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		severNetButton)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		clearNetButton)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		linkRAMbutton))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		714,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										53, Short.MAX_VALUE)
								.addComponent(SearchingTabbedPane,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										529,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(SearchingTabbedPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										673, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(36, Short.MAX_VALUE)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										503,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(severNetButton)
												.addComponent(clearNetButton)
												.addComponent(linkRAMbutton))
								.addGap(51, 51, 51).addComponent(jLabel1)
								.addGap(37, 37, 37)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void linkRAMbuttonActionPerformed(java.awt.event.ActionEvent evt)
			throws SocketException {
		if (!ramIsConnectedFlag) {
			Client_RAM client_RAM = new Client_RAM(this);
			client_RAM.start();
			ClientGroups.get(0).setRamClient(client_RAM);//将ram用户注册到列表里面
		} else {
			ClientGroups.get(0).getRamClient().stop();
			this.linkRAMbutton.setText("连接RAM");
			ramIsConnectedFlag = false;
		}

	}

	private void clearNetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		mainNetTextArea.setText("");
	}

	public void catchViedo() {
		try {
			ImageIO.write(imgForSave, "jpg", new File("d:\\" + "carmera"
					+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} //调用了TestDate类中的getTime()函数
		System.out.println("成功");
	}

	private void severNetButtonActionPerformed(java.awt.event.ActionEvent evt) {

		switch (startSeverFlag) {
		case 0:
			severThread.start();
			startSeverFlag = 1;
			severNetButton.setText("停止服务");
			break;
		case 1:
			severThread.stop();
			startSeverFlag = 2;
			severNetButton.setText("开始服务");
			break;

		case 2:
			severThread.resume();
			startSeverFlag = 1;
			severNetButton.setText("停止服务");
			break;

		default:
			break;
		}
		//		if (startSeverFlag) {
		//			
		//			severThread.start();
		//			startSeverFlag = true;
		//			severNetButton.setText("停止服务");
		//		} else {
		//			NetIndex = 0;
		//			severThread.suspend();
		//			severNetButton.setText("开始服务");
		//			startSeverFlag = false;
		//			
		//		}
		//severThread.start();
	}

	public int getNetIndex() {
		return NetIndex;
	}

	public void setNetIndex(int netIndex) {
		NetIndex = netIndex;
	}

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
		//this.dispose();
		SignFrm a = new SignFrm();
		a.setVisible(true);
		a.setMain(this);
		this.setEnabled(false);
		//a.setModalExclusionType(getModalExclusionType());
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTabbedPane SearchingTabbedPane;
	private javax.swing.JButton clearNetButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton linkRAMbutton;
	private javax.swing.JTextArea mainNetTextArea;
	private javax.swing.JButton severNetButton;

	// End of variables declaration//GEN-END:variables
	//*****************************************************8//
	public void setMainNetTextAreaText(String str) {
		mainNetTextArea.setText(mainNetTextArea.getText() + "-------->" + str
				+ "-------->" + TestDate.getTime() + "\n");
	}

	public void setLinkRAMbuttonText(String str) {
		this.linkRAMbutton.setText(str);
	}

	public void setRamIsConnectedFlag(boolean flag) {
		this.ramIsConnectedFlag = flag;
	}
}