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

public class ICS2606Form extends guiCustoms{
	Font gothamBook,gothamBookBold,futura,gothamLight;
	Icon icnPfp;
	
	JPanel mainContainer, gradeForm;
	JButton bBack,bLogout,bClear,bDisplay,bSave;
	
	JTextField txtName,txtStudentNo,txtSection, 
			txtLabExer1,txtLabExer2,txtLabExer3,txtLabExer4,
			txtLongTest1,txtLongTest2,txtLongTest3,
			txtPrelimExams,txtFinalExams,
			txtPrelimGrade,txtFinalGrade,
			txtPrelimTransmuted,txtFinalTransmuted,txtSubjectGradeTransmuted;
	
	JLabel lblName,lblStudentNo,lblSection,
			lblPrelims,lblFinals,
			lblLabExerTitle,lblLabExer1,lblLabExer2,lblLabExer4,
			lblLongTextTitle,lblLongTest1,lblLongTest2,lblLongTest3,
			lblPrelimExamTitle, lblPrelimGrade, lblPrelimExams,
			lblFinalExamTitle, lblFinalGrade, lblFinalExams,
			lblPrelimTransmuted,lblFinalTransmuted,lblSubjectTransmuted,
			lblIconHolder,lblStudentName,lblDepartment;
	
	public ICS2606Form(){
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
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		mainContainer = new JPanel();
		mainContainer.setPreferredSize(new Dimension(1280, 720));
		mainContainer.setBounds(0, 0, 1280, 720);
		mainContainer.setBackground(bgColor);
		mainContainer.setLayout(null);
		
		gradeForm = new JPanel();
		gradeForm.setOpaque(false);
		gradeForm.setPreferredSize(new Dimension(1280, 720));
		gradeForm.setBounds(0, 0, 1280, 720);
		gradeForm.setLayout(null);
		mainContainer.add(gradeForm);
		
		lblIconHolder = new JLabel();
		icnPfp = new ImageIcon("res\\pfp-icon.png");
		lblIconHolder.setIcon(icnPfp);
		lblIconHolder.setBounds(48, 30, 109, 110);
		gradeForm.add(lblIconHolder);
		
		lblStudentName = new JLabel("STUDENT NAME");
		lblStudentName.setBounds(179, 57, 500, 28);
		lblStudentName.setFont(futura.deriveFont(Font.PLAIN,28));
		lblStudentName.setForeground(userFontGray);
		gradeForm.add(lblStudentName);
		
		lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setBounds(179, 83, 500, 18);
		lblDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lblDepartment.setForeground(userFontGray);
		gradeForm.add(lblDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,26));
		bLogout.setBounds(1069, 40, 150, 46);
		bLogout.setOpaque(false);
		bLogout.setContentAreaFilled(false);
		bLogout.setBorderPainted(false);
		bLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogout.setForeground(Color.WHITE);
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				
				//CustomDialog Constructor: headContent, messageContent, parentPane, childPane, newPane, buttonContentCancel, buttonContentConfirm, color
				CustomDialog cd = new CustomDialog("Log Out","Are you sure you want to logout?",mainContainer,gradeForm,usrLogin,"Cancel","Logout",paneRed);
				cd.setVisible(true);
			}
		});
		
		gradeForm.add(bLogout);
		
		
		
		add(mainContainer);
		setVisible(true);
	}
}
