package com.main;

import javax.swing.*;

import com.gui.UsrLogin;
import com.gui.guiCustoms;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GwaCalc extends JFrame{
	//variables
	private UsrLogin usrlog;
	public GwaCalc(){
				
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("res\\gwabig.png");
		setIconImage(img.getImage());
		
		usrlog = new UsrLogin();
		setContentPane(usrlog);
		repaint();
		revalidate();
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		GwaCalc gwa = new GwaCalc();
		
		
	}
}
