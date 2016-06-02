/*
 * LogFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.Zs.DbDao.DbLogUserDao;
import com.Zs.DbDao.DbLogUserMemb;
import com.Zs.DbUtil.DbUtil;

import ZsUtil.ZsUtil;

/**
 *
 * @author  __USER__
 */
public class LogFrm extends javax.swing.JFrame {
	DbUtil dbUtil = new DbUtil();
	DbLogUserDao dbLogUserDao = new DbLogUserDao();

	/** Creates new form LogFrm */
	public LogFrm() {
		initComponents();
		//设置fram居中显示
		this.setLocationRelativeTo(null);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		userText = new javax.swing.JTextField();
		passwordTxt = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setFont(new java.awt.Font("方正姚体", 0, 10));
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("\u58ee\u58eb\u9632\u76d7");

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6  \u7801");

		jButton1.setText("\u767b\u9646");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("\u9000\u51fa");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel4.setForeground(new java.awt.Color(0, 0, 153));
		jLabel4.setText("\u5fd8\u8bb0\u5bc6\u7801\uff1f");
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel3))
																.addGap(49, 49,
																		49)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						passwordTxt,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						204,
																						Short.MAX_VALUE)
																				.addComponent(
																						userText,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						204,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		153,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		67,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(70, 70, 70))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(329, Short.MAX_VALUE)
								.addComponent(jLabel4).addGap(30, 30, 30))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(206, Short.MAX_VALUE)
								.addComponent(jLabel1).addGap(117, 117, 117)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addComponent(jLabel1)
								.addGap(51, 51, 51)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														userText,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(37, 37, 37)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														passwordTxt,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel4).addGap(17, 17, 17)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
		this.dispose();
		new FindBackPWFrm_sub().setVisible(true);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = userText.getText();
		String passWord = new String(passwordTxt.getPassword());
		if (ZsUtil.stringIsEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (ZsUtil.stringIsEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		DbLogUserMemb user = new DbLogUserMemb(userName, passWord);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			DbLogUserMemb currentUser = dbLogUserDao.login(con, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "登陆成功");
				this.dispose();
				new MainFrm().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "登陆失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		ZsUtil.distroyFrm(this);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LogFrm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPasswordField passwordTxt;
	private javax.swing.JTextField userText;
	// End of variables declaration//GEN-END:variables

}