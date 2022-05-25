package com.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class CoursePicker extends guiCustoms{
	JPanel coursePicker;
	JComboBox cbCoursePicker;
	JButton bNext,bLogout;
	Font gothamBook,gothamBookBold,futura,gothamLight;
	Icon icnUST;
	JLabel lSelect,lUST,lStudentName,lDepartment;
	String[] cbOptions = {" Choose your course"," ICS2606"," ICS2622"};
	
	public CoursePicker() {
		try {
			futura = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\futur.ttf"));
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBook.ttf"));
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBold.ttf"));
			gothamLight = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamLight.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(futura); 
			ge.registerFont(gothamBook); 
			ge.registerFont(gothamBookBold); 
			ge.registerFont(gothamLight);
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		coursePicker = new JPanel();
		coursePicker.setBackground(bgColor);
		coursePicker.setPreferredSize(new Dimension(1280, 720));
		coursePicker.setBounds(0, 0, 1280, 720);
		coursePicker.setLayout(null);
		
		lUST = new JLabel();
		icnUST = new ImageIcon("res\\pfp-icon.png");
		lUST.setIcon(icnUST);
		lUST.setBounds(48, 80, 109, 110);
		coursePicker.add(lUST);
		
		lStudentName = new JLabel("STUDENT NAME");
		lStudentName.setBounds(179, 107, 500, 28);
		lStudentName.setFont(futura.deriveFont(Font.PLAIN,28));
		lStudentName.setForeground(userFontGray);
		coursePicker.add(lStudentName);
		
		lDepartment = new JLabel("DEPARTMENT");
		lDepartment.setBounds(179, 133, 500, 18);
		lDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lDepartment.setForeground(userFontGray);
		coursePicker.add(lDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,26));
		bLogout.setBounds(1069, 90, 150, 46);
		bLogout.setOpaque(false);
		bLogout.setContentAreaFilled(false);
		bLogout.setBorderPainted(false);
		bLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogout.setForeground(Color.WHITE);
		coursePicker.add(bLogout);
		
		lSelect = new JLabel("SELECT COURSE");
		lSelect.setFont(gothamBook.deriveFont(Font.PLAIN,36));
		lSelect.setBounds(480, 270, 500, 36);
		lSelect.setForeground(Color.WHITE);
		coursePicker.add(lSelect);	
		
		cbCoursePicker = new JComboBox<>(cbOptions);
		cbCoursePicker.setBounds(373, 320, 531, 66);
		cbCoursePicker.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		coursePicker.add(cbCoursePicker);
		
		bNext = new JButton("Next");
		bNext.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bNext.setBounds(590, 408, 100, 46);
		bNext.setBackground(Color.WHITE);
		bNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bNext.setForeground(Color.BLACK);
		coursePicker.add(bNext);
		
		add(coursePicker);
		setVisible(true);
		
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame f = new JFrame();
				JDialog  customPane = new JDialog (f,true);
				customPane.getContentPane().setBackground(customPaneColor);
				customPane.setLayout(null);
				customPane.setUndecorated(true);
				customPane.setBounds(393,222,500,250);
				
				JLabel head = new JLabel("Log Out");
				head.setFont(gothamBookBold.deriveFont(Font.PLAIN,28));
				head.setForeground(Color.WHITE);
				head.setBounds(20,20,500,56);
				customPane.add(head);
				
				JLabel message = new JLabel("Are you sure you want to logout?");
				message.setFont(gothamLight.deriveFont(Font.PLAIN,16));
				message.setForeground(Color.WHITE);
				message.setBounds(20,60,500,56);
				customPane.add(message);
					
				JButton cancel = new JButton("Cancel");
				cancel.setFont(gothamLight.deriveFont(Font.PLAIN,16));
				cancel.setBackground(customPaneColor);
				cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancel.setOpaque(false);
				cancel.setContentAreaFilled(false);
				cancel.setBorderPainted(false);
				cancel.setForeground(Color.WHITE);
				cancel.setBounds(260,175,105,48);
				cancel.setFocusable(false);
				customPane.add(cancel);
				
				JButton confirm = new JButton("Logout");
				confirm.setFont(gothamLight.deriveFont(Font.PLAIN,16));
				confirm.setBackground(paneRed);
				confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirm.setForeground(Color.WHITE);
				confirm.setBorderPainted(false);
				confirm.setBounds(375,175,105,48);
				confirm.setFocusable(false);
				customPane.add(confirm);
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						customPane.dispose();
					}
				});
				
				confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UsrLogin usrLogin = new UsrLogin();
						usrLogin.setPreferredSize(new Dimension(1280, 720));
						usrLogin.setBounds(0, 0, 1280, 720);
						
						coursePicker.setVisible(false);
						add(usrLogin);
						usrLogin.setVisible(true);
						customPane.dispose();
					}
				});
				
				customPane.setPreferredSize(new Dimension(500, 250));
				customPane.setLocationRelativeTo(null);
				customPane.setVisible(true);
			}
		});
	}
}
