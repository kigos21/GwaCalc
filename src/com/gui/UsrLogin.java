package com.gui;

import com.user.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class UsrLogin extends guiCustoms{
	
	JPanel usrLogin;
	JLabel lLogo,lUser,lPswrd,lTitle;
	Icon icnPfp;
	JLabel lLoginTtl;
	JTextField tfUser;
	JPasswordField tfPswrd;
	JButton bLogin;
	JButton bCrtUser;
	Font gothamBook,gothamBookBold;
	
	public UsrLogin() {
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
		
		usrLogin = new JPanel();
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		usrLogin.setPreferredSize(new Dimension(1280, 720));
		usrLogin.setBackground(bgColor);
		usrLogin.setBounds(0, 0, 1280, 720);
		usrLogin.setLayout(null);
		
	
		lLogo = new JLabel();
		icnPfp = new ImageIcon("res\\gwalogo2.png");
		lLogo.setIcon(icnPfp);
		lLogo.setBounds(462, 118, 358, 180);
		usrLogin.add(lLogo);
		
		lLoginTtl = new JLabel("LOGIN TO YOUR ACCOUNT");
		lLoginTtl.setFont(gothamBookBold.deriveFont(Font.PLAIN, 13f));
		lLoginTtl.setBounds(557, 332, 190, 13);
		lLoginTtl.setForeground(Color.WHITE);
		usrLogin.add(lLoginTtl);
		
		tfUser = new JTextField("Username");
		tfUser.setBounds(456, 392, 371, 47);
		tfUser.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfUser.setHorizontalAlignment(JTextField.CENTER);
		tfUser.setForeground(textfieldGray);
		tfUser.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        tfUser.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (tfUser.getText().isBlank())
		        	tfUser.setText("Username");
		    }
		});
		usrLogin.add(tfUser);
		
		lUser = new JLabel("USERNAME");
		lUser.setBounds(456, 372, 100, 13);
		lUser.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lUser.setHorizontalAlignment(JTextField.CENTER);
		lUser.setForeground(Color.WHITE);
		usrLogin.add(lUser);
		
		tfPswrd = new JPasswordField("Password");
		tfPswrd.setBounds(456, 464, 371, 47);
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
		usrLogin.add(tfPswrd);
		
		
		lPswrd = new JLabel("PASSWORD");
		lPswrd.setBounds(456, 447, 100, 13);
		lPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lPswrd.setHorizontalAlignment(JTextField.CENTER);
		lPswrd.setForeground(Color.WHITE);
		usrLogin.add(lPswrd);
		
		bLogin = new JButton("Sign In");
		bLogin.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bLogin.setBounds(591, 527, 100, 46);
		bLogin.setBackground(Color.WHITE);
		bLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bLogin.setForeground(Color.BLACK);
		usrLogin.add(bLogin);
		
		bCrtUser = new JButton("Create Account");
		bCrtUser.setBounds(566, 589, 150, 13);
		bCrtUser.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		bCrtUser.setOpaque(false);
		bCrtUser.setContentAreaFilled(false);
		bCrtUser.setBorderPainted(false);
		bCrtUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bCrtUser.setForeground(hyperColor);
		usrLogin.add(bCrtUser);
		
		// first focus
		usrLogin.setFocusable(true);
		usrLogin.requestFocus();
		
		add(usrLogin);
		setVisible(true);
		
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File loginCreds = null;
				BufferedReader br = null;
				
				try {
					loginCreds = new File("data\\usr-login-creds.txt");
					br = new BufferedReader(new FileReader(loginCreds));
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					if (br.readLine() == null) {
						CustomDialog cd = new CustomDialog("No user found!", "Please create an account.", usrLogin,"OK", paneRed);
						//JOptionPane.showMessageDialog(null, "No user found! Please create an account.", "Error", JOptionPane.ERROR_MESSAGE);
						bCrtUser.requestFocus();
					}
					else {
						
						br.close();
						br = new BufferedReader(new FileReader(loginCreds)); // cheap alternative
						UserStudent user = new UserStudent(br.readLine(), br.readLine());
						if (tfUser.getText().equals(user.getUsername()) && tfPswrd.getText().equals(user.getPassword())) {
							CoursePicker cp = new CoursePicker();
				            cp.setPreferredSize(new Dimension(1280, 720));
				            cp.setBounds(0, 0, 1280, 720);
			            
				            usrLogin.setVisible(false);
				            add(cp);
				            cp.setVisible(true);
						}
						else {
							CustomDialog cd = new CustomDialog("Incorrect Info!", "Incorrect details. Try again.", usrLogin,"OK", paneRed);
						}
					}
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		bCrtUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call the user creation panel
				UsrCreate usrCreate = new UsrCreate();
				usrCreate.setPreferredSize(new Dimension(1280, 720));
				usrCreate.setBounds(0, 0, 1280, 720);
				
				usrLogin.setVisible(false);
				add(usrCreate);
				usrCreate.setVisible(true);
			}
		});
	}
	
}
