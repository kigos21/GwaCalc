package com.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.user.UserStudent;

public class CoursePicker extends guiCustoms{
	JPanel mainContainer, coursePicker;
	JComboBox cbCoursePicker;
	JButton bNext,bLogout;
	Font gothamBook,gothamBookBold,futura,gothamLight;
	Icon icnPfp;
	JLabel lSelect,lUST,lStudentName,lDepartment;
	String[] cbOptions = {"    Choose your course","  ICS2606","  IT2622"};
	
	public CoursePicker() {
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
		
		coursePicker = new JPanel();
		coursePicker.setOpaque(false);
		coursePicker.setPreferredSize(new Dimension(1280, 720));
		coursePicker.setBounds(0, 0, 1280, 720);
		coursePicker.setLayout(null);
		mainContainer.add(coursePicker);
		
		lUST = new JLabel();
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/pfp-icon.png"));
			icnPfp = new ImageIcon(myImage);
			lUST.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//lUST.setBounds(48, 30, 109, 110);
		lUST.setBounds(48, 30, 80, 80);
		coursePicker.add(lUST);
		
		lStudentName = new JLabel(UsrLogin.user.getUsername());

		//lStudentName.setBounds(179, 77, 500, 28);
		lStudentName.setBounds(145, 57, 500, 28);
		lStudentName.setFont(futura.deriveFont(Font.PLAIN,28));
		lStudentName.setForeground(userFontGray);
		coursePicker.add(lStudentName);
		
		lDepartment = new JLabel("UNIVERSITY OF SANTO TOMAS");
		//lDepartment.setBounds(179, 103, 500, 18);
		lDepartment.setBounds(145, 83, 500, 18);
		lDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lDepartment.setForeground(userFontGray);
		coursePicker.add(lDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,24));
		//bLogout.setBounds(1069, 60, 150, 46);
		bLogout.setBounds(1069, 55, 150, 46);
		bLogout.setOpaque(false);
		bLogout.setContentAreaFilled(false);
		bLogout.setBorderPainted(false);
		bLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogout.setForeground(Color.WHITE);
		coursePicker.add(bLogout);
		
		lSelect = new JLabel("SELECT COURSE");
		lSelect.setFont(gothamBook.deriveFont(Font.PLAIN,36));
		lSelect.setBounds(480, 250, 500, 36);
		lSelect.setForeground(Color.WHITE);
		coursePicker.add(lSelect);	
		
		cbCoursePicker = new JComboBox<>(cbOptions);
		cbCoursePicker.setBounds(373, 300, 531, 66);
		cbCoursePicker.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		cbCoursePicker.setRenderer(dlcr); 
		coursePicker.add(cbCoursePicker);
		
		bNext = new JButton("Next");
		bNext.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bNext.setBounds(590, 388, 100, 46);
		bNext.setBackground(Color.WHITE);
		bNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bNext.setForeground(Color.BLACK);
		coursePicker.add(bNext);
		
		add(mainContainer);
		setVisible(true);
		bNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseChosen = cbCoursePicker.getSelectedItem().toString().trim();
				if(courseChosen.equals("ICS2606")) {
					ICS2606Form gradeForm = new ICS2606Form();
					gradeForm.setPreferredSize(new Dimension(1280, 720));
					gradeForm.setBounds(0, 0, 1280, 720);
					
					mainContainer.add(gradeForm);
					coursePicker.setVisible(false);
					gradeForm.setVisible(true);
				}
				else if (courseChosen.equals("IT2622")) {
					IT2622Form gradeForm = new IT2622Form();
					gradeForm.setPreferredSize(new Dimension(1280, 720));
					gradeForm.setBounds(0, 0, 1280, 720);

					coursePicker.setVisible(false);
					mainContainer.add(gradeForm);
					gradeForm.setVisible(true);
				}
				else {
					CustomDialog cd = new CustomDialog("Err!", "Please choose a course", mainContainer,"OK", paneRed);
				}
			}
		});
		
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				
				//CustomDialog Constructor: headContent, messageContent, parentPane, childPane, newPane, buttonContentCancel, buttonContentConfirm, color
				CustomDialog cd = new CustomDialog("Log Out","Are you sure you want to logout?",mainContainer,coursePicker,usrLogin,"Cancel","Logout",paneRed);
			}
		});
	}
}
