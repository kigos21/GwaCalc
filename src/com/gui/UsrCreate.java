package com.gui;

import com.exceptions.*;
import com.user.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UsrCreate extends guiCustoms {
	
	Font gothamBook, gothamBookBold;
	JPanel usrCreate;
	JLabel lLogo, lCreateTtl, lUser, lPswrd, lCnfPswrd;
	JTextField tfUsrnm, tfPswrd;
	JPasswordField pfPswd, tfCnfPswrd;
	JButton bCreate, bBack;
	
	public UsrCreate() {
		try {	
			InputStream isgotham = getClass().getResourceAsStream("/res/fonts/GothamBook.ttf");
			InputStream isgothamBold = getClass().getResourceAsStream("/res/fonts/GothamBold.ttf");
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, isgotham);
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, isgothamBold);
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

		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		usrCreate = new JPanel();
		usrCreate.setPreferredSize(new Dimension(1280, 720));
		usrCreate.setBackground(bgColor);
		usrCreate.setBounds(0, 0, 1280, 720);
		usrCreate.setLayout(null);
		
		lLogo = new JLabel();
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/gwalogo2medium.png"));
			ImageIcon icnPfp = new ImageIcon(myImage);
			lLogo.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		lLogo.setBounds(525, 120, 218, 113);
		usrCreate.add(lLogo);
		
		lCreateTtl = new JLabel("CREATE YOUR ACCOUNT");
		lCreateTtl.setFont(gothamBookBold.deriveFont(Font.PLAIN, 13f));
		lCreateTtl.setBounds(543, 263, 191, 15);
		lCreateTtl.setHorizontalAlignment(JLabel.CENTER);
		lCreateTtl.setForeground(Color.WHITE);
		usrCreate.add(lCreateTtl);
		
		lUser = new JLabel("USERNAME");
		lUser.setBounds(467, 298, 191, 15);
		lUser.setFont(gothamBook.deriveFont(Font.PLAIN, 13));
		lUser.setHorizontalAlignment(JTextField.LEFT);
		lUser.setForeground(Color.WHITE);
		usrCreate.add(lUser);
		
		tfUsrnm = new JTextField("Username");
		tfUsrnm.setBounds(455, 319, 371, 47);
		tfUsrnm.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfUsrnm.setHorizontalAlignment(JTextField.CENTER);
		tfUsrnm.setForeground(textfieldGray);
		tfUsrnm.setBorder(BorderFactory.createEmptyBorder());
		tfUsrnm.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (tfUsrnm.getText().equals("Username"))
		    		tfUsrnm.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (tfUsrnm.getText().isBlank())
		    		tfUsrnm.setText("Username");
		    }
		});
		usrCreate.add(tfUsrnm);
		
		lPswrd = new JLabel("PASSWORD");
		lPswrd.setBounds(467, 372, 191, 15);
		lPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lPswrd.setHorizontalAlignment(JTextField.LEFT);
		lPswrd.setForeground(Color.WHITE);
		usrCreate.add(lPswrd);
		
		tfPswrd = new JPasswordField("Password");
		tfPswrd.setBounds(455, 393, 371, 47);
		tfPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfPswrd.setHorizontalAlignment(JTextField.CENTER);
		tfPswrd.setForeground(textfieldGray);
		tfPswrd.setBorder(BorderFactory.createEmptyBorder());
		tfPswrd.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (tfPswrd.getText().equals("Password"))
		    		tfPswrd.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (tfPswrd.getText().isBlank())
		        	tfPswrd.setText("Password");
		    }
		});
		usrCreate.add(tfPswrd);
		
		lCnfPswrd = new JLabel("CONFIRM PASSWORD");
		lCnfPswrd.setBounds(467, 446, 191, 15);
		lCnfPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		lCnfPswrd.setHorizontalAlignment(JTextField.LEFT);
		lCnfPswrd.setForeground(Color.WHITE);
		usrCreate.add(lCnfPswrd);
		
		tfCnfPswrd = new JPasswordField("Password");
		tfCnfPswrd.setBounds(455, 466, 371, 47);
		tfCnfPswrd.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		tfCnfPswrd.setHorizontalAlignment(JTextField.CENTER);
		tfCnfPswrd.setForeground(textfieldGray);
		tfCnfPswrd.setBorder(BorderFactory.createEmptyBorder());
		tfCnfPswrd.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (tfCnfPswrd.getText().equals("Password"))
		    		tfCnfPswrd.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (tfCnfPswrd.getText().isBlank())
		        	tfCnfPswrd.setText("Password");
		    }
		});
		usrCreate.add(tfCnfPswrd);
		
		bCreate = new JButton("Create");
		bCreate.setBounds(591, 528, 99, 47);
		bCreate.setFont(gothamBook.deriveFont(Font.PLAIN,16));
		bCreate.setBackground(Color.WHITE);
		bCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bCreate.setForeground(Color.BLACK);
		usrCreate.add(bCreate);
		
		bBack = new JButton("< Back");
		bBack.setBounds(55, 630, 80, 18);
		bBack.setFont(gothamBook.deriveFont(Font.PLAIN,13));
		bBack.setOpaque(false);
		bBack.setContentAreaFilled(false);
		bBack.setBorderPainted(false);
		bBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bBack.setForeground(hyperColor);
		usrCreate.add(bBack);
		
		// first focus
		usrCreate.setFocusable(true);
		usrCreate.requestFocus();
				
		add(usrCreate);
		setVisible(true);
		
		bCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//check if passwords match
				if ( !(tfUsrnm.getText().equals("Username")) && !(tfPswrd.getText().equals("Password"))
					&& !(tfCnfPswrd.getText().equals("Password")) && !(tfUsrnm.getText().isBlank()) 
					&& !(tfPswrd.getText().isBlank()) && !(tfCnfPswrd.getText().isBlank()) && tfPswrd.getText().equals(tfCnfPswrd.getText()) ) {
				
					try {
						File loginCreds = new File("usr-login-creds.txt");
						PrintWriter pw = new PrintWriter(new FileWriter(loginCreds, true));
						
						pw.println(tfUsrnm.getText());
						pw.println(tfPswrd.getText());
						pw.close();
						CustomDialog cd = new CustomDialog("Success!", "Account created. You can use your account to login.",usrCreate,"OK",paneGreen);
						UsrLogin usrLogin = new UsrLogin();
						usrLogin.setPreferredSize(new Dimension(1280, 720));
						usrLogin.setBounds(0, 0, 1280, 720);
						usrCreate.setVisible(false);
						add(usrLogin);
						usrLogin.setVisible(true);
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				
				} else {
					try {
						if (tfUsrnm.getText().equals("Username") || tfUsrnm.getText().isBlank())
							throw new InvalidUNameException(usrCreate, paneRed);
						
						if (tfPswrd.getText().equals("Password") || tfPswrd.getText().isBlank())
							throw new InvalidPWordException(usrCreate, paneRed);
						
						if (tfCnfPswrd.getText().equals("Password") || tfCnfPswrd.getText().isBlank())
							throw new InvalidConfirmException(usrCreate, paneRed);
						
						if (!(tfPswrd.getText().equals(tfCnfPswrd.getText())))
							throw new PasswordMismatchException(usrCreate, paneRed);
					
					} catch (InvalidUNameException iune) {
						
					} catch (InvalidPWordException ipwe) {	
						
					} catch (InvalidConfirmException icfe) {
						
					} catch (PasswordMismatchException pme) {
						
					}
				}
			}
		});
		
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsrLogin usrLogin = new UsrLogin();
				usrLogin.setPreferredSize(new Dimension(1280, 720));
				usrLogin.setBounds(0, 0, 1280, 720);
				
				usrCreate.setVisible(false);
				add(usrLogin);
				usrLogin.setVisible(true);
			}
		});
	}
}
