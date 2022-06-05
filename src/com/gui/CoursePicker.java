package com.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import com.user.*;

public class CoursePicker extends guiCustoms {
	
	// declare the variables to be used in the class
	JPanel mainContainer, coursePicker;
	JComboBox cbCoursePicker;
	JButton bNext,bLogout;
	Font gothamBook,gothamBookBold,futura,gothamLight;
	Icon icnPfp;
	JLabel lSelect,lProfilePic,lStudentName,lDepartment;
	String[] cbOptions = {"    Choose your course","  ICS2606","  IT2622"};
	
	public CoursePicker() {
		
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
		
		// instantiate profile icon
		lProfilePic = new JLabel();
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/pfp-icon.png"));
			icnPfp = new ImageIcon(myImage);
			lProfilePic.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lProfilePic.setBounds(48, 30, 80, 80);
		coursePicker.add(lProfilePic);
		
		// put username beside the image icon
		lStudentName = new JLabel(UsrLogin.user.getUsername());
		lStudentName.setBounds(145, 57, 500, 28);
		lStudentName.setFont(futura.deriveFont(Font.PLAIN,28));
		lStudentName.setForeground(userFontGray);
		coursePicker.add(lStudentName);
		
		// build the rest of the UI
		lDepartment = new JLabel("UNIVERSITY OF SANTO TOMAS");
		lDepartment.setBounds(145, 83, 500, 18);
		lDepartment.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		lDepartment.setForeground(userFontGray);
		coursePicker.add(lDepartment);
		
		bLogout = new JButton("Logout");
		bLogout.setFont(gothamLight.deriveFont(Font.PLAIN,24));
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
		// end of UI building
		
		// add to main panel and set as visible
		add(mainContainer);
		setVisible(true);
		
		// logout button listener
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				CustomDialog cd = new CustomDialog("Log Out","Are you sure you want to logout?",mainContainer,coursePicker,usrLogin,"Cancel","Logout",paneRed);
			}
		});
		
		// next button listener
		bNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// store the selected course to a variable
				String courseChosen = cbCoursePicker.getSelectedItem().toString().trim();
				
				// determine the course and call the corresponding class
				if(courseChosen.equals("ICS2606")) {
					ICS2606Form gradeForm = new ICS2606Form();
					gradeForm.setPreferredSize(new Dimension(1280, 720));
					gradeForm.setBounds(0, 0, 1280, 720);
					
					mainContainer.add(gradeForm);
					coursePicker.setVisible(false);
					gradeForm.setVisible(true);
				
				} else if (courseChosen.equals("IT2622")) {
					IT2622Form gradeForm = new IT2622Form();
					gradeForm.setPreferredSize(new Dimension(1280, 720));
					gradeForm.setBounds(0, 0, 1280, 720);

					coursePicker.setVisible(false);
					mainContainer.add(gradeForm);
					gradeForm.setVisible(true);
				
				// if no course selected, throw error feedback to the user
				} else {
					CustomDialog cd = new CustomDialog("Err!", "Please choose a course", mainContainer,"OK", paneRed);
				}
			}
		});
	}
}
