package com.gui;

import com.user.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UsrCreate extends guiCustoms {
	
	Font gothamBook, gothamBookBold;
	JPanel usrCreate;
	JLabel lLogo, lCreateTtl, lUser, lPswrd;
	JTextField tfUsrnm, tfPswrd;
	JPasswordField pfPswd;
	
	public UsrCreate() {
		try {
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBook.ttf"));
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBold.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBook); 
			ge.registerFont(gothamBookBold); 
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		usrCreate = new JPanel(null);
		usrCreate.setPreferredSize(new Dimension(1280, 720));
		usrCreate.setBackground(bgColor);
		usrCreate.setBounds(0, 0, 1280, 720);
		
		lLogo = new JLabel();
		lLogo.setIcon(new ImageIcon("res\\gwalogo2medium.png"));
		lLogo.setBounds(525, 120, 218, 113);
		usrCreate.add(lLogo);
		
		lCreateTtl = new JLabel("CREATE YOUR ACCOUNT");
		lCreateTtl.setFont(gothamBookBold.deriveFont(Font.PLAIN, 13f));
		lCreateTtl.setBounds(559, 263, 163, 15);
		lCreateTtl.setForeground(Color.WHITE);
		usrCreate.add(lCreateTtl);
		
		lUser = new JLabel("USERNAME");
		lUser.setBounds(476, 298, 81, 15);
		lUser.setFont(gothamBook.deriveFont(Font.PLAIN, 13));
		lUser.setHorizontalAlignment(JTextField.LEFT);
		lUser.setForeground(Color.WHITE);
		usrCreate.add(lUser);
		
		tfUsrnm = new JTextField("Username");
		tfUsrnm.setBounds(455, 319, 371, 47);
		tfUsrnm.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfUsrnm.setHorizontalAlignment(JTextField.CENTER);
		tfUsrnm.setForeground(textfieldGray);
		tfUsrnm.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	tfUsrnm.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (tfUsrnm.getText().isBlank())
		    		tfUsrnm.setText("Username");
		    }
		});
		usrCreate.add(tfUsrnm);
		
		lPswrd = new JLabel("PASSWORD");
		lPswrd.setBounds(476, 372, 191, 15);
		lPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lPswrd.setHorizontalAlignment(JTextField.LEFT);
		lPswrd.setForeground(Color.WHITE);
		usrCreate.add(lPswrd);
		
		tfPswrd = new JPasswordField("Password");
		tfPswrd.setBounds(455, 393, 371, 47);
		tfPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfPswrd.setHorizontalAlignment(JTextField.CENTER);
		tfPswrd.setForeground(textfieldGray);
		tfPswrd.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	tfPswrd.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (tfPswrd.getText().isBlank())
		        	tfPswrd.setText("Password");
		    }
		});
		usrCreate.add(tfPswrd);
		
//		tfCnfPswrd = new JPasswordField("Password");
//		tfPswrd.setBounds(455, 393, 371, 47);
//		tfPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,16));
//		tfPswrd.setHorizontalAlignment(JTextField.CENTER);
//		tfPswrd.setForeground(textfieldGray);
//		tfPswrd.addFocusListener(new FocusListener() {
//		    public void focusGained(FocusEvent e) {
//		    	tfPswrd.setText("");
//		    }
//
//		    public void focusLost(FocusEvent e) {
//		        if (tfPswrd.getText().isBlank())
//		        	tfPswrd.setText("Password");
//		    }
//		});
//		usrCreate.add(tfPswrd);
	}
}
