package com.main;

import javax.imageio.*;
import javax.swing.*;
import com.gui.*;
import com.user.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GwaCalc extends JFrame {
	
	private UsrLogin usrlog;
	
	public GwaCalc() {
		
		/* 
		 * General Weighted Average Calculator will be a standalone java application that includes multiple 
		 * features such as user registration, automatic grade computation, a search engine, and general 
		 * weighted average generation. To execute these features, the application will utilize graphical 
		 * user interfaces, input forms, file output stream, event handlings, and exception handlings. 
		 * 
		 * Through these features, the developers will be able to develop a documentation and general weighted 
		 * average calculator for students in two specific courses. 
		 * 
		 * The objective of the program is to provide the students a program that documents and computes their 
		 * own grades in two specific courses.
		 */
		
		
		// set JFrame attributes
		setTitle("GENERAL WEIGHTED AVERAGE CALCULATOR");
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame icon
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/gwasmol.png"));
			ImageIcon img = new ImageIcon(myImage);
			setIconImage(img.getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// call the first interface or the panel of user login, add to JFrame
		usrlog = new UsrLogin();
		usrlog.setPreferredSize(new Dimension(1280, 720));
		usrlog.setBounds(0, 0, 1280, 720);
		add(usrlog);
		
		// set it to visible
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		// call the JFrame of the application
		GwaCalc gwa = new GwaCalc();
	}
}
