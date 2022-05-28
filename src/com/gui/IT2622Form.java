package com.gui;

import java.awt.*;
import java.io.*;
import javax.swing.*;

import com.user.UserStudent;

import java.awt.event.*;

public class IT2622Form extends guiCustoms {
	
	Font gothamBook,gothamBookBold,futura,gothamLight;
	Icon icnPfp;
	
	JPanel mainContainer, gradeForm;
	JButton bBack,bLogout,bClear,bDisplay,bSave;
	
	JLabel lblIconHolder,lblStudentName,lblDepartment,
			lblCourseName, lblStudentDetails, 
			lblName, lblStudentNo, lblSection,
			lblPrelims, lblFinals,
			lblPrelimClassStanding, lblPrelimAttendance, lblPrelimRecitation,  lblFA,
			lblPrelimLongTest, lblLongTest1,
			lblPrelimDeliverable, lblWireframe, lblStoryboard, lblPrototype,
			lblPrelimExam, lblPrelimGrade, lblTransmutedPrelimGrade,
			
			lblFinalClassStanding, lblFinalAttendance, lblFinalRecitation, lblAssignment,
			lblFinalLongTest, lblLongTest2, lblLongTest3,
			lblFinalDeliverable, lblDeliverable1, lblIntegratedAsmnt,
			lblFinalGrade, lblTransmutedFinalGrade;
	
	JTextField tfName, tfStudentNo, tfSection, 
			tfPrelimAttendance, tfPrelimRecitation,  tfFA,
			tfLongTest1, tfWireframe, tfStoryboard, tfPrototype,
			tfPrelimExam, tfPrelimGrade, tfTransmutedPrelimGrade,
			
			tfFinalAttendance, tfFinalRecitation, tfAssignment,
			tfLongTest2, tfLongTest3, tfDeliverable1, tfIntegratedAsmnt,
			tfFinalGrade, tfTransmutedFinalGrade;
	
	public IT2622Form() {
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
		
		mainContainer = new JPanel(null);
		mainContainer.setPreferredSize(new Dimension(1280, 720));
		mainContainer.setBounds(0, 0, 1280, 720);
		mainContainer.setBackground(bgColor);
		
		gradeForm = new JPanel(null);
		gradeForm.setOpaque(false);
		gradeForm.setPreferredSize(new Dimension(1280, 720));
		gradeForm.setBounds(0, 0, 1280, 720);
		mainContainer.add(gradeForm);
		
		icnPfp = new ImageIcon("res\\pfp-icon.png");
		lblIconHolder = new JLabel(icnPfp);
		lblIconHolder.setBounds(48, 30, 80, 80);
		gradeForm.add(lblIconHolder);
		
		try {
			File loginCreds = new File("data\\usr-login-creds.txt");
			BufferedReader br = new BufferedReader(new FileReader(loginCreds));
			br = new BufferedReader(new FileReader(loginCreds));
			UserStudent user = new UserStudent(br.readLine(), br.readLine());
			lblStudentName = new JLabel(user.getUsername());
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		lblStudentName.setBounds(145, 57, 500, 28);
		lblStudentName.setFont(futura.deriveFont(Font.PLAIN, 28));
		lblStudentName.setForeground(userFontGray);
		gradeForm.add(lblStudentName);
		
		lblDepartment = new JLabel("UNIVERSITY OF SANTO TOMAS");
		lblDepartment.setBounds(145, 83, 500, 18);
		lblDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lblDepartment.setForeground(userFontGray);
		gradeForm.add(lblDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,24));
		bLogout.setBounds(1069, 55, 150, 46);
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
		
		lblCourseName = new JLabel("IT2622", JLabel.CENTER);
		lblCourseName.setBounds(567,66,147,35);
		lblCourseName.setFont(gothamBookBold.deriveFont(Font.PLAIN,28));
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblCourseName);
		
		lblStudentDetails = new JLabel("Student Details", JLabel.CENTER);
		lblStudentDetails.setBounds(513,97,254,31);
		lblStudentDetails.setFont(gothamBook.deriveFont(Font.PLAIN,25));
		lblStudentDetails.setForeground(Color.WHITE);
		lblStudentDetails.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblStudentDetails);
		
		lblName = new JLabel("Name");
		lblName.setBounds(220,139,48,16);
		lblName.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblName.setForeground(Color.WHITE);
		gradeForm.add(lblName);
		
		tfName = new JTextField("");
		tfName.setBounds(270,138,340,18);
		tfName.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfName.setForeground(textfieldGray);
		tfName.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfName);
		
		lblStudentNo = new JLabel("Student Number");
		lblStudentNo.setBounds(617,139,135,16);
		lblStudentNo.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblStudentNo.setForeground(Color.WHITE);
		gradeForm.add(lblStudentNo);
		
		tfStudentNo = new JTextField("");
		tfStudentNo.setBounds(749,138,164,18);
		tfStudentNo.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfStudentNo.setForeground(textfieldGray);
		tfStudentNo.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfStudentNo);
		
		lblSection = new JLabel("Section");
		lblSection.setBounds(928,139,60,16);
		lblSection.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblSection.setForeground(Color.WHITE);
		gradeForm.add(lblSection);
		
		tfSection = new JTextField("");
		tfSection.setBounds(990,138,72,18);
		tfSection.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfSection.setForeground(textfieldGray);
		tfSection.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfSection);
		
		lblPrelims = new JLabel("Prelims");
		lblPrelims.setBounds(389,167,73,22);
		lblPrelims.setFont(gothamBook.deriveFont(Font.BOLD, 18));
		lblPrelims.setForeground(Color.WHITE);
		gradeForm.add(lblPrelims);
		
		lblFinals = new JLabel("Finals");
		lblFinals.setBounds(829,167,57,22);
		lblFinals.setFont(gothamBook.deriveFont(Font.BOLD, 18));
		lblFinals.setForeground(Color.WHITE);
		gradeForm.add(lblFinals);
		
		lblPrelimClassStanding = new JLabel("Class Standing (10%)");
		lblPrelimClassStanding.setBounds(219,201,164,18);
		lblPrelimClassStanding.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimClassStanding.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimClassStanding);
		
		lblPrelimAttendance = new JLabel("Attendance", JLabel.RIGHT);
		lblPrelimAttendance.setBounds(221,232,188,18);
		lblPrelimAttendance.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimAttendance.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimAttendance);
		
		tfPrelimAttendance = new JTextField("");
		tfPrelimAttendance.setBounds(413,232,196,18);
		tfPrelimAttendance.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfPrelimAttendance.setForeground(textfieldGray);
		tfPrelimAttendance.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimAttendance.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfPrelimAttendance);
		
		lblPrelimRecitation = new JLabel("Recitation", JLabel.RIGHT);
		lblPrelimRecitation.setBounds(221,262,188,18);
		lblPrelimRecitation.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimRecitation.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimRecitation);
		
		tfPrelimRecitation = new JTextField("");
		tfPrelimRecitation.setBounds(413,262,196,18);
		tfPrelimRecitation.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfPrelimRecitation.setForeground(textfieldGray);
		tfPrelimRecitation.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimRecitation.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfPrelimRecitation);
		
		lblFA = new JLabel("Formative Assessments", JLabel.RIGHT);
		lblFA.setBounds(221,291,188,18);
		lblFA.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFA.setForeground(Color.WHITE);
		gradeForm.add(lblFA);
		
		tfFA = new JTextField("");
		tfFA.setBounds(413,292,196,18);
		tfFA.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfFA.setForeground(textfieldGray);
		tfFA.setHorizontalAlignment(JTextField.RIGHT);
		tfFA.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfFA);
		
		lblPrelimLongTest = new JLabel("Long Test (30%)");
		lblPrelimLongTest.setBounds(219,325,150,18);
		lblPrelimLongTest.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimLongTest.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimLongTest);
		
		lblLongTest1 = new JLabel("Long Test 1", JLabel.RIGHT);
		lblLongTest1.setBounds(322,356,87,18);
		lblLongTest1.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblLongTest1.setForeground(Color.WHITE);
		gradeForm.add(lblLongTest1);
		
		tfLongTest1 = new JTextField("");
		tfLongTest1.setBounds(413,356,196,18);
		tfLongTest1.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfLongTest1.setForeground(textfieldGray);
		tfLongTest1.setHorizontalAlignment(JTextField.RIGHT);
		tfLongTest1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfLongTest1);
		
		lblPrelimDeliverable = new JLabel("Deliverable (30%)");
		lblPrelimDeliverable.setBounds(219,386,150,18);
		lblPrelimDeliverable.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimDeliverable.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimDeliverable);
		
		lblWireframe = new JLabel("Wireframe");
		lblWireframe.setBounds(219,416,80,18);
		lblWireframe.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblWireframe.setForeground(Color.WHITE);
		gradeForm.add(lblWireframe);
		
		tfWireframe = new JTextField("");
		tfWireframe.setBounds(302,416,42,18);
		tfWireframe.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfWireframe.setForeground(textfieldGray);
		tfWireframe.setHorizontalAlignment(JTextField.RIGHT);
		tfWireframe.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfWireframe);
		
		lblStoryboard = new JLabel("Storyboard");
		lblStoryboard.setBounds(350,416,90,18);
		lblStoryboard.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblStoryboard.setForeground(Color.WHITE);
		gradeForm.add(lblStoryboard);
		
		tfStoryboard = new JTextField("");
		tfStoryboard.setBounds(440,416,42,18);
		tfStoryboard.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfStoryboard.setForeground(textfieldGray);
		tfStoryboard.setHorizontalAlignment(JTextField.RIGHT);
		tfStoryboard.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfStoryboard);
		
		lblPrototype = new JLabel("Prototype", JLabel.RIGHT);
		lblPrototype.setBounds(477,416,87,18);
		lblPrototype.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrototype.setForeground(Color.WHITE);
		gradeForm.add(lblPrototype);
		
		tfPrototype = new JTextField("");
		tfPrototype.setBounds(567,416,42,18);
		tfPrototype.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfPrototype.setForeground(textfieldGray);
		tfPrototype.setHorizontalAlignment(JTextField.RIGHT);
		tfPrototype.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfPrototype);
		
		lblPrelimExam = new JLabel("Prelim Exam (30%)");
		lblPrelimExam.setBounds(221,460,148,18);
		lblPrelimExam.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimExam.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimExam);
		
		tfPrelimExam = new JTextField("");
		tfPrelimExam.setBounds(413,461,196,18);
		tfPrelimExam.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfPrelimExam.setForeground(textfieldGray);
		tfPrelimExam.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimExam.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfPrelimExam);
		
		lblPrelimGrade = new JLabel("Prelim Grade", JLabel.RIGHT);
		lblPrelimGrade.setBounds(324,506,200,18);
		lblPrelimGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimGrade.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimGrade);
		
		tfPrelimGrade = new JTextField("");
		tfPrelimGrade.setBounds(541,501,68,28);
		tfPrelimGrade.setFont(gothamBook.deriveFont(Font.BOLD,26));
		tfPrelimGrade.setForeground(textfieldGray);
		tfPrelimGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimGrade.setEditable(false);
		tfPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfPrelimGrade);
		
		lblTransmutedPrelimGrade = new JLabel("Transmuted Prelim Grade", JLabel.RIGHT);
		lblTransmutedPrelimGrade.setBounds(324,544,200,18);
		lblTransmutedPrelimGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblTransmutedPrelimGrade.setForeground(Color.WHITE);
		gradeForm.add(lblTransmutedPrelimGrade);
		
		tfTransmutedPrelimGrade = new JTextField("");
		tfTransmutedPrelimGrade.setBounds(541,539,68,28);
		tfTransmutedPrelimGrade.setFont(gothamBook.deriveFont(Font.BOLD,26));
		tfTransmutedPrelimGrade.setForeground(textfieldGray);
		tfTransmutedPrelimGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfTransmutedPrelimGrade.setEditable(false);
		tfTransmutedPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfTransmutedPrelimGrade);
		
		// FINALS
		lblFinalClassStanding = new JLabel("Class Standing (10%)");
		lblFinalClassStanding.setBounds(672,201,164,18);
		lblFinalClassStanding.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalClassStanding.setForeground(Color.WHITE);
		gradeForm.add(lblFinalClassStanding);
		
		lblFinalAttendance = new JLabel("Attendance", JLabel.RIGHT);
		lblFinalAttendance.setBounds(674,232,188,18);
		lblFinalAttendance.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalAttendance.setForeground(Color.WHITE);
		gradeForm.add(lblFinalAttendance);
		
		lblFinalRecitation = new JLabel("Recitation", JLabel.RIGHT);
		lblFinalRecitation.setBounds(674,262,188,18);
		lblFinalRecitation.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalRecitation.setForeground(Color.WHITE);
		gradeForm.add(lblFinalRecitation);
		
		lblAssignment = new JLabel("Assignment", JLabel.RIGHT);
		lblAssignment.setBounds(674,291,188,18);
		lblAssignment.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblAssignment.setForeground(Color.WHITE);
		gradeForm.add(lblAssignment);
		
		tfFinalAttendance = new JTextField("");
		tfFinalAttendance.setBounds(866,232,196,18);
		tfFinalAttendance.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfFinalAttendance.setForeground(textfieldGray);
		tfFinalAttendance.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalAttendance.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfFinalAttendance);
		
		tfFinalRecitation = new JTextField("");
		tfFinalRecitation.setBounds(866,262,196,18);
		tfFinalRecitation.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfFinalRecitation.setForeground(textfieldGray);
		tfFinalRecitation.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalRecitation.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfFinalRecitation);
		
		tfAssignment = new JTextField("");
		tfAssignment.setBounds(866,292,196,18);
		tfAssignment.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfAssignment.setForeground(textfieldGray);
		tfAssignment.setHorizontalAlignment(JTextField.RIGHT);
		tfAssignment.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfAssignment);
		
		lblFinalLongTest = new JLabel("Long Test (30%)");
		lblFinalLongTest.setBounds(672,325,150,18);
		lblFinalLongTest.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalLongTest.setForeground(Color.WHITE);
		gradeForm.add(lblFinalLongTest);
		
		lblLongTest2 = new JLabel("Long Test 2", JLabel.RIGHT);
		lblLongTest2.setBounds(760,356,103,18);
		lblLongTest2.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblLongTest2.setForeground(Color.WHITE);
		gradeForm.add(lblLongTest2);
		
		tfLongTest2 = new JTextField("");
		tfLongTest2.setBounds(866,356,42,18);
		tfLongTest2.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfLongTest2.setForeground(textfieldGray);
		tfLongTest2.setHorizontalAlignment(JTextField.RIGHT);
		tfLongTest2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfLongTest2);
		
		lblLongTest3 = new JLabel("Long Test 3", JLabel.RIGHT);
		lblLongTest3.setBounds(914,356,103,18);
		lblLongTest3.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblLongTest3.setForeground(Color.WHITE);
		gradeForm.add(lblLongTest3);
		
		tfLongTest3 = new JTextField("");
		tfLongTest3.setBounds(1020,356,42,18);
		tfLongTest3.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfLongTest3.setForeground(textfieldGray);
		tfLongTest3.setHorizontalAlignment(JTextField.RIGHT);
		tfLongTest3.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfLongTest3);
		
		lblFinalDeliverable = new JLabel("Deliverable (30%)");
		lblFinalDeliverable.setBounds(672,386,150,18);
		lblFinalDeliverable.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalDeliverable.setForeground(Color.WHITE);
		gradeForm.add(lblFinalDeliverable);
		
		lblDeliverable1 = new JLabel("Deliverable 1", JLabel.RIGHT);
		lblDeliverable1.setBounds(674,416,188,18);
		lblDeliverable1.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblDeliverable1.setForeground(Color.WHITE);
		gradeForm.add(lblDeliverable1);
		
		tfDeliverable1 = new JTextField("");
		tfDeliverable1.setBounds(866,416,196,18);
		tfDeliverable1.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfDeliverable1.setForeground(textfieldGray);
		tfDeliverable1.setHorizontalAlignment(JTextField.RIGHT);
		tfDeliverable1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfDeliverable1);
		
		lblIntegratedAsmnt = new JLabel("Integrated Asmnt. (30%)");
		lblIntegratedAsmnt.setBounds(672,460,203,18);
		lblIntegratedAsmnt.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblIntegratedAsmnt.setForeground(Color.WHITE);
		gradeForm.add(lblIntegratedAsmnt);
		
		tfIntegratedAsmnt = new JTextField("");
		tfIntegratedAsmnt.setBounds(866,461,196,18);
		tfIntegratedAsmnt.setFont(gothamBook.deriveFont(Font.PLAIN,15));
		tfIntegratedAsmnt.setForeground(textfieldGray);
		tfIntegratedAsmnt.setHorizontalAlignment(JTextField.RIGHT);
		tfIntegratedAsmnt.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfIntegratedAsmnt);
		
		lblFinalGrade = new JLabel("Final Grade", JLabel.RIGHT);
		lblFinalGrade.setBounds(777,506,200,18);
		lblFinalGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalGrade.setForeground(Color.WHITE);
		gradeForm.add(lblFinalGrade);
		
		lblTransmutedFinalGrade = new JLabel("Transmuted Final Grade", JLabel.RIGHT);
		lblTransmutedFinalGrade.setBounds(777,544,200,18);
		lblTransmutedFinalGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblTransmutedFinalGrade.setForeground(Color.WHITE);
		gradeForm.add(lblTransmutedFinalGrade);
		
		tfFinalGrade = new JTextField("");
		tfFinalGrade.setBounds(994,501,68,28);
		tfFinalGrade.setFont(gothamBook.deriveFont(Font.BOLD,26));
		tfFinalGrade.setForeground(textfieldGray);
		tfFinalGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalGrade.setEditable(false);
		tfFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfFinalGrade);
		
		tfTransmutedFinalGrade = new JTextField("");
		tfTransmutedFinalGrade.setBounds(994,539,68,28);
		tfTransmutedFinalGrade.setFont(gothamBook.deriveFont(Font.BOLD,26));
		tfTransmutedFinalGrade.setForeground(textfieldGray);
		tfTransmutedFinalGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfTransmutedFinalGrade.setEditable(false);
		tfTransmutedFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(tfTransmutedFinalGrade);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,26));
		bLogout.setBounds(1069, 60, 150, 46);
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
		
		bClear = new JButton("Clear");
		bClear.setBounds(374, 610, 171, 46);
		bClear.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bClear.setBackground(Color.WHITE);
		bClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bClear.setForeground(Color.BLACK);
		gradeForm.add(bClear);
		
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursePicker cP = new CoursePicker();
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to clear the forms?",gradeForm,"Cancel","Continue	",paneRed);
			}
		});
		
		bDisplay = new JButton("Display");
		bDisplay.setBounds(555, 610, 171, 46);
		bDisplay.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bDisplay.setBackground(Color.WHITE);
		bDisplay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bDisplay.setForeground(Color.BLACK);
		gradeForm.add(bDisplay);
		
		bSave = new JButton("Save to Sheet");
		bSave.setBounds(736, 610, 171, 46);
		bSave.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bSave.setBackground(Color.WHITE);
		bSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bSave.setForeground(Color.BLACK);
		gradeForm.add(bSave);
		
		bBack = new JButton("< Back to Course List");
		bBack.setBounds(15, 630, 215, 18);
		bBack.setFont(gothamBook.deriveFont(Font.PLAIN,14));
		bBack.setOpaque(false);
		bBack.setContentAreaFilled(false);
		bBack.setBorderPainted(false);
		bBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bBack.setForeground(hyperColor);
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursePicker cP = new CoursePicker();
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to go back?",mainContainer,gradeForm,cP,"Cancel","Continue	",paneRed);
			}
		});
		gradeForm.add(bBack);
		
		gradeForm.setVisible(true);
		mainContainer.add(gradeForm);
		mainContainer.setVisible(true);
		
		add(mainContainer);
		setVisible(true);
		
	}
}
