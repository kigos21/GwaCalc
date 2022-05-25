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
	JLabel lTitle, lSelect,lUST,lStudentName,lDepartment;
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
		
		lTitle = new JLabel("GENERAL WEIGHTED AVERAGE CALCULATOR");
		lTitle.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lTitle.setBounds(48, 16, 350, 10);
		lTitle.setForeground(Color.WHITE);
		coursePicker.add(lTitle);
		
		lUST = new JLabel();
		icnUST = new ImageIcon("res\\ust-seal.png");
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
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm Action",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(input==0) {
		            UsrLogin usrLogin = new UsrLogin();
		            usrLogin.setPreferredSize(new Dimension(1280, 720));
		            usrLogin.setBounds(0, 0, 1280, 720);
		            
		            coursePicker.setVisible(false);
		            add(usrLogin);
		            usrLogin.setVisible(true);
				}
				//}
				//else {
					
				//}
			}
		});
	}
}
