package com.gui;

import com.user.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class UsrLogin extends guiCustoms {
	
	// declare the variables to be used in the class
	static UserStudent user;
	JPanel usrLogin;
	JLabel lLogo,lUser,lPswrd,lTitle;
	Icon icnPfp;
	JLabel lLoginTtl;
	JTextField tfUser;
	JPasswordField tfPswrd;
	JButton bLogin;
	JButton bCrtUser;
	Font gothamBook,gothamBookBold;
	
	// create custom exceptions that call a pop-up window whenever thrown
	class BlankTextFieldException extends Exception {
		public BlankTextFieldException(String textFieldName, JPanel parentPane) {
			CustomDialog cd = new CustomDialog("Error", "Empty " + textFieldName, parentPane, "OK", paneRed); 
		}
	} class UserDoesNotExist extends Exception {
		public UserDoesNotExist(String passedUname, JPanel parentPane) {
			CustomDialog cd = new CustomDialog("Error", "User "+passedUname+" does not exist!", parentPane, "OK", paneRed);
		}
	}
	
	public UsrLogin() {
		
		// load custom fonts
		try {	
			InputStream isgotham = getClass().getResourceAsStream("/res/fonts/GothamBook.ttf");
			InputStream isgothamBold = getClass().getResourceAsStream("/res/fonts/GothamBold.ttf");
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, isgotham);
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, isgothamBold);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBook); 
			ge.registerFont(gothamBookBold); 
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(FontFormatException ffe) {
			ffe.printStackTrace();
		}
		
		/* 
		 * since this class extends the guiCustoms class, 
		 * and that class extends the JPanel,
		 * therefore we need to set the JPanel attributes in this class
		 */
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		// create another JPanel that will sit on top of the main JPanel; to allow switching of windows easily
		usrLogin = new JPanel();
		usrLogin.setPreferredSize(new Dimension(1280, 720));
		usrLogin.setBackground(bgColor);
		usrLogin.setBounds(0, 0, 1280, 720);
		usrLogin.setLayout(null);
		
		// from here, we build the UI
		lLogo = new JLabel();
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/gwalogo2.png"));
			icnPfp = new ImageIcon(myImage);
			lLogo.setIcon(icnPfp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		tfUser.setBorder(BorderFactory.createEmptyBorder());
		tfUser.setName("Username");
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
		tfPswrd.setBorder(BorderFactory.createEmptyBorder());
		tfPswrd.setName("Password");
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
		// end of UI building
		
		// drive the first focus away from the Username text field
		usrLogin.setFocusable(true);
		usrLogin.requestFocus();
		
		// add to main JPanel and set to visible
		add(usrLogin);
		setVisible(true);
		
		/*
		 * set listeners for the text fields;
		 * because the text fields come with a preset text,
		 * when the content is still not changed, we want the program to auto clear it for us,
		 * but if blank/whitespace has been inputted, it returns with its preset text
		 */
		tfUser.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (tfUser.getText().equals("Username"))
		    		tfUser.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if (tfUser.getText().isBlank())
		        	tfUser.setText("Username");
		    }
		});
		
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
		
		// listener for account creation
		bCrtUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsrCreate usrCreate = new UsrCreate();
				usrCreate.setPreferredSize(new Dimension(1280, 720));
				usrCreate.setBounds(0, 0, 1280, 720);
				
				usrLogin.setVisible(false);
				add(usrCreate);
				usrCreate.setVisible(true);
			}
		});
		
		// set listener for login button
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// declare variables
				File loginCreds = null;
				BufferedReader br = null;
				InputStream is = null;
				int unameLoc = 0;
				
				// check whether the usr-login-creds.txt exists
				try {
					loginCreds = new File("usr-login-creds.txt");
					br = new BufferedReader(new FileReader(loginCreds));
				} catch (FileNotFoundException e1) {
					CustomDialog cd = new CustomDialog("No user found!", "Please create an account.", usrLogin,"OK", paneRed);
					bCrtUser.requestFocus();
					return ;
				}
				
				/* * * * explain user creation first * * * */
				
				try {
					
					/*
					 * declare an array list to compile everyline in the text file
					 * then username and password array list to sort these entries
					 */
					ArrayList al = new ArrayList();
	                ArrayList username = new ArrayList();
	                ArrayList password = new ArrayList();
	                
	                // check whether the file exists, but is empty
	                String line1 = br.readLine();
	                if (line1.trim().isBlank()) {
	                	CustomDialog cd = new CustomDialog("No user found!", "Please create an account.", usrLogin,"OK", paneRed);
						bCrtUser.requestFocus();
	                }
	                
	                // for every line in the file, add the strings to the everything-arraylist
	                while (line1 != null)  {
	                    al.add(line1);
	                    line1 = br.readLine();
	                }
	                
	                // add the even lines as usernames, the odd lines as passwords
	                for (int x = 0; x < al.size(); x++) {
	                	if (x%2 == 0) {
	                		username.add(al.get(x));
		                    continue;
	                	
	                	} else {    
	                		password.add(al.get(x));
	                		continue;
	                    }
	                }
	                
	                // check the validiy of inputs in the text fields
	                for (int x = 0; x < username.size(); x++) {
	                	if (tfUser.getText().isBlank() || tfUser.getText().equals("Username"))
	                		throw new BlankTextFieldException(tfUser.getName(),usrLogin);
	                	
	                	else if(tfUser.getText().equals(username.get(x))) {
	                		unameLoc = x;
	                		break;
	                	
	                	} else if (!tfUser.getText().equals(username.get(x)) && x==(username.size()-1))
	                		throw new UserDoesNotExist(tfUser.getText(),usrLogin);
	                	
	                	else if (!tfUser.getText().equals(username.get(x)));
	                		continue;
	                }
		                
	                // to reset, we close the BR then re-open it
					br.close();
					br = new BufferedReader(new FileReader(loginCreds)); 
					
					// then, check whether the inputs has corresponding data within the text file of user credentials
					if (tfUser.getText().equals(username.get(unameLoc)) && tfPswrd.getText().equals(password.get(unameLoc))) {
						
						// create the static variable user
						user = new UserStudent(tfUser.getText(), tfPswrd.getText());
						CoursePicker cp = new CoursePicker();
			            cp.setPreferredSize(new Dimension(1280, 720));
			            cp.setBounds(0, 0, 1280, 720);
		            
			            usrLogin.setVisible(false);
			            add(cp);
			            cp.setVisible(true);
			            
					} else {
						CustomDialog cd = new CustomDialog("Incorrect Info!", "The password you’ve entered for " + username.get(unameLoc) + " is incorrect", usrLogin,"OK", paneRed);
					}
				
				// catch errors and produce feedback panes
				} catch (IOException e1) {
					e1.printStackTrace();
				
				} catch (BlankTextFieldException btfe) {
					btfe.printStackTrace();
					
				} catch (UserDoesNotExist udne) {
					udne.printStackTrace();
					
				}
			}
		});
	}
	
}
