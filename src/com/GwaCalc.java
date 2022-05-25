package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GwaCalc extends JFrame{
	
	private JFrame f;
	private UsrLogin usrlog;
	
	Font tahomaPlain16 = new Font("Tahoma", Font.PLAIN, 16);
	Font tahomaBold16 = new Font("Tahoma", Font.BOLD, 16);
	Font tahomaPlain12 = new Font("Tahoma", Font.PLAIN, 12);
	Font tahomaBold12 = new Font("Tahoma", Font.BOLD, 12);
	
	// Color _ = new Color();
	
	public GwaCalc() {
		
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// to resolve auto focus on username textfield
//		inv = new JTextField("");
//		inv.requestFocus(); 
//		f.add(inv);
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
