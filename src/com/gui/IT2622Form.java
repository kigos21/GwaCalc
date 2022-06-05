package com.gui;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import com.gui.ICS2606Form.*;
import com.user.*;
import java.awt.event.*;

public class IT2622Form extends guiCustoms {
	
	// declare the variables
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
			lblFinalLongTest, lblLongTest2, 
			lblFinalDeliverable, lblDeliverable1, lblIntegratedAsmnt,
			lblFinalGrade, lblTransmutedFinalGrade;
	
	JTextField tfName, tfStudentNo, tfSection;
	
	ScoreTextField tfPrelimAttendance, tfPrelimRecitation,  tfFA,
			tfLongTest1, tfWireframe, tfStoryboard, tfPrototype,
			tfPrelimExam, tfPrelimGrade, tfTransmutedPrelimGrade,
			
			tfFinalAttendance, tfFinalRecitation, tfAssignment,
			tfLongTest2, tfDeliverable1, tfIntegratedAsmnt,
			tfFinalGrade, tfTransmutedFinalGrade;
	
	// textfield that has a max score attribute
	class ScoreTextField extends JTextField{
		private int maxScore;

		public int getMaxScore() {
			return maxScore;
		}

		public void setMaxScore(int maxScore) {
			this.maxScore = maxScore;
		}
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
	
	// user defined exceptions
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
	
	public IT2622Form() {	
		
		// load custom fonts
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
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(FontFormatException ffe) {
			ffe.printStackTrace();
		}
		
		// set JPanel attributes
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		// create hierarchy of JPanels
		mainContainer = new JPanel(null);
		mainContainer.setPreferredSize(new Dimension(1280, 720));
		mainContainer.setBounds(0, 0, 1280, 720);
		mainContainer.setBackground(bgColor);
		
		gradeForm = new JPanel(null);
		gradeForm.setOpaque(false);
		gradeForm.setPreferredSize(new Dimension(1280, 720));
		gradeForm.setBounds(0, 0, 1280, 720);
		mainContainer.add(gradeForm);
		
		// instantiate profile icon
		lblIconHolder = new JLabel();
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/pfp-icon.png"));
			icnPfp = new ImageIcon(myImage);
			lblIconHolder.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		
		} lblIconHolder.setBounds(48, 30, 80, 80);
		gradeForm.add(lblIconHolder);
		
		// put username beside the image icon
		lblStudentName = new JLabel(UsrLogin.user.getUsername());
		lblStudentName.setBounds(145, 57, 500, 28);
		lblStudentName.setFont(futura.deriveFont(Font.PLAIN, 28));
		lblStudentName.setForeground(userFontGray);
		gradeForm.add(lblStudentName);
		
		// build the UI
		lblDepartment = new JLabel("UNIVERSITY OF SANTO TOMAS");
		lblDepartment.setBounds(145, 83, 500, 18);
		lblDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lblDepartment.setForeground(userFontGray);
		gradeForm.add(lblDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setBounds(1069, 55, 150, 46);
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,24));
		bLogout.setOpaque(false);
		bLogout.setContentAreaFilled(false);
		bLogout.setBorderPainted(false);
		bLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogout.setForeground(Color.WHITE);
		bLogout.setFocusable(false);
		gradeForm.add(bLogout);
		
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
		tfName.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfName.setForeground(textfieldGray);
		tfName.setBorder(BorderFactory.createEmptyBorder());
		tfName.setName("Name");
		gradeForm.add(tfName);
		
		lblStudentNo = new JLabel("Student Number");
		lblStudentNo.setBounds(617,139,135,16);
		lblStudentNo.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblStudentNo.setForeground(Color.WHITE);
		gradeForm.add(lblStudentNo);
		
		tfStudentNo = new JTextField("");
		tfStudentNo.setBounds(749,138,164,18);
		tfStudentNo.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfStudentNo.setForeground(textfieldGray);
		tfStudentNo.setBorder(BorderFactory.createEmptyBorder());
		tfStudentNo.setName("Student Number");
		gradeForm.add(tfStudentNo);
		
		lblSection = new JLabel("Section");
		lblSection.setBounds(928,139,60,16);
		lblSection.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblSection.setForeground(Color.WHITE);
		gradeForm.add(lblSection);
		
		tfSection = new JTextField("");
		tfSection.setBounds(990,138,72,18);
		tfSection.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfSection.setForeground(textfieldGray);
		tfSection.setBorder(BorderFactory.createEmptyBorder());
		tfSection.setName("Section");
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
		
		lblPrelimAttendance = new JLabel("Attendance (100 pts)", JLabel.RIGHT);
		lblPrelimAttendance.setBounds(221,232,188,18);
		lblPrelimAttendance.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimAttendance.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimAttendance);
		
		tfPrelimAttendance = new ScoreTextField();
		tfPrelimAttendance.setBounds(413,232,196,18);
		tfPrelimAttendance.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfPrelimAttendance.setForeground(textfieldGray);
		tfPrelimAttendance.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimAttendance.setBorder(BorderFactory.createEmptyBorder());
		tfPrelimAttendance.setMaxScore(100);
		tfPrelimAttendance.setName("Prelim Attendance");
		gradeForm.add(tfPrelimAttendance);
		
		lblPrelimRecitation = new JLabel("Recitation (100 pts)", JLabel.RIGHT);
		lblPrelimRecitation.setBounds(221,262,188,18);
		lblPrelimRecitation.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimRecitation.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimRecitation);
		
		tfPrelimRecitation = new ScoreTextField();
		tfPrelimRecitation.setBounds(413,262,196,18);
		tfPrelimRecitation.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfPrelimRecitation.setForeground(textfieldGray);
		tfPrelimRecitation.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimRecitation.setBorder(BorderFactory.createEmptyBorder());
		tfPrelimRecitation.setMaxScore(100);
		tfPrelimRecitation.setName("Prelim Recitation");
		gradeForm.add(tfPrelimRecitation);
		
		lblFA = new JLabel("Formative Assessments (100 pts)", JLabel.RIGHT);
		lblFA.setBounds(154,291,255,18);
		lblFA.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFA.setForeground(Color.WHITE);
		gradeForm.add(lblFA);
		
		tfFA = new ScoreTextField();
		tfFA.setBounds(413,292,196,18);
		tfFA.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfFA.setForeground(textfieldGray);
		tfFA.setHorizontalAlignment(JTextField.RIGHT);
		tfFA.setBorder(BorderFactory.createEmptyBorder());
		tfFA.setMaxScore(100);
		tfFA.setName("Formative Assessments");
		gradeForm.add(tfFA);
		
		lblPrelimLongTest = new JLabel("Long Test (30%)");
		lblPrelimLongTest.setBounds(219,325,150,18);
		lblPrelimLongTest.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimLongTest.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimLongTest);
		
		lblLongTest1 = new JLabel("Long Test 1 (70 pts)", JLabel.RIGHT);
		lblLongTest1.setBounds(221,356,188,18);
		lblLongTest1.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblLongTest1.setForeground(Color.WHITE);
		gradeForm.add(lblLongTest1);
		
		tfLongTest1 = new ScoreTextField();
		tfLongTest1.setBounds(413,356,196,18);
		tfLongTest1.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfLongTest1.setForeground(textfieldGray);
		tfLongTest1.setHorizontalAlignment(JTextField.RIGHT);
		tfLongTest1.setBorder(BorderFactory.createEmptyBorder());
		tfLongTest1.setMaxScore(70);
		tfLongTest1.setName("Long Test 1");
		gradeForm.add(tfLongTest1);
		
		lblPrelimDeliverable = new JLabel("Deliverable (30%)");
		lblPrelimDeliverable.setBounds(219,386,150,18);
		lblPrelimDeliverable.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimDeliverable.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimDeliverable);
		
		lblWireframe = new JLabel("Wireframe (24 pts)", JLabel.RIGHT);
		lblWireframe.setBounds(413,395,150,18);
		lblWireframe.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblWireframe.setForeground(Color.WHITE);
		gradeForm.add(lblWireframe);
		
		tfWireframe = new ScoreTextField();
		tfWireframe.setBounds(567,395,42,18);
		tfWireframe.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfWireframe.setForeground(textfieldGray);
		tfWireframe.setHorizontalAlignment(JTextField.RIGHT);
		tfWireframe.setBorder(BorderFactory.createEmptyBorder());
		tfWireframe.setMaxScore(24);
		tfWireframe.setName("Wireframe");
		gradeForm.add(tfWireframe);
		
		lblStoryboard = new JLabel("Storyboard (40 pts)", JLabel.RIGHT);
		lblStoryboard.setBounds(190,425,158,18);
		lblStoryboard.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblStoryboard.setForeground(Color.WHITE);
		gradeForm.add(lblStoryboard);
		
		tfStoryboard = new ScoreTextField();
		tfStoryboard.setBounds(355,425,58,18);
		tfStoryboard.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfStoryboard.setForeground(textfieldGray);
		tfStoryboard.setHorizontalAlignment(JTextField.RIGHT);
		tfStoryboard.setBorder(BorderFactory.createEmptyBorder());
		tfStoryboard.setMaxScore(40);
		tfStoryboard.setName("Storyboard");
		gradeForm.add(tfStoryboard);
		
		lblPrototype = new JLabel("Prototype (32 pts)", JLabel.RIGHT);
		lblPrototype.setBounds(413,425,151,18);
		lblPrototype.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrototype.setForeground(Color.WHITE);
		gradeForm.add(lblPrototype);
		
		tfPrototype = new ScoreTextField();
		tfPrototype.setBounds(567,425,42,18);
		tfPrototype.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfPrototype.setForeground(textfieldGray);
		tfPrototype.setHorizontalAlignment(JTextField.RIGHT);
		tfPrototype.setBorder(BorderFactory.createEmptyBorder());
		tfPrototype.setMaxScore(32);
		tfPrototype.setName("Prototype");
		gradeForm.add(tfPrototype);
		
		lblPrelimExam = new JLabel("Prelim Exam (30%) (100 pts)");
		lblPrelimExam.setBounds(206,460,222,18);
		lblPrelimExam.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimExam.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimExam);
		
		tfPrelimExam = new ScoreTextField();
		tfPrelimExam.setBounds(432,461,177,18);
		tfPrelimExam.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfPrelimExam.setForeground(textfieldGray);
		tfPrelimExam.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimExam.setBorder(BorderFactory.createEmptyBorder());
		tfPrelimExam.setMaxScore(100);
		tfPrelimExam.setName("Prelim Exams");
		gradeForm.add(tfPrelimExam);
		
		lblPrelimGrade = new JLabel("Prelim Grade", JLabel.RIGHT);
		lblPrelimGrade.setBounds(324,506,200,18);
		lblPrelimGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblPrelimGrade.setForeground(Color.WHITE);
		gradeForm.add(lblPrelimGrade);
		
		tfPrelimGrade = new ScoreTextField();
		tfPrelimGrade.setBounds(541,501,68,28);
		tfPrelimGrade.setFont(gothamBookBold.deriveFont(Font.BOLD,20));
		tfPrelimGrade.setForeground(textfieldGray);
		tfPrelimGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfPrelimGrade.setEditable(false);
		tfPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		tfPrelimExam.setMaxScore(100);
		tfPrelimExam.setName("Prelim Grade");
		gradeForm.add(tfPrelimGrade);
		
		lblTransmutedPrelimGrade = new JLabel("Transmuted Prelim Grade", JLabel.RIGHT);
		lblTransmutedPrelimGrade.setBounds(324,544,200,18);
		lblTransmutedPrelimGrade.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblTransmutedPrelimGrade.setForeground(Color.WHITE);
		gradeForm.add(lblTransmutedPrelimGrade);
		
		tfTransmutedPrelimGrade = new ScoreTextField();
		tfTransmutedPrelimGrade.setBounds(541,539,68,28);
		tfTransmutedPrelimGrade.setFont(gothamBookBold.deriveFont(Font.BOLD,20));
		tfTransmutedPrelimGrade.setForeground(textfieldGray);
		tfTransmutedPrelimGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfTransmutedPrelimGrade.setEditable(false);
		tfTransmutedPrelimGrade.setBorder(BorderFactory.createEmptyBorder());
		tfTransmutedPrelimGrade.setMaxScore(100);
		tfTransmutedPrelimGrade.setName("Transmuted Prelim Grade");
		gradeForm.add(tfTransmutedPrelimGrade);
		
		// FINALS
		lblFinalClassStanding = new JLabel("Class Standing (10%)");
		lblFinalClassStanding.setBounds(672,201,164,18);
		lblFinalClassStanding.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalClassStanding.setForeground(Color.WHITE);
		gradeForm.add(lblFinalClassStanding);
		
		lblFinalAttendance = new JLabel("Attendance (100 pts)", JLabel.RIGHT);
		lblFinalAttendance.setBounds(674,232,188,18);
		lblFinalAttendance.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalAttendance.setForeground(Color.WHITE);
		gradeForm.add(lblFinalAttendance);
		
		lblFinalRecitation = new JLabel("Recitation (100 pts)", JLabel.RIGHT);
		lblFinalRecitation.setBounds(674,262,188,18);
		lblFinalRecitation.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalRecitation.setForeground(Color.WHITE);
		gradeForm.add(lblFinalRecitation);
		
		lblAssignment = new JLabel("Assignment (100 pts)", JLabel.RIGHT);
		lblAssignment.setBounds(674,291,188,18);
		lblAssignment.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblAssignment.setForeground(Color.WHITE);
		gradeForm.add(lblAssignment);
		
		tfFinalAttendance = new ScoreTextField();
		tfFinalAttendance.setBounds(866,232,196,18);
		tfFinalAttendance.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfFinalAttendance.setForeground(textfieldGray);
		tfFinalAttendance.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalAttendance.setBorder(BorderFactory.createEmptyBorder());
		tfFinalAttendance.setMaxScore(100);
		tfFinalAttendance.setName("Finals Attendance");
		gradeForm.add(tfFinalAttendance);
		
		tfFinalRecitation = new ScoreTextField();
		tfFinalRecitation.setBounds(866,262,196,18);
		tfFinalRecitation.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfFinalRecitation.setForeground(textfieldGray);
		tfFinalRecitation.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalRecitation.setBorder(BorderFactory.createEmptyBorder());
		tfFinalRecitation.setMaxScore(100);
		tfFinalRecitation.setName("Finals Recitation");
		gradeForm.add(tfFinalRecitation);
		
		tfAssignment = new ScoreTextField();
		tfAssignment.setBounds(866,292,196,18);
		tfAssignment.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfAssignment.setForeground(textfieldGray);
		tfAssignment.setHorizontalAlignment(JTextField.RIGHT);
		tfAssignment.setBorder(BorderFactory.createEmptyBorder());
		tfAssignment.setMaxScore(100);
		tfAssignment.setName("Finals Assignments");
		gradeForm.add(tfAssignment);
		
		lblFinalLongTest = new JLabel("Long Test (30%)");
		lblFinalLongTest.setBounds(672,325,150,18);
		lblFinalLongTest.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalLongTest.setForeground(Color.WHITE);
		gradeForm.add(lblFinalLongTest);
		
		lblLongTest2 = new JLabel("Long Test 2 (105 pts)", JLabel.RIGHT);
		lblLongTest2.setBounds(674,356,189,18);
		lblLongTest2.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblLongTest2.setForeground(Color.WHITE);
		gradeForm.add(lblLongTest2);
		
		tfLongTest2 = new ScoreTextField();
		tfLongTest2.setBounds(866,356,196,18);
		tfLongTest2.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfLongTest2.setForeground(textfieldGray);
		tfLongTest2.setHorizontalAlignment(JTextField.RIGHT);
		tfLongTest2.setBorder(BorderFactory.createEmptyBorder());
		tfLongTest2.setMaxScore(105);
		tfLongTest2.setName("Long Test 2");
		gradeForm.add(tfLongTest2);
		
		lblFinalDeliverable = new JLabel("Deliverable (30%)");
		lblFinalDeliverable.setBounds(672,386,150,18);
		lblFinalDeliverable.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblFinalDeliverable.setForeground(Color.WHITE);
		gradeForm.add(lblFinalDeliverable);
		
		lblDeliverable1 = new JLabel("Deliverable 1 (100 pts)", JLabel.RIGHT);
		lblDeliverable1.setBounds(674,416,188,18);
		lblDeliverable1.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblDeliverable1.setForeground(Color.WHITE);
		gradeForm.add(lblDeliverable1);
		
		tfDeliverable1 = new ScoreTextField();
		tfDeliverable1.setBounds(866,416,196,18);
		tfDeliverable1.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfDeliverable1.setForeground(textfieldGray);
		tfDeliverable1.setHorizontalAlignment(JTextField.RIGHT);
		tfDeliverable1.setBorder(BorderFactory.createEmptyBorder());
		tfDeliverable1.setMaxScore(100);
		tfDeliverable1.setName("Deliverable 1");
		gradeForm.add(tfDeliverable1);
		
		lblIntegratedAsmnt = new JLabel("Integrated Asmnt. (30%) (100 pts)");
		lblIntegratedAsmnt.setBounds(659,460,269,18);
		lblIntegratedAsmnt.setFont(gothamBook.deriveFont(Font.PLAIN, 15));
		lblIntegratedAsmnt.setForeground(Color.WHITE);
		gradeForm.add(lblIntegratedAsmnt);
		
		tfIntegratedAsmnt = new ScoreTextField();
		tfIntegratedAsmnt.setBounds(930,461,132,18);
		tfIntegratedAsmnt.setFont(gothamBookBold.deriveFont(Font.PLAIN,15));
		tfIntegratedAsmnt.setForeground(textfieldGray);
		tfIntegratedAsmnt.setHorizontalAlignment(JTextField.RIGHT);
		tfIntegratedAsmnt.setBorder(BorderFactory.createEmptyBorder());
		tfIntegratedAsmnt.setMaxScore(100);
		tfIntegratedAsmnt.setName("Integrated Assessment");
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
		
		tfFinalGrade = new ScoreTextField();
		tfFinalGrade.setBounds(994,501,68,28);
		tfFinalGrade.setFont(gothamBookBold.deriveFont(Font.BOLD,20));
		tfFinalGrade.setForeground(textfieldGray);
		tfFinalGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfFinalGrade.setEditable(false);
		tfFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		tfFinalGrade.setMaxScore(100);
		tfFinalGrade.setName("Final Grade");
		gradeForm.add(tfFinalGrade);
		
		tfTransmutedFinalGrade = new ScoreTextField();
		tfTransmutedFinalGrade.setBounds(994,539,68,28);
		tfTransmutedFinalGrade.setFont(gothamBookBold.deriveFont(Font.BOLD,20));
		tfTransmutedFinalGrade.setForeground(textfieldGray);
		tfTransmutedFinalGrade.setHorizontalAlignment(JTextField.RIGHT);
		tfTransmutedFinalGrade.setEditable(false);
		tfTransmutedFinalGrade.setBorder(BorderFactory.createEmptyBorder());
		tfTransmutedFinalGrade.setMaxScore(100);
		tfTransmutedFinalGrade.setName("Transmuted Final Grade");
		gradeForm.add(tfTransmutedFinalGrade);
		
		bClear = new JButton("Clear");
		bClear.setBounds(374, 610, 171, 46);
		bClear.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bClear.setBackground(Color.WHITE);
		bClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bClear.setForeground(Color.BLACK);
		gradeForm.add(bClear);
		
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
		gradeForm.add(bBack);
		// end of UI building
		
		// add to main JPanel
		gradeForm.setVisible(true);
		mainContainer.add(gradeForm);
		mainContainer.setVisible(true);
		
		// add and set to visible
		add(mainContainer);
		setVisible(true);
		
		// logout button listener
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				CustomDialog cd = new CustomDialog("Log Out","Are you sure you want to logout?",mainContainer,gradeForm,usrLogin,"Cancel","Logout",paneRed);
				cd.setVisible(true);
			}
		});
		
		// back button listener
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursePicker cP = new CoursePicker();
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to go back?",mainContainer,gradeForm,cP,"Cancel","Continue	",paneRed);
			}
		});
		
		// clear listener
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDialog cd = new CustomDialog("Changes will be discarded","Are you sure you want to clear the forms?",gradeForm,"Cancel","Continue	",paneRed);
			}
		});
		
		// display listener
		bDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IT2622 hci = new IT2622();
				
				// arrays to check if inputs are proper for respective fields
				JTextField[] allTF = {tfName, tfSection, tfStudentNo, tfPrelimAttendance, tfPrelimRecitation, tfFA, tfLongTest1, tfWireframe, tfStoryboard, tfPrototype, tfPrelimExam, tfFinalAttendance, tfFinalRecitation, tfAssignment, tfLongTest2, tfDeliverable1, tfIntegratedAsmnt};
				ScoreTextField[] prelimTF = {tfPrelimAttendance, tfPrelimRecitation, tfFA,tfLongTest1, tfWireframe, tfStoryboard,tfPrototype,tfPrelimExam};
				ScoreTextField[] finalTF = {tfFinalAttendance, tfFinalRecitation, tfAssignment,tfLongTest2,tfDeliverable1,tfIntegratedAsmnt};
				ScoreTextField[] scoreTF = {tfPrelimAttendance, tfPrelimRecitation, tfFA,tfLongTest1, tfWireframe, tfStoryboard,tfPrototype,tfPrelimExam,tfFinalAttendance, tfFinalRecitation, tfAssignment,tfLongTest2,tfDeliverable1,tfIntegratedAsmnt};
				JTextField[] studentDetailsTF = {tfName, tfStudentNo, tfSection};
				JTextField[] strTF = {tfName, tfSection};
				JTextField[] numTF = {tfStudentNo, tfPrelimAttendance, tfPrelimRecitation, tfFA, tfLongTest1, tfWireframe, tfStoryboard, tfPrototype, tfPrelimExam, tfFinalAttendance, tfFinalRecitation, tfAssignment, tfLongTest2, tfDeliverable1, tfIntegratedAsmnt};
				
				try {
					
					// if no grade has been input in textfields, set text to 0
					for (int i = 0; i < scoreTF.length; i++) {
						if (!scoreTF[i].getText().isBlank())
							continue;
						else
							scoreTF[i].setText("0");
					}
					
					// throws feedback pane if [name, student number, section] is/are blank
					for (int i = 0; i < studentDetailsTF.length; i++) {
						if (!studentDetailsTF[i].getText().isBlank())
							continue;
						else 
							throw new BlankTextFieldException(studentDetailsTF[i].getName(),gradeForm);
					}
					
					// checks whether name and section are valid strings
					for (int i = 0; i < strTF.length; i++) {
						if (!isNumeric(strTF[i].getText()))
							continue;
						else
							throw new NumericsInStringException(strTF[i].getName(),gradeForm);
					}
					
					// checks whether score textfields contain numerals only
					for (int i = 0; i < numTF.length; i++) {
						if (isNumeric(numTF[i].getText()))
							continue;
						else
							throw new StringInNumericsException(numTF[i].getName(),gradeForm);
					}
					
					// checks if input do not exceed respective max scores
					for (int i = 0; i < scoreTF.length; i++) { 
						if (Double.parseDouble(scoreTF[i].getText()) >= 0 && Double.parseDouble(scoreTF[i].getText()) <= scoreTF[i].maxScore)
							continue;
						else
							throw new ScoreOverloadException("Cannot Compute!",scoreTF[i].getName(),scoreTF[i].maxScore,gradeForm);
					}
					
					// compute the grades
					// prelims
					hci.computeClassStandingPrelim(Double.parseDouble(tfPrelimAttendance.getText()), Double.parseDouble(tfPrelimRecitation.getText()), Double.parseDouble(tfFA.getText()));
					hci.computeLongTestPrelim(Double.parseDouble(tfLongTest1.getText()));
					hci.computeDeliverablePrelim(Double.parseDouble(tfWireframe.getText()), Double.parseDouble(tfStoryboard.getText()), Double.parseDouble(tfPrototype.getText()));
					hci.computeExamPrelim(Double.parseDouble(tfPrelimExam.getText()));
					tfPrelimGrade.setText(hci.computeRawPrelimGrade()+"");
					tfTransmutedPrelimGrade.setText(hci.computeTransmutedPrelimGrade()+"");
					
					// finals
					hci.computeClassStandingFinal(Double.parseDouble(tfFinalAttendance.getText()), Double.parseDouble(tfFinalRecitation.getText()), Double.parseDouble(tfAssignment.getText()));
					hci.computeLongTestFinal(Double.parseDouble(tfLongTest2.getText()));
					hci.computeDeliverableFinal(Double.parseDouble(tfDeliverable1.getText()));
					hci.computeIntegratedAssmnt(Double.parseDouble(tfIntegratedAsmnt.getText()));
					tfFinalGrade.setText(hci.computeRawFinalGrade()+"");
					tfTransmutedFinalGrade.setText(hci.computeTransmutedFinalGrade()+"");
					
					// call the feedback pane and display gwa
					CustomDialog cd = new CustomDialog("Success!", "Your GWA is: " + hci.gwaReturn(Double.parseDouble(tfTransmutedFinalGrade.getText())),gradeForm,"OK",paneGreen);
				
				} catch (Exception exc) {
					exc.printStackTrace(); // terminate actionPerformed method
				}
			}
		});
		
		// save listener
		bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// check if inputs are proper for respective fields
				JTextField[] allTF = {tfName, tfSection, tfStudentNo, tfPrelimAttendance, tfPrelimRecitation, tfFA, tfLongTest1, tfWireframe, tfStoryboard, tfPrototype, tfPrelimExam, tfFinalAttendance, tfFinalRecitation, tfAssignment, tfLongTest2, tfDeliverable1, tfIntegratedAsmnt};
				ScoreTextField[] prelimTF = {tfPrelimAttendance, tfPrelimRecitation, tfFA,tfLongTest1, tfWireframe, tfStoryboard,tfPrototype,tfPrelimExam};
				ScoreTextField[] finalTF = {tfFinalAttendance, tfFinalRecitation, tfAssignment,tfLongTest2,tfDeliverable1,tfIntegratedAsmnt};
				ScoreTextField[] scoreTF = {tfPrelimAttendance, tfPrelimRecitation, tfFA,tfLongTest1, tfWireframe, tfStoryboard,tfPrototype,tfPrelimExam,tfFinalAttendance, tfFinalRecitation, tfAssignment,tfLongTest2,tfDeliverable1,tfIntegratedAsmnt};
				JTextField[] studentDetailsTF = {tfName, tfStudentNo, tfSection};
				JTextField[] strTF = {tfName, tfSection};
				JTextField[] numTF = {tfStudentNo, tfPrelimAttendance, tfPrelimRecitation, tfFA, tfLongTest1, tfWireframe, tfStoryboard, tfPrototype, tfPrelimExam, tfFinalAttendance, tfFinalRecitation, tfAssignment, tfLongTest2, tfDeliverable1, tfIntegratedAsmnt};
				
				try {
					
					// if no grade has been input in textfields, set text to 0
					for (int i = 0; i < scoreTF.length; i++) {
						if (!scoreTF[i].getText().isBlank())
							continue;
						else
							scoreTF[i].setText("0");
					}
					
					// throws feedback pane if [name, student number, section] is/are blank
					for (int i = 0; i < studentDetailsTF.length; i++) {
						if (!studentDetailsTF[i].getText().isBlank())
							continue;
						else 
							throw new BlankTextFieldException(studentDetailsTF[i].getName(),gradeForm);
					}
					
					// checks whether name and section are valid strings
					for (int i = 0; i < strTF.length; i++) {
						if (!isNumeric(strTF[i].getText()))
							continue;
						else
							throw new NumericsInStringException(strTF[i].getName(),gradeForm);
					}
					
					// checks whether score textfields contain numerals only
					for (int i = 0; i < numTF.length; i++) {
						if (isNumeric(numTF[i].getText()))
							continue;
						else
							throw new StringInNumericsException(numTF[i].getName(),gradeForm);
					}
					
					// checks if input do not exceed respective max scores
					for (int i = 0; i < scoreTF.length; i++) { 
						if (Double.parseDouble(scoreTF[i].getText()) >= 0 && Double.parseDouble(scoreTF[i].getText()) <= scoreTF[i].maxScore)
							continue;
						else
							throw new ScoreOverloadException("Cannot Compute!",scoreTF[i].getName(),scoreTF[i].maxScore,gradeForm);
					}
					
				} catch (Exception exc) {
					exc.printStackTrace();
					return ;
				}
				
				// checks whether display button has been clicked based on whether the grade field is filled or blank
				try {
					if (tfPrelimGrade.getText().isBlank() && tfFinalGrade.getText().isBlank() && tfTransmutedPrelimGrade.getText().isBlank() && tfTransmutedFinalGrade.getText().isBlank()) {
						CustomDialog cd = new CustomDialog("Err!", "Please click the Display button first.", gradeForm, "OK", paneRed);
						throw new Exception();
					}
					
				} catch (Exception exc) {
					exc.printStackTrace();
					return ;
				}
				
				// prepare variables for writing to file
				IT2622 hci = new IT2622();
				File hciSheet = new File("IT2622 Sheet.csv");
				PrintWriter pw = null;
				BufferedReader br = null;
				
				try {
					pw = new PrintWriter(new FileWriter(hciSheet, true));
					br = new BufferedReader(new FileReader(hciSheet));
					
					// to produce header titles in the sheet file, if null, printwrite the headers
					if (br.readLine() == null)
						pw.println("Name,Student Number,Section,GWA,PRELIMS,Prelim Grade,Transmuted Prelim Grade,Attendance,Recitation,Formatives,Long Test 1,Wireframe,Storyboard,Prototype,Exam,FINALS,Final Grade,Transmuted Final Grade,Attendance,Recitation,Assignment,Long Test 2,Deliverable 1,Integrated Assmnt");
					
					// printwrite the data computed earlier
					pw.println(tfName.getText() + "," + tfStudentNo.getText() + "," + tfSection.getText() + "," +hci.gwaReturn(Double.parseDouble(tfTransmutedFinalGrade.getText()))+"," +" " + "," + tfPrelimGrade.getText() + "," + tfTransmutedPrelimGrade.getText() + "," + tfPrelimAttendance.getText() + "," + tfPrelimRecitation.getText() + "," + tfFA.getText() + "," + tfLongTest1.getText() + "," + tfWireframe.getText() + "," + tfStoryboard.getText() + 
							 "," + tfPrototype.getText() + "," + tfPrelimExam.getText() + "," + " " + "," + tfFinalGrade.getText() + "," + tfTransmutedFinalGrade.getText() + "," + tfFinalAttendance.getText() + "," + tfFinalRecitation.getText() + "," + tfAssignment.getText() + "," + tfLongTest2.getText() + "," + tfDeliverable1.getText() + "," + tfIntegratedAsmnt.getText());
					pw.close();
					
					CustomDialog cd = new CustomDialog("Success!", "Info saved to sheet.",gradeForm,"OK",paneGreen);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
