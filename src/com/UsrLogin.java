package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsrLogin extends JPanel{
	
	JPanel usrLoginPanel;
	JLabel lPfp;
	Icon icnPfp;
	JLabel lLoginTtl;
	JTextField tfUser;
	JPasswordField tfPswrd;
	JButton bLogin;
	JButton bCrtUser;
	
	Font tahomaPlain16 = new Font("Tahoma", Font.PLAIN, 16);
	Font tahomaBold16 = new Font("Tahoma", Font.BOLD, 16);
	Font tahomaPlain12 = new Font("Tahoma", Font.PLAIN, 12);
	Font tahomaBold12 = new Font("Tahoma", Font.BOLD, 12);

	public UsrLogin() {
		
//		usrLoginPanel.setOpaque(false);
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		lPfp = new JLabel();
		icnPfp = new ImageIcon("profile.png");
		lPfp.setIcon(icnPfp);
		lPfp.setBounds(564, 187, 150, 150);
		add(lPfp);
		
		lLoginTtl = new JLabel("LOGIN TO YOUR ACCOUNT");
		lLoginTtl.setFont(tahomaBold16);
		lLoginTtl.setBounds(533, 88, 220, 15);
		lLoginTtl.setForeground(Color.BLACK);
		add(lLoginTtl);
		
		tfUser = new JTextField("Username");
		tfUser.setBounds(467, 363, 346, 50);
		tfUser.setFont(tahomaPlain16);
		tfUser.setHorizontalAlignment(JTextField.CENTER);
		tfUser.setForeground(Color.BLACK);
		tfUser.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        tfUser.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (tfUser.getText().isBlank())
		        	tfUser.setText("Username");
		    }
		});
		add(tfUser);
		
		tfPswrd = new JPasswordField("Password");
		tfPswrd.setBounds(467, 423, 346, 50);
		tfPswrd.setFont(tahomaPlain16);
		tfPswrd.setHorizontalAlignment(JTextField.CENTER);
		tfPswrd.setForeground(Color.BLACK);
		tfPswrd.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	tfPswrd.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (tfPswrd.getText().isBlank())
		        	tfPswrd.setText("Password");
		    }
		});
		add(tfPswrd);
		
		bLogin = new JButton("LOGIN");
		bLogin.setFont(tahomaBold16);
		bLogin.setBounds(467, 483, 346, 50);
		bLogin.setBackground(Color.darkGray);
		bLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogin.setForeground(Color.white);
		add(bLogin);
		
		bCrtUser = new JButton("Create new user");
		bCrtUser.setBounds(575, 543, 130, 15);
		bCrtUser.setFont(tahomaPlain12);
		bCrtUser.setOpaque(false);
		bCrtUser.setContentAreaFilled(false);
		bCrtUser.setBorderPainted(false);
		bCrtUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tfUser.setForeground(Color.BLACK);
		add(bCrtUser);
		
		setVisible(true);
	}
}
