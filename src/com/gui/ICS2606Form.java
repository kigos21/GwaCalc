package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.gui.IT2622Form.ScoreOverloadException;
import com.gui.IT2622Form.ScoreTextField;
import com.user.*;

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
	
	JLabel lblCourseName,lblName,lblStudentNo,lblSection,
			lblPrelims,lblFinals,
			lblLabExerTitle,lblLabExerTitle2,lblLabExer1,lblLabExer2,lblLabExer3,lblLabExer4,
			lblLongTextTitle,lblLongTextTitle2,lblLongTest1,lblLongTest2,lblLongTest3,
			lblPrelimExamTitle, lblPrelimGrade, lblPrelimExams,
			lblFinalExamTitle, lblFinalGrade, lblFinalExams,
			lblPrelimTransmuted,lblFinalTransmuted,lblSubjectTransmuted,
			lblIconHolder,lblStudentName,lblDepartment,
			lblTransmutedTitle,lblSubjectGradeTitle;
	
	ICS2606 comProg;
	SubjectGrade lblSubjectGrade;
	
	class SubjectGrade extends JLabel{
	}
	
	// returns false when there are letters in the String, otherwise true 
	public boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		}
		catch(NumberFormatException e) {  
			return false;  
		}  
	} 
	
	class BlankTextFieldException extends Exception {
		public BlankTextFieldException(String textFieldName, JPanel parentPane) {
			CustomDialog cd = new CustomDialog("Error", "Empty " + textFieldName, parentPane, "OK", paneRed);
		}
	}

	class NumericsInStringException extends Exception {
		public NumericsInStringException(String textFieldName, JPanel parentPane) {
			CustomDialog cd = new CustomDialog("Error", "Invalid character found in " + textFieldName, parentPane, "OK", paneRed);
		}
	}
	class StringInNumericsException extends Exception {
		public StringInNumericsException(String textFieldName, JPanel parentPane) {
			CustomDialog cd = new CustomDialog("Error","Invalid number found in " + textFieldName, parentPane, "OK", paneRed);
		}
	}
	class ScoreOverloadException extends Exception{
		public ScoreOverloadException(String header, String textFieldName, int maxScore,JPanel parentPane) {
			CustomDialog cd = new CustomDialog(header,textFieldName +" exceeds the maximum score of " + maxScore, parentPane, "OK", paneRed);
		}
	}
	
	public ICS2606Form(){
		try {
			InputStream isfutura = getClass().getResourceAsStream("/res/fonts/futur.ttf");
			InputStream isgotham = getClass().getResourceAsStream("/res/fonts/GothamBook.ttf");
			InputStream isgothamBold = getClass().getResourceAsStream("/res/fonts/GothamBold.ttf");
			InputStream isgothamLight = getClass().getResourceAsStream("/res/fonts/GothamLight.ttf");
			futura = Font.createFont(Font.TRUETYPE_FONT, isfutura);
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, isgotham);
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, isgothamBold);
			gothamLight = Font.createFont(Font.TRUETYPE_FONT, isgothamLight);
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
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/pfp-icon.png"));
			icnPfp = new ImageIcon(myImage);
			lblIconHolder.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lblIconHolder.setBounds(48, 30, 80, 80);
		gradeForm.add(lblIconHolder);
		
		
		try {
			File loginCreds = new File("usr-login-creds.txt");
			BufferedReader br = new BufferedReader(new FileReader(loginCreds));
			br = new BufferedReader(new FileReader(loginCreds));
			UserStudent user = new UserStudent(br.readLine(), br.readLine());
			lblStudentName = new JLabel(user.getUsername());
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		lblStudentName.setBounds(145, 57, 500, 28);
		lblStudentName.setFont(futura.deriveFont(Font.PLAIN,28));
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
		bLogout.setFocusable(false);
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				
				//CustomDialog Constructor: headContent, messageContent, parentPane, childPane, newPane, buttonContentCancel, buttonContentConfirm, color
				CustomDialog cd = new CustomDialog("Log Out","Are you sure you want to logout?",mainContainer,gradeForm,usrLogin,"Cancel","Logout",paneRed);
				cd.setVisible(true);
			}
		});
		
		gradeForm.add(bLogout);
		//end of header
		lblCourseName = new JLabel("ICS2606");
		lblCourseName.setBounds(577,66,200,35);
		lblCourseName.setFont(gothamBookBold.deriveFont(Font.PLAIN,28));
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblCourseName);
		

		JLabel lblStudentDetails = new JLabel("Student Details", JLabel.CENTER);
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
		
		txtName = new JTextField("");
		txtName.setBounds(270,138,340,18);
		txtName.setFont(gothamBookBold.deriveFont(Font.PLAIN,16));
		txtName.setForeground(textfieldGray);
		txtName.setName("Name");
		txtName.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtName);
		
		lblStudentNo = new JLabel("Student Number");
		lblStudentNo.setBounds(617,139,135,16);
		lblStudentNo.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblStudentNo.setForeground(Color.WHITE);
		gradeForm.add(lblStudentNo);
		
		txtStudentNo = new JTextField("");
		txtStudentNo.setBounds(749,138,164,18);
		txtStudentNo.setFont(gothamBookBold.deriveFont(Font.PLAIN,16));
		txtStudentNo.setForeground(textfieldGray);
		txtStudentNo.setName("Student Number");
		txtStudentNo.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtStudentNo);
		
		lblSection = new JLabel("Section");
		lblSection.setBounds(928,139,60,16);
		lblSection.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblSection.setForeground(Color.WHITE);
		gradeForm.add(lblSection);
		
		txtSection = new JTextField("");
		txtSection.setBounds(990,138,87,18);
		txtSection.setFont(gothamBookBold.deriveFont(Font.PLAIN,16));
		txtSection.setForeground(textfieldGray);
		txtSection.setName("Section");
		txtSection.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtSection);
		
		//Prelims	
		
		lblPrelims = new JLabel("Prelims");
		lblPrelims.setBounds(389,167,103,22);
		lblPrelims.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		lblPrelims.setForeground(Color.WHITE);
		lblPrelims.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblPrelims);
		
		lblLabExerTitle = new JLabel("Lab Exercises (30%)");
		lblLabExerTitle.setBounds(219,201,200,18);
		lblLabExerTitle.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExerTitle.setForeground(Color.WHITE);
		lblLabExerTitle.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExerTitle);
		
		lblLabExer1 = new JLabel("Lab Exercise 1 (100 pts)", JLabel.RIGHT);
		lblLabExer1.setBounds(212,232,218,18);
		lblLabExer1.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExer1.setForeground(Color.WHITE);
		lblLabExer1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExer1);
		
		txtLabExer1 = new JTextField();
		txtLabExer1.setBounds(433,232,176,18);
		txtLabExer1.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLabExer1.setForeground(textfieldGray);
		txtLabExer1.setName("Lab Exercise 1");
		txtLabExer1.setHorizontalAlignment(JTextField.RIGHT);
		txtLabExer1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLabExer1);
		
		lblLabExer2 = new JLabel("Lab Exercise 2 (100 pts)", JLabel.RIGHT);
		lblLabExer2.setBounds(202,262,228,18);
		lblLabExer2.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExer2.setForeground(Color.WHITE);
		lblLabExer2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExer2);
		
		txtLabExer2 = new JTextField();
		txtLabExer2.setBounds(433,262,176,18);
		txtLabExer2.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLabExer2.setForeground(textfieldGray);
		txtLabExer2.setName("Lab Exercise 2");
		txtLabExer2.setHorizontalAlignment(JTextField.RIGHT);
		txtLabExer2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLabExer2);
		
		lblLabExer3 = new JLabel("Lab Exercise 3 (100 pts)", JLabel.RIGHT);
		lblLabExer3.setBounds(202,291,228,18);
		lblLabExer3.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExer3.setForeground(Color.WHITE);
		lblLabExer3.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExer3);
		
		txtLabExer3 = new JTextField();
		txtLabExer3.setBounds(433,291,176,18);
		txtLabExer3.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLabExer3.setForeground(textfieldGray);
		txtLabExer3.setName("Lab Exercise 3");
		txtLabExer3.setHorizontalAlignment(JTextField.RIGHT);
		txtLabExer3.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLabExer3);
		
		lblLongTextTitle = new JLabel("Long Test (30%)");
		lblLongTextTitle.setBounds(219,325,180,18);
		lblLongTextTitle.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLongTextTitle.setForeground(Color.WHITE);
		lblLongTextTitle.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLongTextTitle);
		
		lblLongTest1 = new JLabel("Long Test 1 (50 pts)", JLabel.RIGHT);
		lblLongTest1.setBounds(240,356,188,18);
		lblLongTest1.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLongTest1.setForeground(Color.WHITE);
		lblLongTest1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLongTest1);
		
		txtLongTest1 = new JTextField();
		txtLongTest1.setBounds(433,356,176,18);
		txtLongTest1.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLongTest1.setForeground(textfieldGray);
		txtLongTest1.setName("Long Test 1");
		txtLongTest1.setHorizontalAlignment(JTextField.RIGHT);
		txtLongTest1.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLongTest1);
		
		lblLongTest2 = new JLabel("Long Test 2 (50 pts)", JLabel.RIGHT);
		lblLongTest2.setBounds(240,386,188,18);
		lblLongTest2.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLongTest2.setForeground(Color.WHITE);
		lblLongTest2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLongTest2);
		
		txtLongTest2 = new JTextField();
		txtLongTest2.setBounds(433,386,176,18);
		txtLongTest2.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLongTest2.setForeground(textfieldGray);
		txtLongTest2.setName("Long Test 2");
		txtLongTest2.setHorizontalAlignment(JTextField.RIGHT);
		txtLongTest2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLongTest2);
		
		lblPrelimExamTitle = new JLabel("Examinations (40%)");
		lblPrelimExamTitle.setBounds(219,430,210,18);
		lblPrelimExamTitle.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblPrelimExamTitle.setForeground(Color.WHITE);
		lblPrelimExamTitle.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblPrelimExamTitle);
		
		lblPrelimExams = new JLabel("Prelim Exam (100 pts)", JLabel.RIGHT);
		lblPrelimExams.setBounds(214,460,215,18);
		lblPrelimExams.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblPrelimExams.setForeground(Color.WHITE);
		lblPrelimExams.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblPrelimExams);
		
		txtPrelimExams = new JTextField();
		txtPrelimExams.setBounds(433,461,176,18);
		txtPrelimExams.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtPrelimExams.setForeground(textfieldGray);
		txtPrelimExams.setName("Prelim Exams");
		txtPrelimExams.setHorizontalAlignment(JTextField.RIGHT);
		txtPrelimExams.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtPrelimExams);
		
		lblPrelimGrade= new JLabel("Prelim Grade");
		lblPrelimGrade.setBounds(415,506,150,18);
		lblPrelimGrade.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblPrelimGrade.setForeground(Color.WHITE);
		lblPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblPrelimGrade);
		
		txtPrelimGrade = new JTextField();
		txtPrelimGrade.setBounds(541,501,68,28);
		txtPrelimGrade.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		txtPrelimGrade.setForeground(textfieldGray);
		txtPrelimGrade.setHorizontalAlignment(JTextField.RIGHT);
		txtPrelimGrade.setEditable(false);
		txtPrelimGrade.setName("Prelim Grade");
		txtPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtPrelimGrade);
		
		lblPrelimTransmuted = new JLabel("Transmuted Prelim Grade");
		lblPrelimTransmuted.setBounds(304,544,300,18);
		lblPrelimTransmuted.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblPrelimTransmuted.setForeground(Color.WHITE);
		lblPrelimTransmuted.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblPrelimTransmuted);
		
		txtPrelimTransmuted = new JTextField();
		txtPrelimTransmuted.setBounds(541,539,68,28);
		txtPrelimTransmuted.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		txtPrelimTransmuted.setForeground(textfieldGray);
		txtPrelimTransmuted.setHorizontalAlignment(JTextField.RIGHT);
		txtPrelimTransmuted.setEditable(false);
		txtPrelimTransmuted.setName("Transmuted Prelim Grade");
		txtPrelimTransmuted.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtPrelimTransmuted);
		
		//Finals
		
		lblFinals = new JLabel("Finals");
		lblFinals.setBounds(851,167,103,22);
		lblFinals.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		lblFinals.setForeground(Color.WHITE);
		lblFinals.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblFinals);
		
		lblLabExerTitle2 = new JLabel("Lab Exercises (30%)");
		lblLabExerTitle2.setBounds(672,201,200,18);
		lblLabExerTitle2.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExerTitle2.setForeground(Color.WHITE);
		lblLabExerTitle2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExerTitle2);
		
		lblLabExer4 = new JLabel("Lab Exercise 4 (100 pts)", JLabel.RIGHT);
		lblLabExer4.setBounds(663,232,229,18);
		lblLabExer4.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLabExer4.setForeground(Color.WHITE);
		lblLabExer4.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLabExer4);
		
		txtLabExer4 = new JTextField();
		txtLabExer4.setBounds(896,232,181,18);
		txtLabExer4.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLabExer4.setForeground(textfieldGray);
		txtLabExer4.setHorizontalAlignment(JTextField.RIGHT);
		txtLabExer4.setName("Lab Exercise 4");
		txtLabExer4.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLabExer4);
		
		lblLongTextTitle2 = new JLabel("Long Test (30%)");
		lblLongTextTitle2.setBounds(672,262,200,18);
		lblLongTextTitle2.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLongTextTitle2.setForeground(Color.WHITE);
		lblLongTextTitle2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLongTextTitle2);
		
		lblLongTest2 = new JLabel("Long Test 3 (50 pts)", JLabel.RIGHT);
		lblLongTest2.setBounds(704,294,187,18);
		lblLongTest2.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblLongTest2.setForeground(Color.WHITE);
		lblLongTest2.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblLongTest2);
		
		txtLongTest3 = new JTextField();
		txtLongTest3.setBounds(896,291,181,18);
		txtLongTest3.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtLongTest3.setForeground(textfieldGray);
		txtLongTest3.setHorizontalAlignment(JTextField.RIGHT);
		txtLongTest3.setName("Long Test 3");
		txtLongTest3.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtLongTest3);
		
		lblFinalExamTitle = new JLabel("Examinations (40%)");
		lblFinalExamTitle.setBounds(672,325,210,18);
		lblFinalExamTitle.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblFinalExamTitle.setForeground(Color.WHITE);
		lblFinalExamTitle.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblFinalExamTitle);
		
		lblFinalExams = new JLabel("Final Exam (100 pts)", JLabel.RIGHT);
		lblFinalExams.setBounds(704,356,188,18);
		lblFinalExams.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblFinalExams.setForeground(Color.WHITE);
		lblFinalExams.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblFinalExams);
		
		txtFinalExams = new JTextField();
		txtFinalExams.setBounds(896,356,181,18);
		txtFinalExams.setFont(gothamBookBold.deriveFont(Font.PLAIN,18));
		txtFinalExams.setForeground(textfieldGray);
		txtFinalExams.setHorizontalAlignment(JTextField.RIGHT);
		txtFinalExams.setName("Final Exams");
		txtFinalExams.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtFinalExams);
		
		lblFinalGrade= new JLabel("Final Grade");
		lblFinalGrade.setBounds(902,430,150,18);
		lblFinalGrade.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblFinalGrade.setForeground(Color.WHITE);
		lblFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblFinalGrade);
		
		txtFinalGrade = new JTextField();
		txtFinalGrade.setBounds(1009,426,68,28);
		txtFinalGrade.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		txtFinalGrade.setForeground(textfieldGray);
		txtFinalGrade.setHorizontalAlignment(JTextField.RIGHT);
		txtFinalGrade.setEditable(false);
		txtFinalGrade.setName("Final Grade");
		txtFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtFinalGrade);
		
		lblFinalTransmuted = new JLabel("Transmuted Final Grade");
		lblFinalTransmuted.setBounds(789,470,300,18);
		lblFinalTransmuted.setFont(gothamBook.deriveFont(Font.PLAIN,18));
		lblFinalTransmuted.setForeground(Color.WHITE);
		lblFinalTransmuted.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(lblFinalTransmuted);
		
		txtFinalTransmuted = new JTextField();
		txtFinalTransmuted.setBounds(1009,466,68,28);
		txtFinalTransmuted.setFont(gothamBookBold.deriveFont(Font.PLAIN,22));
		txtFinalTransmuted.setForeground(textfieldGray);
		txtFinalTransmuted.setHorizontalAlignment(JTextField.RIGHT);
		txtFinalTransmuted.setEditable(false);
		txtFinalTransmuted.setName("Transmuted Final Grade");
		txtFinalTransmuted.setBorder(BorderFactory.createEmptyBorder());
		gradeForm.add(txtFinalTransmuted);
		
		JPanel line = new JPanel();
		line.setBounds(672,516,405,1);
		line.setBackground(Color.WHITE);
		gradeForm.add(line);
		
		lblTransmutedTitle = new JLabel("Transmuted");
		lblTransmutedTitle.setBounds(672, 513, 300, 56);
		lblTransmutedTitle.setFont(gothamLight.deriveFont(Font.PLAIN,21));
		lblTransmutedTitle.setForeground(Color.WHITE);
		gradeForm.add(lblTransmutedTitle);
		
		lblSubjectGradeTitle = new JLabel("Subject Grade");
		lblSubjectGradeTitle.setBounds(672, 538, 300, 56);
		lblSubjectGradeTitle.setFont(gothamLight.deriveFont(Font.PLAIN,21));
		lblSubjectGradeTitle.setForeground(Color.WHITE);
		gradeForm.add(lblSubjectGradeTitle);
		
		lblSubjectGrade = new SubjectGrade();
		lblSubjectGrade.setBounds(829, 530, 300, 56);
		lblSubjectGrade.setFont(gothamBook.deriveFont(Font.PLAIN,56));
		lblSubjectGrade.setName("Subject Grade");
		lblSubjectGrade.setForeground(Color.WHITE);
		gradeForm.add(lblSubjectGrade);
		
		bBack = new JButton("< Back to Course List");
		bBack.setBounds(15, 630, 215, 18);
		bBack.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bBack.setOpaque(false);
		bBack.setContentAreaFilled(false);
		bBack.setBorderPainted(false);
		bBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bBack.setForeground(hyperColor);
		gradeForm.add(bBack);
		
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursePicker cP = new CoursePicker();
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to go back?",mainContainer,gradeForm,cP,"Cancel","Continue	",paneRed);
			}
		});
		
		bClear = new JButton("Clear");
		bClear.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bClear.setBounds(374, 610, 171, 46);
		bClear.setBackground(Color.WHITE);
		bClear.setBorder(BorderFactory.createEmptyBorder());
		bClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bClear.setForeground(Color.BLACK);
		gradeForm.add(bClear);
		
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to clear the forms?",gradeForm,"Cancel","Continue	",paneRed);
			}
		});
		
		bDisplay = new JButton("Display");
		bDisplay.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bDisplay.setBounds(555, 610, 171, 46);
		bDisplay.setBackground(Color.WHITE);
		bDisplay.setBorder(BorderFactory.createEmptyBorder());
		bDisplay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bDisplay.setForeground(Color.BLACK);
		gradeForm.add(bDisplay);
		
		bDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JTextField[] allTF = {txtName, txtStudentNo, txtSection, txtLabExer1, txtLabExer2, txtLabExer3, txtLongTest1, txtLongTest2,txtPrelimExams, txtLabExer4, txtLongTest3, txtFinalExams};
				JTextField[] scoreTF = {txtLabExer1, txtLabExer2, txtLabExer3, txtLongTest1, txtLongTest2,txtPrelimExams, txtLabExer4, txtLongTest3, txtFinalExams};
				JTextField[] studentDetailsTF = {txtName, txtStudentNo, txtSection};
				JTextField[] strTF = {txtName, txtSection};
				JTextField[] numTF = {txtStudentNo, txtLabExer1, txtLabExer2, txtLabExer3, txtLongTest1, txtLongTest2, txtPrelimExams, txtLabExer4, txtLongTest3, txtFinalExams};
				JTextField[] all100TF = {txtLabExer1, txtLabExer2, txtLabExer3,txtPrelimExams, txtLabExer4, txtFinalExams};
				JTextField[] all50TF = {txtLongTest1, txtLongTest2, txtLongTest3};
				
				try {
					for(int i = 0; i<scoreTF.length;i++) {
						if(!scoreTF[i].getText().isBlank()){
							continue;
						}
						else {
							scoreTF[i].setText("0");
						}
					}
					
					for(int i = 0; i<studentDetailsTF.length;i++) {
						if(!studentDetailsTF[i].getText().isBlank()){
							continue;
						}
						else {
						  throw new BlankTextFieldException(studentDetailsTF[i].getName(),gradeForm);
						}
					}
					
					for(int i = 0; i<strTF.length;i++) {
						if(!isNumeric(strTF[i].getText())){
							continue;
						}
						else {
						  throw new NumericsInStringException(strTF[i].getName(),gradeForm);
						}
					}
					
					for(int i = 0; i<numTF.length;i++) {
						if(isNumeric(numTF[i].getText())){
							continue;
						}
						else {
							throw new StringInNumericsException(numTF[i].getName(),gradeForm);
						}
					}
					
					for(int i = 0; i<all100TF.length;i++) {
						if(Integer.parseInt(all100TF[i].getText())>=0 && Integer.parseInt(all100TF[i].getText())<=100){
							continue;
						}
						else {
						  throw new ScoreOverloadException("Cannot Compute!",all100TF[i].getName(),100,gradeForm);
						}
					}
					
					for(int i = 0; i<all50TF.length;i++) {
						if(Integer.parseInt(all50TF[i].getText())>=0 && Integer.parseInt(all50TF[i].getText())<=50){
							continue;
						}
						else {
						  throw new ScoreOverloadException("Cannot Compute!",all50TF[i].getName(),50,gradeForm);
						}
					}
					
					comProg = new ICS2606();
	
						comProg.labExerPrelims(Integer.parseInt(txtLabExer1.getText()), Integer.parseInt(txtLabExer2.getText()), Integer.parseInt(txtLabExer3.getText()));
						comProg.longTestPrelims(Integer.parseInt(txtLongTest1.getText()), Integer.parseInt(txtLongTest2.getText()));
						comProg.examPrelims(Integer.parseInt(txtPrelimExams.getText()));
						txtPrelimGrade.setText(comProg.prelimGrade()+"");
						txtPrelimTransmuted.setText(comProg.transmutedPrelim()+"");
								
						comProg.labExerFinals(Integer.parseInt(txtLabExer4.getText()));
						comProg.longTestFinals(Integer.parseInt(txtLongTest3.getText()));
						comProg.examFinals(Integer.parseInt(txtFinalExams.getText()));
						txtFinalGrade.setText(comProg.finalGrade()+"");
						txtFinalTransmuted.setText(comProg.transmutedFinal()+"");
								
						lblSubjectGrade.setText(comProg.subjectGrade()+"");
						
						CustomDialog cd = new CustomDialog("Success!", "Your GWA is: " + comProg.gwa(Double.parseDouble(lblSubjectGrade.getText())),gradeForm,"OK",paneGreen);
				}
				 catch(BlankTextFieldException btfe) {	
				}catch(NumericsInStringException nse) {
				}catch(StringInNumericsException sin) {
				}catch(ScoreOverloadException soe) {
				}
			}
		});
		
		bSave = new JButton("Save to Sheet");
		bSave.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bSave.setBounds(736, 610, 171, 46);
		bSave.setBackground(Color.WHITE);
		bSave.setBorder(BorderFactory.createEmptyBorder());
		bSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bSave.setForeground(Color.BLACK);
		
		gradeForm.add(bSave);
		// save listener
				bSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JTextField[] allTF = {txtName, txtStudentNo, txtSection, txtLabExer1, txtLabExer2, txtLabExer3, txtLongTest1, txtLongTest2,txtPrelimExams, txtLabExer4, txtLongTest3, txtFinalExams, txtPrelimGrade, txtPrelimTransmuted, txtFinalGrade,txtFinalTransmuted};
						JTextField[] strTF = {txtName, txtSection};
						JTextField[] numTF = {txtStudentNo, txtLabExer1, txtLabExer2, txtLabExer3, txtLongTest1, txtLongTest2, txtPrelimExams, txtLabExer4, txtLongTest3, txtFinalExams};
						JTextField[] all100TF = {txtLabExer1, txtLabExer2, txtLabExer3,txtPrelimExams, txtLabExer4, txtFinalExams};
						JTextField[] all50TF = {txtLongTest1, txtLongTest2, txtLongTest3};
						
						try {
							for(int i = 0; i<allTF.length;i++) {
								if(!allTF[i].getText().isBlank()){
									continue;
								}
								else {
									throw new BlankTextFieldException(allTF[i].getName()+". Please click Display again.",gradeForm);
								}
							}
							
							for(int i = 0; i<strTF.length;i++) {
								if(!isNumeric(strTF[i].getText())){
									continue;
								}
								else {
								  throw new NumericsInStringException(strTF[i].getName(),gradeForm);
								}
							}
							
							for(int i = 0; i<numTF.length;i++) {
								if(isNumeric(numTF[i].getText())){
									continue;
								}
								else {
									throw new StringInNumericsException(numTF[i].getName(),gradeForm);
								}
							}
							
							for(int i = 0; i<all100TF.length;i++) {
								if(Integer.parseInt(all100TF[i].getText())>=0 && Integer.parseInt(all100TF[i].getText())<=100){
									continue;
								}
								else {
								  throw new ScoreOverloadException("Cannot Compute!",all100TF[i].getName(),100,gradeForm);
								}
							}
							
							for(int i = 0; i<all50TF.length;i++) {
								if(Integer.parseInt(all50TF[i].getText())>=0 && Integer.parseInt(all50TF[i].getText())<=50){
									continue;
								}
								else {
								  throw new ScoreOverloadException("Cannot Compute!",all50TF[i].getName(),50,gradeForm);
								}
							}
							
						} catch (Exception exc) {
							return ; // terminate actionPerformed method
						}
						
						
						File comProgSheet = new File("ICS2606 Sheet.csv");
						PrintWriter pw = null;
						BufferedReader br = null;
						
						try {
							pw = new PrintWriter(new FileWriter(comProgSheet, true));
							br = new BufferedReader(new FileReader(comProgSheet));
							
							if (br.readLine() == null)
								pw.println("Name,Student Number,Section,GWA,PRELIMS,Prelim Grade,Transmuted Prelim Grade,Prelims Lab Exercise,Prelims Long Test,Prelims Exam,FINALS,Final Grade,Transmuted Final Grade,Finals Lab Exercise,Finals Long Test,Finals Exam");
							
							pw.println(txtName.getText() + "," + txtStudentNo.getText() + "," + txtSection.getText() + "," + comProg.gwa(Double.parseDouble(lblSubjectGrade.getText())) + "," + "  " + "," + comProg.getPrelimGrade() + "," + comProg.getTransmutedPrelim() + "," + comProg.getLabExerPrelims() + ","  + comProg.getLongTestPrelims() +
									"," + comProg.getExamPrelims() + "," + "  " + "," + comProg.getFinalGrade()+ "," + comProg.transmutedFinal() + "," + comProg.getLabExerFinals() + "," + comProg.getLongTestFinals() + "," + comProg.getExamFinals());
							pw.close();
							
							CustomDialog cd = new CustomDialog("Success!", "Info saved to sheet.",gradeForm,"OK",paneGreen);
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
		add(mainContainer);
		setVisible(true);
	}
}
