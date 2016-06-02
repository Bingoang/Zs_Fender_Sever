/*
 * SearchingExpertPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.crypto.Data;

import com.Zs.DbDao.DbRecord_4ItemDao;
import com.Zs.DbUtil.DbUtil;
import ZsUtil.DateChooserJButton;
import ZsUtil.ZsUtil;

/**
 *
 * @author  __USER__
 */
public class SearchingExpertPanel extends javax.swing.JPanel {
	private DateChooserJButton dateChooserJButton_1 = new DateChooserJButton();
	private DateChooserJButton dateChooserJButton_2 = new DateChooserJButton();
	private DefaultListModel defaultListModel = new DefaultListModel();
	private DefaultListModel m = new DefaultListModel();
	DbUtil dbUtil = new DbUtil();
	DbRecord_4ItemDao dbRecord_4ItemDao = new DbRecord_4ItemDao();

	/** Creates new form SearchingExpertPanel */
	public SearchingExpertPanel() {
		initComponents();
		CreatDateChooserButton();

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		SearchingExpertList = new javax.swing.JList();
		jButton1 = new javax.swing.JButton();
		KM_CheckBox = new javax.swing.JCheckBox();
		ML_CheckBox = new javax.swing.JCheckBox();
		FFRQ_CheckBox = new javax.swing.JCheckBox();
		ZW_CheckBox = new javax.swing.JCheckBox();
		DXSQKM_CheckBox = new javax.swing.JCheckBox();
		SJKM_CheckBox = new javax.swing.JCheckBox();
		YSKM_CheckBox = new javax.swing.JCheckBox();
		DNSQKM_CheckBox = new javax.swing.JCheckBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		DXQQ_CheckBox = new javax.swing.JCheckBox();
		All_CheckBox = new javax.swing.JCheckBox();
		jLabel3 = new javax.swing.JLabel();

		SearchingExpertList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "请选择您想要查询的内容" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(SearchingExpertList);

		jButton1.setText("\u67e5\u8be2\u8bb0\u5f55");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		KM_CheckBox.setText("\u5f00\u95e8");
		KM_CheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				KM_CheckBoxStateChanged(evt);
			}
		});

		ML_CheckBox.setText("\u95e8\u94c3");

		FFRQ_CheckBox.setText("\u975e\u6cd5\u5165\u4fb5");

		ZW_CheckBox.setSelected(true);
		ZW_CheckBox.setText("\u6307\u7eb9\u5f00\u95e8");
		ZW_CheckBox.setEnabled(false);

		DXSQKM_CheckBox.setSelected(true);
		DXSQKM_CheckBox.setText("\u77ed\u4fe1\u6388\u6743\u5f00\u95e8");
		DXSQKM_CheckBox.setEnabled(false);

		SJKM_CheckBox.setSelected(true);
		SJKM_CheckBox.setText("\u624b\u673a\u5f00\u95e8");
		SJKM_CheckBox.setEnabled(false);

		YSKM_CheckBox.setSelected(true);
		YSKM_CheckBox.setText("\u94a5\u5319\u5f00\u95e8");
		YSKM_CheckBox.setEnabled(false);

		DNSQKM_CheckBox.setSelected(true);
		DNSQKM_CheckBox.setText("\u7535\u8111\u6388\u6743\u5f00\u95e8");
		DNSQKM_CheckBox.setEnabled(false);

		jLabel1.setText("\u4e8b\u4ef6");

		jLabel2.setText("\u5f00\u95e8\u65b9\u5f0f");

		DXQQ_CheckBox.setText("\u77ed\u4fe1\u8bf7\u6c42");

		All_CheckBox.setSelected(true);
		All_CheckBox.setText("\u6240\u6709\u8bb0\u5f55");

		jLabel3.setText("\u8bf7\u9009\u62e9\u67e5\u8be2\u65f6\u95f4\u533a\u95f4");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(44, 44,
																		44)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										ZW_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										DXSQKM_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										SJKM_CheckBox))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										KM_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										ML_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										FFRQ_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										DXQQ_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										All_CheckBox))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										YSKM_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										DNSQKM_CheckBox))))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jLabel2)))
								.addGap(65, 65, 65))
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel3)
								.addContainerGap(322, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										418, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jButton1)
								.addContainerGap(349, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addGap(4, 4, 4)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(KM_CheckBox)
												.addComponent(ML_CheckBox)
												.addComponent(FFRQ_CheckBox)
												.addComponent(DXQQ_CheckBox)
												.addComponent(All_CheckBox))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel2)
								.addGap(3, 3, 3)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(ZW_CheckBox)
												.addComponent(DXSQKM_CheckBox)
												.addComponent(SJKM_CheckBox))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(YSKM_CheckBox)
												.addComponent(DNSQKM_CheckBox))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										144, Short.MAX_VALUE)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										325,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void KM_CheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {
		setOpenDoorCheckBoxEnabled();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
			throws Exception {
		Connection con = dbUtil.getCon();
		defaultListModel.clear();
		m.clear();
		defaultListModel = this.getList(con);//得到没有时间约束的数据
		defaultListModel = this.getResultListBydate(defaultListModel);//时间约束

		for (int i = 0; i < defaultListModel.getSize(); i++) {
			int length = defaultListModel.get(i).toString().length();//将10150311095447转化为2015年03月11日09时54分47秒
			String str = DbRecord_4ItemDao
					.getStringFromSqlDate(defaultListModel.get(i).toString()
							.substring(length - 14));
			m.addElement(defaultListModel.get(i).toString()
					.substring(0, length - 14)
					+ str);
		}

		//System.out.println(str6);
		this.showList(m);
		dbUtil.closeCon(con);
	}

	/**
	 * 得到制定内容
	 * @param con 数据库连接
	 * @param item 表格中的那一列的列明
	 * @param content 那一列的内容
	 * @throws Exception
	 */

	/**
	 * 输入变量 显示在LIST上
	 * @param SearchingExpertModel
	 */
	private void showList(DefaultListModel SearchingExpertModel) {

		this.SearchingExpertList.setModel(SearchingExpertModel);
		this.SearchingExpertList = new JList(SearchingExpertModel);
		this.SearchingExpertList.invalidate();
		this.SearchingExpertList.repaint();
	}

	private void setOpenDoorCheckBoxEnabled() {
		this.ZW_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
		this.DXSQKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
		this.SJKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
		this.YSKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
		this.DNSQKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	}

	private void CreatDateChooserButton() {
		this.add(dateChooserJButton_1);
		this.add(dateChooserJButton_2);
		this.dateChooserJButton_1.setSize(150, 20);
		this.dateChooserJButton_1.setLocation(20, 180);
		this.dateChooserJButton_2.setSize(150, 20);
		this.dateChooserJButton_2.setLocation(20, 210);
		return;
	}

	private DefaultListModel getList(Connection con) throws SQLException {
		DefaultListModel m = new DefaultListModel();
		m.clear();
		if (All_CheckBox.isSelected()) {
			m = dbRecord_4ItemDao.getAll(con);
		} else {
			if (KM_CheckBox.isSelected()) {
				m = getOpenDoorDfLstMd_Sub(con);
			}
			if (ML_CheckBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb(con, "DoSth", "按门铃在"));
			}
			if (FFRQ_CheckBox.isSelected()) {
				m = ZsUtil
						.DftMd_Add(m, dbRecord_4ItemDao.getSearchingDb(con,
								"DoSth", "非法入侵在"));
			}
			if (DXQQ_CheckBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb(con, "DoSth", "发短信在"));
			}

		}
		return m;
	}

	private DefaultListModel getOpenDoorDfLstMd_Sub(Connection con)
			throws SQLException {
		DefaultListModel m = new DefaultListModel();
		if (ZW_CheckBox.isSelected()) {
			m = ZsUtil.DftMd_Add(m,
					dbRecord_4ItemDao.getSearchingDb(con, "UseSth", "用指纹"));
		}
		if (DXSQKM_CheckBox.isSelected()) {
			m = ZsUtil.DftMd_Add(m,
					dbRecord_4ItemDao.getSearchingDb(con, "UseSth", "用短信授权"));
		}
		if (SJKM_CheckBox.isSelected()) {
			m = ZsUtil.DftMd_Add(m,
					dbRecord_4ItemDao.getSearchingDb(con, "UseSth", "用手机"));
		}
		if (YSKM_CheckBox.isSelected()) {
			m = ZsUtil.DftMd_Add(m,
					dbRecord_4ItemDao.getSearchingDb(con, "UseSth", "用钥匙"));
		}
		if (DNSQKM_CheckBox.isSelected()) {
			m = ZsUtil.DftMd_Add(m,
					dbRecord_4ItemDao.getSearchingDb(con, "UseSth", "用电脑授权"));
		}
		return m;
	}

	private DefaultListModel getResultListBydate(DefaultListModel m) {
		DefaultListModel result = new DefaultListModel();
		Date date1 = this.dateChooserJButton_1.getDate();
		Date date2 = this.dateChooserJButton_2.getDate();
		String date1_String = ZsUtil.DateToSqlDate_String(date1);
		String date2_String = ZsUtil.DateToSqlDate_String(date2);

		if (date1.compareTo(date2) < 0)//如果date1<date2
		{
			for (int i = 0; i < m.getSize(); i++) {
				if ((ZsUtil.compareSqlDateString(m.get(i).toString(),
						date1_String) > 0)
						&& ZsUtil.compareSqlDateString(m.get(i).toString(),
								date2_String) < 0)//如果m的日期在我们给定的日期以内
				{
					result.addElement(m.get(i));
				}

			}
		} else {
			for (int i = 0; i < m.getSize(); i++) {
				if ((ZsUtil.compareSqlDateString(m.get(i).toString(),
						date1_String) < 0)
						&& ZsUtil.compareSqlDateString(m.get(i).toString(),
								date2_String) > 0)//如果m的日期在我们给定的日期以内
				{
					result.addElement(m.get(i));
				}

			}
		}
		return result;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JCheckBox All_CheckBox;
	private javax.swing.JCheckBox DNSQKM_CheckBox;
	private javax.swing.JCheckBox DXQQ_CheckBox;
	private javax.swing.JCheckBox DXSQKM_CheckBox;
	private javax.swing.JCheckBox FFRQ_CheckBox;
	private javax.swing.JCheckBox KM_CheckBox;
	private javax.swing.JCheckBox ML_CheckBox;
	private javax.swing.JCheckBox SJKM_CheckBox;
	private javax.swing.JList SearchingExpertList;
	private javax.swing.JCheckBox YSKM_CheckBox;
	private javax.swing.JCheckBox ZW_CheckBox;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}